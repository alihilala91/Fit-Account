package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, Long> {
}
