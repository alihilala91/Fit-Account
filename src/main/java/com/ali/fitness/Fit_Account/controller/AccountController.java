package com.ali.fitness.Fit_Account.controller;

import com.ali.fitness.Fit_Account.dto.account.create.request.AccountCreationRequest;
import com.ali.fitness.Fit_Account.dto.account.create.response.AccountCreationResponse;
import com.ali.fitness.Fit_Account.dto.account.fetch.FetchAccountResponse;
import com.ali.fitness.Fit_Account.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    /**
     * Create Account
     *
     * @param accountCreationRequest AccountCreationRequest
     * @param request                HttpServletRequest
     * @return AccountCreationResponse
     */
    @PostMapping
    public ResponseEntity<@NonNull AccountCreationResponse> create(
            @RequestBody @Valid final AccountCreationRequest accountCreationRequest,
            final HttpServletRequest request) {

        // Create New Account
        final AccountCreationResponse response = accountService.createAccount(accountCreationRequest, request);

        // Return Response
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    /**
     * Fetch Account Details by Account Number
     *
     * @param accountNumber Account Number
     * @param request       HttpServletRequest
     * @return FetchAccountResponse
     */
    @GetMapping("/{accountNumber}")
    public ResponseEntity<@NonNull FetchAccountResponse> fetchAccountDetails(
            @PathVariable final String accountNumber,
            final HttpServletRequest request) {

        // Fetch Account Details
        final FetchAccountResponse response = accountService.fetchAccountDetails(accountNumber, request);

        // Return Response
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


    // API for Fetch All Account
}
