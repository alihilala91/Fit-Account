package com.ali.fitness.FitAccount.repository.pojo;

import java.time.LocalDateTime;

public interface AllAccountPojo {

    String getAccountNumber();

    String getFirstName();

    String getMiddleName();

    String getLastName();

    String getEmail();

    String getMobile();

    String getIdentificationNumber();

    LocalDateTime getCreationDate();

    String getIdentificationType();

    String getAccountType();

    String getAccountRole();

    String getStatus();
}
