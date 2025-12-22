package com.ali.fitness.FitAccount.service;


import com.ali.fitness.FitAccount.entity.lookup.AccountTypeLookup;
import com.ali.fitness.FitAccount.enums.AccountTypeLookupStatusEnums;
import com.ali.fitness.FitAccount.exception.ExceptionKey;
import com.ali.fitness.FitAccount.exception.ResourceException;
import com.ali.fitness.FitAccount.repository.AccountTypeLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AccountTypeLookupService {


    private final AccountTypeLookupRepository accountTypeLookupRepository;


    /**
     * Save Account Type Lookup into Database
     *
     * @param accountTypeLookup AccountTypeLookup
     * @return AccountTypeLookup
     */
    public AccountTypeLookup save(final AccountTypeLookup accountTypeLookup) {

        // Save Account Type Lookup into Database
        return accountTypeLookupRepository.save(accountTypeLookup);
    }

    /**
     * Find Account type By code
     * Return Active Account Type code
     *
     * @param accountType accountType
     * @param locale      Locale
     * @return AccountTypeLookup
     */
    public AccountTypeLookup getByCode(final String accountType, final Locale locale) {

        return accountTypeLookupRepository.findByCodeAndStatus(accountType, AccountTypeLookupStatusEnums.ACTIVE.name())
                .orElseThrow(() -> new ResourceException(ExceptionKey
                        .ACCOUNT_TYPE_NOT_FOUND, HttpStatus.NOT_FOUND, locale));
    }
}
