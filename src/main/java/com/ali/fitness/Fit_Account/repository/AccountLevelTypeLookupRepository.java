package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.lookup.AccountLevelTypeLookup;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountLevelTypeLookupRepository extends JpaRepository<@NonNull AccountLevelTypeLookup,@NonNull Long> {
}
