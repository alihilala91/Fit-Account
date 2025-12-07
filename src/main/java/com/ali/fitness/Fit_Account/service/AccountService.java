package com.ali.fitness.Fit_Account.service;

import com.ali.fitness.Fit_Account.dto.account.create.request.AccountCreationRequest;
import com.ali.fitness.Fit_Account.dto.account.create.response.AccountCreationResponse;
import com.ali.fitness.Fit_Account.entity.AccountInfo;
import com.ali.fitness.Fit_Account.entity.lookup.AccountRoleLookup;
import com.ali.fitness.Fit_Account.entity.lookup.AccountStatusLookup;
import com.ali.fitness.Fit_Account.entity.lookup.AccountTypeLookup;
import com.ali.fitness.Fit_Account.entity.lookup.IdentificationTypeLookup;
import com.ali.fitness.Fit_Account.enums.AccountInfoStatusEnums;
import com.ali.fitness.Fit_Account.enums.GeneralAccountStatusEnums;
import com.ali.fitness.Fit_Account.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.UUID;

/**
 * Service to Manage All The Account Service API
 * Related To Controller AccountController
 */
@Service
@RequiredArgsConstructor
public class AccountService {

    private final IdentificationTypeLookupService identificationTypeLookupService;
    private final AccountTypeLookupService accountTypeLookupService;
    private final AccountRoleLookupService accountRoleLookupService;
    private final AccountInfoService accountInfoService;
    private final AccountStatusLookupService accountStatusLookupService;

    /**
     * Create Account
     *
     * @param accountCreationRequest AccountCreationRequest
     * @param servletRequest         HttpServletRequest
     * @return AccountCreationResponse
     */
    public AccountCreationResponse createAccount(final AccountCreationRequest accountCreationRequest,
                                                 final HttpServletRequest servletRequest) {

        // Fetch Request Local
        final Locale locale = Utils.getLocale(servletRequest);

        // Request Data Validation
        validateCreationRequest(accountCreationRequest);

        // Find Identification Type
        final IdentificationTypeLookup identificationType = identificationTypeLookupService
                .findByCode(accountCreationRequest.getIdentificationType(), locale);

        // Find Account Type
        final AccountTypeLookup accountType = accountTypeLookupService
                .getByCode(accountCreationRequest.getAccountType(), locale);

        // Find Account Role
        final AccountRoleLookup accountRole = accountRoleLookupService
                .findByCode(accountCreationRequest.getAccountRole(), locale);

        final AccountStatusLookup accountStatusLookup = accountStatusLookupService
                .findByCodeAndStatus(GeneralAccountStatusEnums.CUSTOMER_ACTIVE.name(),
                        AccountInfoStatusEnums.ACTIVE.name(), locale);

        // Create Account Number
        final String accountNumber = UUID.randomUUID().toString();  // ToDo need to generate the Account Number in Different way

        // Start Create Account with Status Active
        AccountInfo accountInfo = accountInfoService.save(AccountInfo.builder()
                .accountNumber(accountNumber)
                .firstName(accountCreationRequest.getFirstName().toUpperCase()) // Name will be saved in Upper Case
                .middleName(accountCreationRequest.getMiddleName().toUpperCase()) // Name will be saved in Upper Case
                .lastName(accountCreationRequest.getLastName().toUpperCase()) // Name will be saved in Upper Case
                .email(accountCreationRequest.getEmail())
                .mobile(Utils.formatMobileNumber(accountCreationRequest.getMobile(), locale))
                .identificationNumber(accountCreationRequest.getIdentificationNumber())
                .identificationType(identificationType)
                .accountType(accountType)
                .accountRole(accountRole)
                .status(accountStatusLookup)
                .build());

        // Response Mapping

        return null;

    }

    private void validateCreationRequest(final AccountCreationRequest accountCreationRequest) {
    }

}
