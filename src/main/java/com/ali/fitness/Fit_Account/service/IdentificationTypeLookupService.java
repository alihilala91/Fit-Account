package com.ali.fitness.Fit_Account.service;

import com.ali.fitness.Fit_Account.entity.lookup.IdentificationTypeLookup;
import com.ali.fitness.Fit_Account.enums.IdentificationTypeLookupStatusEnums;
import com.ali.fitness.Fit_Account.exception.ExceptionKey;
import com.ali.fitness.Fit_Account.exception.ResourceException;
import com.ali.fitness.Fit_Account.repository.IdentificationTypeLookupRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

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
