package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.lookup.AccountStatusLookup;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountStatusLookupRepository extends JpaRepository<@NonNull AccountStatusLookup, @NonNull Long> {

    Optional<AccountStatusLookup> findByCodeAndStatus(String code, String status);
}
