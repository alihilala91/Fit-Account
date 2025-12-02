package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.lookup.AccountRoleLookup;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleLookupRepository extends JpaRepository<@NonNull AccountRoleLookup, @NonNull Long> {
}
