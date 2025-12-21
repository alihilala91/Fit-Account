package com.ali.fitness.Fit_Account.account.api.dto.request;

import com.ali.fitness.Fit_Account.dto.account.create.request.AccountCreationRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@ToString
@Builder
public class AccountRequestDTO {


    public static AccountCreationRequest normalFlow() {

        return AccountCreationRequest.builder()
                .firstName("Ali")
                .middleName("Adnan")
                .lastName("Hilal")
                .email("ali.helal91@yahoo.com")
                .mobile("+962799820750")
                .identificationNumber("2000603553")
                .identificationType("NATIONAL_ID")
                .accountType("COACH")
                .accountRole("ADMIN")
                .build();
    }
}
