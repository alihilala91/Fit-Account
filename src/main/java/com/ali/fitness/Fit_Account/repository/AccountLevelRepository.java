package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.AccountLevel;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountLevelRepository extends JpaRepository<@NonNull AccountLevel,@NonNull Long> {
}
