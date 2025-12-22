package com.ali.fitness.FitAccount.controller;

import com.ali.fitness.FitAccount.entity.lookup.IdentificationTypeLookup;
import com.ali.fitness.FitAccount.service.IdentificationTypeLookupService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/employees")
@RequiredArgsConstructor
public class TestController {

    @NotNull
    private final IdentificationTypeLookupService identificationTypeLookupService;


    @PostMapping
    public ResponseEntity<String> create(
            final HttpServletRequest request) {

        identificationTypeLookupService.save(IdentificationTypeLookup.builder().build());

        // Return Response
        return new ResponseEntity<>("done", HttpStatus.CREATED);

    }
}
