package com.ali.fitness.Fit_Account.service;


import com.ali.fitness.Fit_Account.entity.AccountInfo;
import com.ali.fitness.Fit_Account.exception.ExceptionKey;
import com.ali.fitness.Fit_Account.exception.ResourceException;
import com.ali.fitness.Fit_Account.filter.AccountInfoSpecs;
import com.ali.fitness.Fit_Account.repository.AccountInfoRepository;
import com.ali.fitness.Fit_Account.repository.pojo.AllAccountPojo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AccountInfoService {


    private final AccountInfoRepository accountInfoRepository;

    /**
     * Save Account Info in Database
     *
     * @param accountInfo AccountInfo
     * @return AccountInfo
     */
    public AccountInfo save(final AccountInfo accountInfo) {

        // Save AccountInfo into Database
        return accountInfoRepository.save(accountInfo);
    }


    /**
     * Validate if Account Exists By Account type , Identification Number, Identification type
     *
     * @param accountType          accountType
     * @param identificationNumber identificationNumber
     * @param identificationType   identificationType
     * @return Boolean
     */
    public Boolean accountExists(final String accountType,
                                 final String identificationNumber,
                                 final String identificationType) {

        return accountInfoRepository
                .existsByIdentificationNumberAndIdentificationType_CodeAndAccountType_Code(identificationNumber,
                        identificationType, accountType);


    }

    /**
     * Fetch Account Details By Account Number
     *
     * @param accountNumber Account Number
     * @param locale        Locale
     * @return AccountInfo
     */
    public AccountInfo findByAccountNumber(final String accountNumber, final Locale locale) {

        // Fetch Account Info by Account Number
        return accountInfoRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceException(ExceptionKey.ACCOUNT_NOT_EXISTS,
                        HttpStatus.NOT_FOUND, locale));
    }

    /**
     * Find All Account
     *
     * @param accountNumber        accountNumber
     * @param firstName            firstName
     * @param middleName           middleName
     * @param lastName             lastName
     * @param mobile               mobile
     * @param identificationNumber identificationNumber
     * @param pageable             pageable
     * @return AllAccountPojo
     */
    public Page<@NonNull AccountInfo> findAllAccount(final String accountNumber,
                                                     final String firstName,
                                                     final String middleName,
                                                     final String lastName,
                                                     final String mobile,
                                                     final String identificationNumber,
                                                     final Pageable pageable) {

        // find All Account
        return accountInfoRepository.findAll(
                AccountInfoSpecs.filter(
                        accountNumber,
                        firstName,
                        middleName,
                        lastName,
                        mobile,
                        identificationNumber
                ),
                pageable);


    }

    /**
     * Method Delete All Account
     * Used Only for Test
     */
    public void deleteAll() {
        accountInfoRepository.deleteAll();
    }
}
