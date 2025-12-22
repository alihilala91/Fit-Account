package com.ali.fitness.FitAccount.filter;

import com.ali.fitness.FitAccount.entity.AccountInfo;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;


import java.util.ArrayList;
import java.util.List;

public class AccountInfoSpecs {

    public static Specification<AccountInfo> filter(
            String accountNumber,
            String firstName,
            String middleName,
            String lastName,
            String mobile,
            String identificationNumber) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (accountNumber != null) {
                predicates.add(cb.equal(root.get("accountNumber"), accountNumber));
            }
            if (firstName != null) {
                predicates.add(cb.equal(root.get("firstName"), firstName.toUpperCase()));
            }
            if (middleName != null) {
                predicates.add(cb.equal(root.get("middleName"), middleName.toUpperCase()));
            }
            if (lastName != null) {
                predicates.add(cb.equal(root.get("lastName"), lastName.toUpperCase()));
            }
            if (mobile != null) {
                predicates.add(cb.equal(root.get("mobile"), mobile));
            }
            if (identificationNumber != null) {
                predicates.add(cb.equal(root.get("identificationNumber"), identificationNumber));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
