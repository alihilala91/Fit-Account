package com.ali.fitness.Fit_Account.service;

import com.ali.fitness.Fit_Account.entity.lookup.IdentificationTypeLookup;
import com.ali.fitness.Fit_Account.repository.IdentificationTypeLookupRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service class for managing Identification Type Lookups.
 */
@Service
@RequiredArgsConstructor
public class IdentificationTypeLookupService {


    private final IdentificationTypeLookupRepository identificationTypeLookupRepository;

    /**
     * Save an IdentificationTypeLookup entity into the database.
     *
     * @param identificationTypeLookup the IdentificationTypeLookup entity to save
     * @return the saved IdentificationTypeLookup entity
     */
    public IdentificationTypeLookup save(final IdentificationTypeLookup identificationTypeLookup) {
        return identificationTypeLookupRepository.save(identificationTypeLookup);
    }
}
