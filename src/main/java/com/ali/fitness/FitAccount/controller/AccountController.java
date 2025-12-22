package com.ali.fitness.FitAccount.controller;

import com.ali.fitness.FitAccount.constant.SystemConstant;
import com.ali.fitness.FitAccount.dto.account.create.request.AccountCreationRequest;
import com.ali.fitness.FitAccount.dto.account.create.response.AccountCreationResponse;
import com.ali.fitness.FitAccount.dto.account.fetch.all.FetchAllAccountResponse;
import com.ali.fitness.FitAccount.dto.account.fetch.single.FetchAccountResponse;
import com.ali.fitness.FitAccount.service.AccountService;
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
import org.springframework.web.bind.annotation.RequestParam;
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


    /**
     * Fetch All Account
     *
     * @param accountNumber        accountNumber
     * @param firstName            firstName
     * @param middleName           middleName
     * @param lastName             lastName
     * @param mobile               mobile
     * @param identificationNumber identificationNumber
     * @param pageNumber           pageNumber Default 0
     * @param pageSize             pageSize Default 10
     * @param request              HttpServletRequest
     * @return FetchAllAccountResponse
     */
    @GetMapping
    public ResponseEntity<@NonNull FetchAllAccountResponse> fetchAllAccount(
            @RequestParam(required = false, name = "accountNumber") final String accountNumber,
            @RequestParam(required = false, name = "firstName") final String firstName,
            @RequestParam(required = false, name = "middleName") final String middleName,
            @RequestParam(required = false, name = "lastName") final String lastName,
            @RequestParam(required = false, name = "mobile") final String mobile,
            @RequestParam(required = false, name = "identificationNumber") final String identificationNumber,
            @RequestParam(required = false, defaultValue = SystemConstant.PAGE_NUMBER) final Integer pageNumber,
            @RequestParam(required = false, defaultValue = SystemConstant.PAGE_SIZE) final Integer pageSize,
            final HttpServletRequest request) {

        // Fetch All Account Details
        final FetchAllAccountResponse response = accountService.fetchAllAccountDetails(
                accountNumber,
                firstName,
                middleName,
                lastName,
                mobile,
                identificationNumber,
                pageNumber,
                pageSize,
                request);

        // Return Response
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }


}
