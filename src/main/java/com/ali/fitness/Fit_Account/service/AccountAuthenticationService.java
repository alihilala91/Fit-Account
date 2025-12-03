package com.ali.fitness.Fit_Account.service;


import com.ali.fitness.Fit_Account.entity.AccountAuthentication;
import com.ali.fitness.Fit_Account.repository.AccountAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountAuthenticationService {

    private final AccountAuthenticationRepository accountAuthenticationRepository;


    /**
     * Save Account Authentication to Database
     *
     * @param accountAuthentication AccountAuthentication
     * @return AccountAuthentication
     */
    public AccountAuthentication save(final AccountAuthentication accountAuthentication) {

        // Save Account Authentication into Database
        return accountAuthenticationRepository.save(accountAuthentication);
    }


}
