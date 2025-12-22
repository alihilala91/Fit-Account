package com.ali.fitness.FitAccount.service;

import com.ali.fitness.FitAccount.entity.lookup.IdentificationTypeLookup;
import com.ali.fitness.FitAccount.enums.IdentificationTypeLookupStatusEnums;
import com.ali.fitness.FitAccount.exception.ExceptionKey;
import com.ali.fitness.FitAccount.exception.ResourceException;
import com.ali.fitness.FitAccount.repository.IdentificationTypeLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;

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


    /**
     * Find Identification Type By Code
     * Return Active Identification Type code
     *
     * @param identificationType identificationType
     * @param locale             Locale
     * @return IdentificationTypeLookup
     */
    public IdentificationTypeLookup findByCode(final String identificationType, final Locale locale) {

        return identificationTypeLookupRepository
                .findByCodeAndStatus(identificationType, IdentificationTypeLookupStatusEnums.ACTIVE.name())
                .orElseThrow(() -> new ResourceException(ExceptionKey.IDENTIFICATION_TYPE_NOTFOUND,
                        HttpStatus.NOT_FOUND, locale));


    }
}
