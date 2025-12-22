package com.ali.fitness.FitAccount.service;


import com.ali.fitness.FitAccount.entity.AccountNumberFactory;
import com.ali.fitness.FitAccount.enums.AccountNumberFactoryStatusEnums;
import com.ali.fitness.FitAccount.repository.AccountNumberFactoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class AccountNumberFactoryService {

    private final AccountNumberFactoryRepository accountNumberFactoryRepository;


    /**
     * Generate Account Number Depends on the Database ID Sequence
     * example:2025120000001
     *
     * @return accountNumber
     */
    public String createAccountNumber() {

        // Save first to generate sequence ID
        AccountNumberFactory accountNumberFactory = AccountNumberFactory.builder()
                .status(AccountNumberFactoryStatusEnums.ACTIVE.name())
                .build();

        accountNumberFactory = accountNumberFactoryRepository.save(accountNumberFactory);

        // Generate account number
        accountNumberFactory.setAccountNumber(generateAccountNumber(accountNumberFactory.getId()));

        // Update entity
        accountNumberFactory = accountNumberFactoryRepository.save(accountNumberFactory);

        return accountNumberFactory.getAccountNumber();
    }


    /**
     * Adding the Prefix to the Account Number
     *
     * @param sequenceId sequenceId
     * @return String
     */
    private String generateAccountNumber(Long sequenceId) {
        final LocalDate now = LocalDate.now();

        final String yearMonth = now.format(DateTimeFormatter.ofPattern("yyyyMM")); // ex: 202512
        final String paddedSeq = String.format("%07d", sequenceId); //ex:0000001

        return yearMonth + paddedSeq;
    }
}
