package com.ali.fitness.FitAccount.service;


import com.ali.fitness.FitAccount.entity.lookup.AccountRoleLookup;
import com.ali.fitness.FitAccount.enums.AccountRoleLookupStatusEnums;
import com.ali.fitness.FitAccount.exception.ExceptionKey;
import com.ali.fitness.FitAccount.exception.ResourceException;
import com.ali.fitness.FitAccount.repository.AccountRoleLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AccountRoleLookupService {


    private final AccountRoleLookupRepository accountRoleLookupRepository;


    /**
     * Save AccountRoleLookup into Database
     *
     * @param accountRoleLookup AccountRoleLookup
     * @return AccountRoleLookup
     */
    public AccountRoleLookup save(final AccountRoleLookup accountRoleLookup) {

        // Save Account role Lookup into Database
        return accountRoleLookupRepository.save(accountRoleLookup);
    }

    /**
     * Find Active Account Role by Code, And Status
     *
     * @param accountRole Code
     * @param locale      Locale
     * @return AccountRoleLookup
     */
    public AccountRoleLookup findByCode(final String accountRole, final Locale locale) {
        return accountRoleLookupRepository.findByCodeAndStatus(accountRole, AccountRoleLookupStatusEnums.ACTIVE.name())
                .orElseThrow(() -> new ResourceException(ExceptionKey.ACCOUNT_ROLE_NOT_FOUND,
                        HttpStatus.NOT_FOUND, locale));
    }
}
