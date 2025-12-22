package com.ali.fitness.FitAccount.dto.general;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ErrorResponse {

    private String message;
    private String error;
    private Integer status;
    private List<String> errors;
    
}
