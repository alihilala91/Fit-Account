package com.ali.fitness.FitAccount.repository;

import com.ali.fitness.FitAccount.entity.lookup.AccountRoleLookup;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRoleLookupRepository extends JpaRepository<@NonNull AccountRoleLookup, @NonNull Long> {

    Optional<AccountRoleLookup> findByCodeAndStatus(String code, String status);
}
