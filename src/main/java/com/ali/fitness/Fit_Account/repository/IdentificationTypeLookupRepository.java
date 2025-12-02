package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.lookup.IdentificationTypeLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentificationTypeLookupRepository extends JpaRepository<IdentificationTypeLookup, Long> {
}
