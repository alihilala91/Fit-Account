package com.ali.fitness.Fit_Account.service;


import com.ali.fitness.Fit_Account.entity.AccountInfo;
import com.ali.fitness.Fit_Account.repository.AccountInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountInfoService {


    private final AccountInfoRepository accountInfoRepository;

    /**
     * Save Account Info in Database
     *
     * @param accountInfo AccountInfo
     * @return AccountInfo
     */
    public AccountInfo save(final AccountInfo accountInfo) {

        // Save AccountInfo into Database
        return accountInfoRepository.save(accountInfo);
    }
}
