package com.ali.fitness.Fit_Account.service;


import com.ali.fitness.Fit_Account.entity.lookup.IdentificationTypeLookup;
import com.ali.fitness.Fit_Account.repository.IdentificationTypeLookupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class IdentificationTypeLookupService {


    private final IdentificationTypeLookupRepository identificationTypeLookupRepository;

    public IdentificationTypeLookupService(IdentificationTypeLookupRepository identificationTypeLookupRepository) {
        this.identificationTypeLookupRepository = identificationTypeLookupRepository;
    }

    /**
     * Save Identification Type Lookup into Database
     *
     * @param identificationTypeLookup IdentificationTypeLookup
     * @return IdentificationTypeLookup
     */
    public IdentificationTypeLookup save(final IdentificationTypeLookup identificationTypeLookup) {

        // Save Identification Type Lookup into Database
        return identificationTypeLookupRepository.save(identificationTypeLookup);
    }
}
