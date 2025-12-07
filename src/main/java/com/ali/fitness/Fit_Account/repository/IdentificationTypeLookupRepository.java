package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.lookup.IdentificationTypeLookup;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdentificationTypeLookupRepository extends JpaRepository<@NonNull IdentificationTypeLookup,
        @NonNull Long> {

    Optional<IdentificationTypeLookup> findByCodeAndStatus(String code, String status);
}
