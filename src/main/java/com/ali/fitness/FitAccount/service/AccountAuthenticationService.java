package com.ali.fitness.FitAccount.service;


import com.ali.fitness.FitAccount.entity.AccountAuthentication;
import com.ali.fitness.FitAccount.repository.AccountAuthenticationRepository;
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
