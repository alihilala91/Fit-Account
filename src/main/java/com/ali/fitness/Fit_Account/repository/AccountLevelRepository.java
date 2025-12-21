package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.AccountInfo;
import com.ali.fitness.Fit_Account.entity.AccountLevel;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountLevelRepository extends JpaRepository<@NonNull AccountLevel, @NonNull Long> {


    @Query(value = "select al.*" +
            " from account.account_level al" +
            "         join account.account_level_type_lookup altl on al.account_level_type_lookup_id = altl.id" +
            "         join account.account_info ai on al.account_info_id = ai.id" +
            " where altl.code = :levelCode" +
            "  and ai.account_number = :accountNumber" +
            "  and al.status = :status"
            , nativeQuery = true)
    Optional<AccountLevel> findByAccountNumberAndLevelCode(@Param("accountNumber") String accountNumber,
                                                           @Param("levelCode") String levelCode,
                                                           @Param("status") String status);
}
