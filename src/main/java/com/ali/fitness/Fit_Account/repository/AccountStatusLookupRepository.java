package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.lookup.AccountStatusLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStatusLookupRepository extends JpaRepository<AccountStatusLookup, Long> {
}
