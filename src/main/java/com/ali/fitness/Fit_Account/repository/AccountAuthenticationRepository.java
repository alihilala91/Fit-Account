package com.ali.fitness.Fit_Account.repository;

import com.ali.fitness.Fit_Account.entity.AccountAuthentication;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountAuthenticationRepository extends JpaRepository<@NonNull AccountAuthentication, @NonNull Long> {
}
