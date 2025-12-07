package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.lookup.AccountTypeLookup;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountTypeLookupRepository extends JpaRepository<@NonNull AccountTypeLookup, @NonNull Long> {

    Optional<AccountTypeLookup> findByCodeAndStatus(String code, String status);
}
