package com.ali.fitness.Fit_Account.service;


import com.ali.fitness.Fit_Account.entity.lookup.AccountStatusLookup;
import com.ali.fitness.Fit_Account.repository.AccountStatusLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountStatusLookupService {

    private final AccountStatusLookupRepository accountStatusLookupRepository;


    /**
     * Save Account Status Lookup into Database
     * @param accountStatusLookup AccountStatusLookup
     * @return AccountStatusLookup
     */
    public AccountStatusLookup save(final AccountStatusLookup accountStatusLookup) {

        // Save Account Status into Lookup
        return accountStatusLookupRepository.save(accountStatusLookup);
    }
}
