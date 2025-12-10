package com.ali.fitness.Fit_Account.account.api.dto.request;

import com.ali.fitness.Fit_Account.dto.account.create.request.AccountCreationRequest;
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

        return AccountCreationRequest.builder().build();
    }
}
