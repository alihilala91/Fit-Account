package com.ali.fitness.Fit_Account.account.api.create;

import com.ali.fitness.Fit_Account.account.api.dto.request.AccountRequestDTO;
import com.ali.fitness.Fit_Account.FitAccountApplicationTests;
import com.ali.fitness.Fit_Account.account.api.service.AccountInfoTestService;
import com.ali.fitness.Fit_Account.dto.account.create.request.AccountCreationRequest;
import com.ali.fitness.Fit_Account.entity.AccountInfo;
import com.ali.fitness.Fit_Account.entity.lookup.AccountRoleLookup;
import com.ali.fitness.Fit_Account.entity.lookup.AccountStatusLookup;
import com.ali.fitness.Fit_Account.entity.lookup.AccountTypeLookup;
import com.ali.fitness.Fit_Account.entity.lookup.IdentificationTypeLookup;
import com.ali.fitness.Fit_Account.enums.AccountInfoStatusEnums;
import com.ali.fitness.Fit_Account.enums.AccountRoleLookupStatusEnums;
import com.ali.fitness.Fit_Account.enums.AccountTypeLookupStatusEnums;
import com.ali.fitness.Fit_Account.enums.GeneralAccountStatusEnums;
import com.ali.fitness.Fit_Account.enums.IdentificationTypeLookupStatusEnums;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CreateAccountAPITest extends FitAccountApplicationTests {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTestClient restClient;

    @Autowired
    private AccountInfoTestService accountInfoTestService;

    /**
     * Test the Happy Case Senior For Create Employee
     * Result: Employee Created Successfully
     */
    @Test
    public void testNormalFlow() throws Exception {


        // Delete All Saved Account Data
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


        // Assert the Result is True ( actualEmployee == exceptedEmployee)
        assertThat(actualAccountInfo.equals(expectedAccountInfo))
                .isTrue();

    }
}
