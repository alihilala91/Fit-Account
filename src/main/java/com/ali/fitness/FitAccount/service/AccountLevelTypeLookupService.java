package com.ali.fitness.FitAccount.service;


import com.ali.fitness.FitAccount.entity.lookup.AccountLevelTypeLookup;
import com.ali.fitness.FitAccount.exception.ExceptionKey;
import com.ali.fitness.FitAccount.exception.ResourceException;
import com.ali.fitness.FitAccount.repository.AccountLevelTypeLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AccountLevelTypeLookupService {


    private final AccountLevelTypeLookupRepository accountLevelTypeLookupRepository;


    /**
     * Save AccountLevelTypeLookup into Database
     *
     * @param accountLevelTypeLookup AccountLevelTypeLookup
     * @return AccountLevelTypeLookup
     */
    public AccountLevelTypeLookup save(final AccountLevelTypeLookup accountLevelTypeLookup) {

        // SAve Account Level Lookup into Database
        return accountLevelTypeLookupRepository.save(accountLevelTypeLookup);
    }

    /**
     * Find Account Level By code
     *
     * @param code   Code
     * @param locale Locale
     * @return AccountLevelTypeLookup
     */
    public AccountLevelTypeLookup findByCode(final String code,
                                             final Locale locale) {

        return accountLevelTypeLookupRepository.findByCode(code)
                .orElseThrow(() -> new ResourceException(ExceptionKey.ACCOUNT_LEVEL_NOT_FOUND,
                        HttpStatus.NOT_FOUND, locale));
    }
}
