package com.ali.fitness.FitAccount.exception;

import com.ali.fitness.FitAccount.dto.general.ErrorResponse;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    /**
     * Handling Any Error of type Resource Exception
     *
     * @param ex Resource Exception
     * @return ErrorResponse
     */
    @ExceptionHandler(ResourceException.class)
    public ResponseEntity<@NonNull ErrorResponse> handleResourceExceptions(final ResourceException ex) {

        // Build the Error Response Depends on the Resource Exception
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .error(ex.getMessage())
                .status(ex.getStatus().value())
                .message(ex.getMessage())
                .build();

        // Return the Response as ResponseEntity
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    /**
     * Handling Any Error of Type Method Validation
     *
     * @param ex      MethodArgumentNotValidException
     * @param headers HttpHeaders
     * @param status  HttpStatusCode
     * @param request WebRequest
     * @return ErrorResponse
     */
    @Override
    protected ResponseEntity<@NonNull Object> handleMethodArgumentNotValid(final @NonNull MethodArgumentNotValidException ex,
                                                                           final @NonNull HttpHeaders headers,
                                                                           final @NonNull HttpStatusCode status,
                                                                           final @NonNull WebRequest request) {

        super.handleMethodArgumentNotValid(ex, headers, status, request);

        // Fetch All the Method Validation Error
        final List<String> errors = new ArrayList<>();
        ex.getAllErrors().forEach((objectError) -> errors.add(objectError.getDefaultMessage()));

        // Build the Error Response
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .errors(errors)
                .status(status.value())
                .message(ExceptionKey.NOT_VALID_REQUEST)
                .build();

        // Return the Response as ResponseEntity
        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.BAD_REQUEST);

    }
    /**
     * Handling Any Other Error
     *
     * @param ex Exception
     * @return ErrorResponse
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<@NonNull ErrorResponse> handleAnyExceptions(final Exception ex) {

        // Build the Error Response
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .error(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .build();

        // Return the Response as ResponseEntity
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
