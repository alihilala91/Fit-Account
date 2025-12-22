package com.ali.fitness.FitAccount.dto.account.fetch.all;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
public class AccountDetails {
    private String accountNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String mobile;
    private String identificationNumber;
    private LocalDateTime creationDate;
    private String identificationType;
    private String accountType;
    private String accountRole;
    private String status;
}
