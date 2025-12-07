package com.ali.fitness.Fit_Account.service;


import com.ali.fitness.Fit_Account.entity.lookup.AccountTypeLookup;
import com.ali.fitness.Fit_Account.enums.AccountTypeLookupStatusEnums;
import com.ali.fitness.Fit_Account.exception.ExceptionKey;
import com.ali.fitness.Fit_Account.exception.ResourceException;
import com.ali.fitness.Fit_Account.repository.AccountTypeLookupRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
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
