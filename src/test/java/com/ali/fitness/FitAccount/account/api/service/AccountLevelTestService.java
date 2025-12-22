package com.ali.fitness.FitAccount.account.api.service;

import com.ali.fitness.FitAccount.entity.AccountLevel;
import com.ali.fitness.FitAccount.enums.AccountLevelStatusEnums;
import com.ali.fitness.FitAccount.exception.ExceptionKey;
import com.ali.fitness.FitAccount.exception.ResourceException;
import com.ali.fitness.FitAccount.repository.AccountLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AccountLevelTestService {

    private final AccountLevelRepository accountLevelRepository;


    /**
     * Find Account Level By Account Number and Level Code
     *
     * @param accountNumber Account Number
     * @param levelCode     Level Code
     * @return AccountLevel
     */
    public AccountLevel findByAccountAndLevelCode(String accountNumber, String levelCode) {

        return accountLevelRepository.findByAccountNumberAndLevelCode(accountNumber, levelCode,
                        AccountLevelStatusEnums.ACTIVE.name())
                .orElseThrow(() -> new ResourceException(ExceptionKey.ACCOUNT_LEVEL_NOT_FOUND,
                        HttpStatus.NOT_FOUND,
                        Locale.ENGLISH));

    }

    /**
     * Delete All Record
     */
    public void deleteAll() {

        accountLevelRepository.deleteAll();
    }
}
