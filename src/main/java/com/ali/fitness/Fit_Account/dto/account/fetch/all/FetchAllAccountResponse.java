package com.ali.fitness.Fit_Account.dto.account.fetch.all;

import com.ali.fitness.Fit_Account.entity.AccountInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode
public class FetchAllAccountResponse {

    private Long totalElements;
    private Integer totalPages;
    private Integer currentPage;
    private Integer pageSize;
    private List<AccountDetails> accountDetails;

    public static FetchAllAccountResponse mapping(Page<@NonNull AccountInfo> accountInfos) {

        List<AccountDetails> accountDetails = new ArrayList<>();
        accountInfos.getContent().forEach(accountInfo -> {
            accountDetails.add(AccountDetails.builder()
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
                    .build());
        });

        return FetchAllAccountResponse.builder()
                .accountDetails(accountDetails)
                .totalElements(accountInfos.getTotalElements())
                .totalPages(accountInfos.getTotalPages())
                .currentPage(accountInfos.getNumber())
                .pageSize(accountInfos.getSize())
                .build();

    }
}
