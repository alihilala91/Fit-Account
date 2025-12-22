package com.ali.fitness.FitAccount.repository;

import com.ali.fitness.FitAccount.entity.lookup.AccountTypeLookup;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountTypeLookupRepository extends JpaRepository<@NonNull AccountTypeLookup, @NonNull Long> {

    Optional<AccountTypeLookup> findByCodeAndStatus(String code, String status);
}
