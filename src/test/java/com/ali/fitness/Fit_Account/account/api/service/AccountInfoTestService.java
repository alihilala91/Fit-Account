package com.ali.fitness.Fit_Account.account.api.service;

import com.ali.fitness.Fit_Account.entity.AccountInfo;
import com.ali.fitness.Fit_Account.exception.ExceptionKey;
import com.ali.fitness.Fit_Account.exception.ResourceException;
import com.ali.fitness.Fit_Account.repository.AccountInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AccountInfoTestService {


    private final AccountInfoRepository accountInfoRepository;


    public void deleteAll() {
        accountInfoRepository.deleteAll();
    }


    /**
     * Find Account Info By Identification type and Value
     *
     * @param identificationNumber identificationNumber
     * @param identificationType   identificationType
     * @return AccountInfo
     */
    public AccountInfo findByIdentification(final String identificationNumber,
                                            final String identificationType) {

        return accountInfoRepository.findByIdentificationDetails(identificationNumber, identificationType)
                .orElseThrow(() -> new ResourceException(ExceptionKey.ACCOUNT_NOT_EXISTS,
                        HttpStatus.NOT_FOUND, Locale.ENGLISH));

    }
}
