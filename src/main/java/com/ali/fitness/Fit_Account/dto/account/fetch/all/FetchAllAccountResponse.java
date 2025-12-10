package com.ali.fitness.Fit_Account.dto.account.fetch.all;

import com.ali.fitness.Fit_Account.repository.pojo.AllAccountPojo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
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

    public static FetchAllAccountResponse mapping(Page<@NonNull AllAccountPojo> allAccountPojos) {

        List<AccountDetails> accountDetails = new ArrayList<>();
        allAccountPojos.getContent().forEach(allAccountPojo -> {
            accountDetails.add(AccountDetails.builder()
                    .accountNumber(allAccountPojo.getAccountNumber())
                    .firstName(allAccountPojo.getFirstName())
                    .middleName(allAccountPojo.getMiddleName())
                    .lastName(allAccountPojo.getLastName())
                    .email(allAccountPojo.getEmail())
                    .mobile(allAccountPojo.getMobile())
                    .identificationNumber(allAccountPojo.getIdentificationNumber())
                    .creationDate(allAccountPojo.getCreationDate())
                    .identificationType(allAccountPojo.getIdentificationType())
                    .accountType(allAccountPojo.getAccountType())
                    .accountRole(allAccountPojo.getAccountRole())
                    .status(allAccountPojo.getStatus())
                    .build());

        });

        return FetchAllAccountResponse.builder()
                .accountDetails(accountDetails)
                .totalElements(allAccountPojos.getTotalElements())
                .totalPages(allAccountPojos.getTotalPages())
                .currentPage(allAccountPojos.getNumber())
                .pageSize(allAccountPojos.getSize())
                .build();

    }
}
