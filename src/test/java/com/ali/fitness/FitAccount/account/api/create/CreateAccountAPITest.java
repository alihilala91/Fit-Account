package com.ali.fitness.FitAccount.account.api.create;

import com.ali.fitness.FitAccount.account.api.dto.request.AccountRequestDTO;
import com.ali.fitness.FitAccount.FitAccountApplicationTests;
import com.ali.fitness.FitAccount.account.api.service.AccountInfoTestService;
import com.ali.fitness.FitAccount.account.api.service.AccountLevelTestService;
import com.ali.fitness.FitAccount.dto.account.create.request.AccountCreationRequest;
import com.ali.fitness.FitAccount.entity.AccountInfo;
import com.ali.fitness.FitAccount.entity.AccountLevel;
import com.ali.fitness.FitAccount.entity.lookup.AccountLevelTypeLookup;
import com.ali.fitness.FitAccount.entity.lookup.AccountRoleLookup;
import com.ali.fitness.FitAccount.entity.lookup.AccountStatusLookup;
import com.ali.fitness.FitAccount.entity.lookup.AccountTypeLookup;
import com.ali.fitness.FitAccount.entity.lookup.IdentificationTypeLookup;
import com.ali.fitness.FitAccount.enums.AccountInfoStatusEnums;
import com.ali.fitness.FitAccount.enums.AccountLevelEnums;
import com.ali.fitness.FitAccount.enums.AccountLevelStatusEnums;
import com.ali.fitness.FitAccount.enums.AccountRoleLookupStatusEnums;
import com.ali.fitness.FitAccount.enums.AccountTypeLookupStatusEnums;
import com.ali.fitness.FitAccount.enums.GeneralAccountStatusEnums;
import com.ali.fitness.FitAccount.enums.IdentificationTypeLookupStatusEnums;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CreateAccountAPITest extends FitAccountApplicationTests {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTestClient restClient;

    @Autowired
    private AccountInfoTestService accountInfoTestService;

    @Autowired
    private AccountLevelTestService accountLevelTestService;

    /**
     * Test the Happy Case Senior For Create Account
     * Result: Employee Created Successfully
     */
    @Test
    public void testNormalFlow() throws Exception {



        // Delete All Saved Account Data
        accountLevelTestService.deleteAll();
        accountInfoTestService.deleteAll();

        // Prepare Create Account Request
        final AccountCreationRequest request = AccountRequestDTO.normalFlow();

        // Mapping Request as JSON
        final String requestDetails = objectMapper.writeValueAsString(request);

        // Call Create Account API
        restClient.post()
                .uri("/v1/api/account")
                .contentType(MediaType.APPLICATION_JSON)
                .body(requestDetails)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);


        // Get the Actual Created Account
        final AccountInfo actualAccountInfo = accountInfoTestService.findByIdentification(
                request.getIdentificationNumber(),
                request.getIdentificationType());


        // Create the Excepted Account
        AccountInfo expectedAccountInfo = AccountInfo.builder()
                .accountNumber(actualAccountInfo.getAccountNumber())  // Same as the Actual
                .firstName(request.getFirstName().toUpperCase())
                .middleName(request.getMiddleName().toUpperCase())
                .lastName(request.getLastName().toUpperCase())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .identificationNumber(request.getIdentificationNumber())
                .identificationType(IdentificationTypeLookup.builder()
                        .code(request.getIdentificationType())
                        .status(IdentificationTypeLookupStatusEnums.ACTIVE.name())
                        .build())
                .accountType(AccountTypeLookup.builder()
                        .code(request.getAccountType())
                        .status(AccountTypeLookupStatusEnums.ACTIVE.name())
                        .build())
                .accountRole(AccountRoleLookup.builder()
                        .code(request.getAccountRole())
                        .status(AccountRoleLookupStatusEnums.ACTIVE.name())
                        .build())
                .status(AccountStatusLookup.builder()
                        .code(GeneralAccountStatusEnums.CUSTOMER_ACTIVE.name())
                        .status(AccountInfoStatusEnums.ACTIVE.name())
                        .build())
                .build();


        // Find Account Level by Account Number and Level Code
        AccountLevel actualAccountLevel = accountLevelTestService.findByAccountAndLevelCode(
                actualAccountInfo.getAccountNumber(),
                AccountLevelEnums.LEVEL_ONE.name());

        AccountLevel exceptedAccountLevel = AccountLevel.builder()
                .accountInfo(expectedAccountInfo)
                .accountLevelType(AccountLevelTypeLookup.builder()
                        .code(AccountLevelEnums.LEVEL_ONE.name())
                        .build())
                .status(AccountLevelStatusEnums.ACTIVE.name())
                .build();


        // Assert the Result is True ( actualAccount == exceptedAccount)
        assertThat(actualAccountInfo.equals(expectedAccountInfo))
                .isTrue();

        // Assert the Result is True ( actualAccount == exceptedAccountLevel)
        assertThat(actualAccountLevel.equals(exceptedAccountLevel))
                .isTrue();

    }
}
