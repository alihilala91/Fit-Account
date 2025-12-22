package com.ali.fitness.FitAccount.repository;

import com.ali.fitness.FitAccount.entity.lookup.AccountLevelTypeLookup;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountLevelTypeLookupRepository extends JpaRepository<@NonNull AccountLevelTypeLookup, @NonNull Long> {

    Optional<AccountLevelTypeLookup> findByCode(@NonNull String code);
}
