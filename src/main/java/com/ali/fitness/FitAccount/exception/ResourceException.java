package com.ali.fitness.FitAccount.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Locale;

@Getter
@Setter
public class ResourceException extends RuntimeException {

    private String message;
    private HttpStatus status;
    private Locale locale;
    private List<String> errors;

    public ResourceException(String message, HttpStatus status, Locale locale) {
        this.message = message;
        this.status = status;
        this.locale = locale;
    }

    public ResourceException(String message, HttpStatus status, Locale locale, List<String> errors) {
        this.message = message;
        this.status = status;
        this.locale = locale;
        this.errors = errors;
    }
}
