package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.AccountInfo;

import com.ali.fitness.Fit_Account.repository.pojo.AllAccountPojo;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AccountInfoRepository
        extends JpaRepository<AccountInfo, Long>, JpaSpecificationExecutor<AccountInfo> {

    Boolean existsByIdentificationNumberAndIdentificationType_CodeAndAccountType_Code(String identificationNumber,
                                                                                      String identificationType,
                                                                                      String accountType);

    Optional<AccountInfo> findByAccountNumber(String accountNumber);

    @Query(value = "select acc.*" +
            " from account.account_info acc" +
            "         join account.identification_type_lookup itl on acc.identification_type_id = itl.id" +
            " where itl.code = :identificationType" +
            "  and acc.identification_number = :identificationNumber", nativeQuery = true)
    Optional<AccountInfo> findByIdentificationDetails(@Param("identificationNumber") String identificationNumber,
                                            @Param("identificationType") String identificationType);
}
