package com.ali.fitness.Fit_Account.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(
        name = "account_info",
        schema = "account",
        indexes = {@Index(name = "idx_account_number", columnList = "account_number")}
)
public class AccountAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_info_gen")
    @SequenceGenerator(name = "account_info_gen", sequenceName = "account_info_seq", allocationSize = 1, schema = "account")
    private Long id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "last_login", nullable = false, length = 50)
    private LocalDateTime lastLogin;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;


    @ManyToOne
    @JoinColumn(name = "account_info_id", referencedColumnName = "id")
    private AccountInfo accountInfo;
}
