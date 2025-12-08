package com.ali.fitness.Fit_Account.controller;

import com.ali.fitness.Fit_Account.dto.account.create.request.AccountCreationRequest;
import com.ali.fitness.Fit_Account.dto.account.create.response.AccountCreationResponse;
import com.ali.fitness.Fit_Account.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/account")
@RequiredArgsConstructor
public class AccountController {


    private final AccountService accountService;


    @PostMapping
    public ResponseEntity<AccountCreationResponse> create(
            @RequestBody @Valid final AccountCreationRequest accountCreationRequest,
            final HttpServletRequest request) {

        // Create New Account
        final AccountCreationResponse response = accountService.createAccount(accountCreationRequest, request);

        // Return Response
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    // API for Fetch All Account

    // API for Fetch Account By AccountNumber
}
