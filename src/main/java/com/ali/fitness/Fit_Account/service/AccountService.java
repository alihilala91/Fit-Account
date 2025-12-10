package com.ali.fitness.Fit_Account.service;

import com.ali.fitness.Fit_Account.dto.account.create.request.AccountCreationRequest;
import com.ali.fitness.Fit_Account.dto.account.create.response.AccountCreationResponse;
import com.ali.fitness.Fit_Account.dto.account.fetch.all.FetchAllAccountResponse;
import com.ali.fitness.Fit_Account.dto.account.fetch.single.FetchAccountResponse;
import com.ali.fitness.Fit_Account.entity.AccountInfo;
import com.ali.fitness.Fit_Account.entity.lookup.AccountRoleLookup;
import com.ali.fitness.Fit_Account.entity.lookup.AccountStatusLookup;
import com.ali.fitness.Fit_Account.entity.lookup.AccountTypeLookup;
import com.ali.fitness.Fit_Account.entity.lookup.IdentificationTypeLookup;
import com.ali.fitness.Fit_Account.enums.AccountInfoStatusEnums;
import com.ali.fitness.Fit_Account.enums.GeneralAccountStatusEnums;
import com.ali.fitness.Fit_Account.exception.ExceptionKey;
import com.ali.fitness.Fit_Account.exception.ResourceException;
import com.ali.fitness.Fit_Account.repository.pojo.AllAccountPojo;
import com.ali.fitness.Fit_Account.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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

        // Request Data Validation
        validateCreationRequest(accountCreationRequest, locale);

        // Create Account Number
        final String accountNumber = UUID.randomUUID().toString();  // ToDo need to generate the Account Number in Different way

        // Start Create Account with Status Active
        final AccountInfo accountInfo = accountInfoService.save(AccountInfo.builder()
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
        return AccountCreationResponse.mapping(accountInfo);

    }

    /**
     * Check the Required Validation Before Create Account :
     * 1.Check if Account Exists
     *
     * @param accountCreationRequest AccountCreationRequest
     * @param locale                 Locale
     */
    private void validateCreationRequest(final AccountCreationRequest accountCreationRequest,
                                         final Locale locale) {

        // Validate If Customer Exists
        if (accountInfoService.accountExists(accountCreationRequest.getAccountType(),
                accountCreationRequest.getIdentificationNumber(),
                accountCreationRequest.getIdentificationType())) {
            throw new ResourceException(ExceptionKey.ACCOUNT_ALREADY_EXISTS, HttpStatus.FOUND, locale);
        }
    }

    /**
     * Fetch Account Details By Account Number
     *
     * @param accountNumber AccountNumber
     * @param request       HttpServletRequest
     * @return FetchAccountResponse
     */
    public FetchAccountResponse fetchAccountDetails(final String accountNumber, final HttpServletRequest request) {

        // Find Locale
        final Locale locale = Utils.getLocale(request);

        // Fetch Account By Account Number
        final AccountInfo accountInfo = accountInfoService.findByAccountNumber(accountNumber, locale);

        // Mapping Response
        return FetchAccountResponse.mapping(accountInfo);
    }


    /**
     * Fetch all Account
     *
     * @param accountNumber        accountNumber
     * @param firstName            firstName
     * @param middleName           middleName
     * @param lastName             lastName
     * @param mobile               mobile
     * @param identificationNumber identificationNumber
     * @param request              HttpServletRequest
     * @return FetchAllAccountResponse
     */
    public FetchAllAccountResponse fetchAllAccountDetails(final String accountNumber,
                                                          final String firstName,
                                                          final String middleName,
                                                          final String lastName,
                                                          final String mobile,
                                                          final String identificationNumber,
                                                          final Integer pageNumber,
                                                          final Integer pageSize,
                                                          final HttpServletRequest request) {

        // Find Locale
        final Locale locale = Utils.getLocale(request);

        // Create Pageable Config
        final Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(Sort.Direction.DESC, "update_date"));


        // Fetch All Employee
        final Page<@NonNull AccountInfo> accountInfos = accountInfoService.findAllAccount(
                accountNumber,
                Utils.convertToUpper(firstName, locale),
                Utils.convertToUpper(middleName, locale),
                Utils.convertToUpper(lastName, locale),
                mobile,
                identificationNumber,
                pageable);

        // Mapping Response
        return FetchAllAccountResponse.mapping(accountInfos);


    }
}
