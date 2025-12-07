package com.ali.fitness.Fit_Account.controller;

import com.ali.fitness.Fit_Account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/account")
@RequiredArgsConstructor
public class AccountController {


    private final AccountService accountService;

    // API for Create Account

    // API for Fetch All Account

    // API for Fetch Account By AccountNumber
}
