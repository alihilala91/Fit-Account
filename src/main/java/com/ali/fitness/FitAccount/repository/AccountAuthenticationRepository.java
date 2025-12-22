package com.ali.fitness.FitAccount.repository;

import com.ali.fitness.FitAccount.entity.AccountAuthentication;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountAuthenticationRepository extends JpaRepository<@NonNull AccountAuthentication, @NonNull Long> {
}
