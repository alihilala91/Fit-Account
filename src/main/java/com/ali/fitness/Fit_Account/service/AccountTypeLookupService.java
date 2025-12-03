package com.ali.fitness.Fit_Account.service;


import com.ali.fitness.Fit_Account.entity.lookup.AccountTypeLookup;
import com.ali.fitness.Fit_Account.repository.AccountTypeLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
