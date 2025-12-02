package com.ali.fitness.Fit_Account.service;


import com.ali.fitness.Fit_Account.entity.lookup.AccountLevelTypeLookup;
import com.ali.fitness.Fit_Account.repository.AccountLevelTypeLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class AccountLevelTypeLookupService {


    private final AccountLevelTypeLookupRepository accountLevelTypeLookupRepository;

    public AccountLevelTypeLookupService(AccountLevelTypeLookupRepository accountLevelTypeLookupRepository) {
        this.accountLevelTypeLookupRepository = accountLevelTypeLookupRepository;
    }

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
}
