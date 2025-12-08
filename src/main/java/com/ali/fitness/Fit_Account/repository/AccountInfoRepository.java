package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.AccountInfo;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountInfoRepository extends JpaRepository<@NonNull AccountInfo, @NonNull Long> {

    Boolean existsByIdentificationNumberAndIdentificationType_CodeAndAccountType_Code(String identificationNumber,
                                                                                      String identificationType,
                                                                                      String accountType);

    Optional<AccountInfo> findByAccountNumber(String accountNumber);
}
