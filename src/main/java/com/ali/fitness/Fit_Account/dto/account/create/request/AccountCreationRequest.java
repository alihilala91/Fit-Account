package com.ali.fitness.Fit_Account.dto.account.create.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
public class AccountCreationRequest {


    @NotNull(message = "AccountCreationRequest.firstName.NotNull")
    @Length(min = 2, max = 20, message = "AccountCreationRequest.firstName.NotValidLength")
    @NotBlank(message = "AccountCreationRequest.firstName.NotBlank")
    private String firstName;

    @NotNull(message = "AccountCreationRequest.middleName.NotNull")
    @Length(min = 2, max = 20, message = "AccountCreationRequest.middleName.NotValidLength")
    @NotBlank(message = "AccountCreationRequest.middleName.NotBlank")
    private String middleName;

    @NotNull(message = "AccountCreationRequest.lastName.NotNull")
    @Length(min = 2, max = 20, message = "AccountCreationRequest.lastName.NotValidLength")
    @NotBlank(message = "AccountCreationRequest.lastName.NotBlank")
    private String lastName;

    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "AccountCreationRequest.email.NotValid")
    private String email;

    @NotNull(message = "AccountCreationRequest.mobile.NotNull")
    @Pattern(regexp = "^\\+?[1-9]\\d{7,14}$", message = "AccountCreationRequest.mobile.NotValid")
    private String mobile;

    @NotNull(message = "AccountCreationRequest.identificationNumber.NotNull")
    @Length(min = 2, max = 15, message = "AccountCreationRequest.identificationNumber.NotValidLength")
    @NotBlank(message = "AccountCreationRequest.identificationNumber.NotBlank")
    private String identificationNumber;

    @NotNull(message = "AccountCreationRequest.identificationType.NotNull")
    @Length(min = 2, max = 10, message = "AccountCreationRequest.identificationType.NotValidLength")
    @NotBlank(message = "AccountCreationRequest.identificationType.NotBlank")
    private String identificationType;

    @NotNull(message = "AccountCreationRequest.accountType.NotNull")
    @Length(min = 2, max = 10, message = "AccountCreationRequest.accountType.NotValidLength")
    @NotBlank(message = "AccountCreationRequest.accountType.NotBlank")
    private String accountType;

    @NotNull(message = "AccountCreationRequest.accountRole.NotNull")
    @Length(min = 2, max = 10, message = "AccountCreationRequest.accountRole.NotValidLength")
    @NotBlank(message = "AccountCreationRequest.accountRole.NotBlank")
    private String accountRole;

}
