package com.ali.fitness.FitAccount.dto.account.fetch.single;

import com.ali.fitness.FitAccount.entity.AccountInfo;
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
public class FetchAccountResponse {

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

    /**
     * Mapping the Account Info
     *
     * @param accountInfo Account Info
     * @return FetchAccountResponse
     */
    public static FetchAccountResponse mapping(final AccountInfo accountInfo) {
        return FetchAccountResponse.builder()
                .accountNumber(accountInfo.getAccountNumber())
                .firstName(accountInfo.getFirstName())
                .middleName(accountInfo.getMiddleName())
                .lastName(accountInfo.getLastName())
                .email(accountInfo.getEmail())
                .mobile(accountInfo.getMobile())
                .identificationNumber(accountInfo.getIdentificationNumber())
                .creationDate(accountInfo.getCreationDate())
                .identificationType(accountInfo.getIdentificationType().getCode())
                .accountType(accountInfo.getAccountType().getCode())
                .accountRole(accountInfo.getAccountRole().getCode())
                .status(accountInfo.getStatus().getCode())
                .build();
    }
}
