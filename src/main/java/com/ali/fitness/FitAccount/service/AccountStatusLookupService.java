package com.ali.fitness.FitAccount.service;


import com.ali.fitness.FitAccount.entity.lookup.AccountStatusLookup;
import com.ali.fitness.FitAccount.exception.ExceptionKey;
import com.ali.fitness.FitAccount.exception.ResourceException;
import com.ali.fitness.FitAccount.repository.AccountStatusLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AccountStatusLookupService {

    private final AccountStatusLookupRepository accountStatusLookupRepository;


    /**
     * Save Account Status Lookup into Database
     *
     * @param accountStatusLookup AccountStatusLookup
     * @return AccountStatusLookup
     */
    public AccountStatusLookup save(final AccountStatusLookup accountStatusLookup) {

        // Save Account Status into Lookup
        return accountStatusLookupRepository.save(accountStatusLookup);
    }


    /**
     * Find AccountStatus by Code and Status
     *
     * @param code   Code
     * @param status Status
     * @param locale Locale
     * @return AccountStatusLookup
     */
    public AccountStatusLookup findByCodeAndStatus(final String code, final String status, final Locale locale) {

        return accountStatusLookupRepository.findByCodeAndStatus(code, status)
                .orElseThrow(() -> new ResourceException(ExceptionKey.ACCOUNT_STATUS_NOT_FOUND,
                        HttpStatus.NOT_FOUND, locale));

    }
}
