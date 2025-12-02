package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.lookup.AccountRoleLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleLookupRepository extends JpaRepository<AccountRoleLookup, Integer> {
}
