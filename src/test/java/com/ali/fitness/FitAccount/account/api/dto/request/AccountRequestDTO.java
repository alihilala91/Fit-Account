package com.ali.fitness.FitAccount.account.api.dto.request;

import com.ali.fitness.FitAccount.dto.account.create.request.AccountCreationRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


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
