package com.ali.fitness.Fit_Account.service;


import com.ali.fitness.Fit_Account.entity.lookup.AccountRoleLookup;
import com.ali.fitness.Fit_Account.repository.AccountRoleLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
