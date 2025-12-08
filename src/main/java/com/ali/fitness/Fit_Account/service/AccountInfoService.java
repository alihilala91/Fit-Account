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


    /**
     * Validate if Account Exists By Account type , Identification Number, Identification type
     *
     * @param accountType          accountType
     * @param identificationNumber identificationNumber
     * @param identificationType   identificationType
     * @return Boolean
     */
    public Boolean accountExists(final String accountType,
                                 final String identificationNumber,
                                 final String identificationType) {

        return accountInfoRepository
                .existsByIdentificationNumberAndIdentificationType_CodeAndAccountType_Code(identificationNumber,
                        identificationType, accountType);


    }
}
