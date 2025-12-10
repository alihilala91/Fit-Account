package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.AccountInfo;

import com.ali.fitness.Fit_Account.repository.pojo.AllAccountPojo;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountInfoRepository extends JpaRepository<@NonNull AccountInfo, @NonNull Long> {

    Boolean existsByIdentificationNumberAndIdentificationType_CodeAndAccountType_Code(String identificationNumber,
                                                                                      String identificationType,
                                                                                      String accountType);

    Optional<AccountInfo> findByAccountNumber(String accountNumber);


    @Query(value = "select ai.account_number        as accountNumber," +
            "       ai.first_name            as firstName," +
            "       ai.last_name             as lastName," +
            "       ai.middle_name           as middleName," +
            "       ai.identification_number as identificationNumber," +
            "       ai.email                 as email," +
            "       ai.mobile                as mobile," +
            "       ai.creation_date         as creationDate," +
            "       idt.code                 as identificationType," +
            "       atl.code                 as accountType," +
            "       arl.code                 as accountRole," +
            "       ast.code                 as status" +
            " from account.account_info ai" +
            "         join account.account_role_lookup arl on ai.account_role_id = arl.id" +
            "         join account.account_status_lookup ast on ai.account_status_id = ast.id" +
            "         join account.identification_type_lookup idt on ai.identification_type_id = idt.id" +
            "         join account.account_type_lookup atl on ai.account_type_id = atl.id" +
            " where (:firstName is null or ai.first_name = :firstName)" +
            "  and (:lastName is null or ai.last_name = :lastName)" +
            "  and (:middleName is null or ai.middle_name = :middleName)" +
            "  and (:mobile is null or ai.mobile = :mobile)" +
            "  and (:identificationNumber is null or ai.identification_number = :identificationNumber)",
            nativeQuery = true)
    Page<AllAccountPojo> findAll(@Param("accountNumber") String accountNumber,
                                 @Param("firstName") String firstName,
                                 @Param("middleName") String middleName,
                                 @Param("lastName") String lastName,
                                 @Param("mobile") String mobile,
                                 @Param("identificationNumber") String identificationNumber,
                                 Pageable pageable);
}
