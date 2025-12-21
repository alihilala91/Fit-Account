package com.ali.fitness.Fit_Account.entity;


import com.ali.fitness.Fit_Account.entity.lookup.AccountRoleLookup;
import com.ali.fitness.Fit_Account.entity.lookup.AccountStatusLookup;
import com.ali.fitness.Fit_Account.entity.lookup.AccountTypeLookup;
import com.ali.fitness.Fit_Account.entity.lookup.IdentificationTypeLookup;
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
public class AccountInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_info_gen")
    @SequenceGenerator(name = "account_info_gen", sequenceName = "account_info_seq", allocationSize = 1, schema = "account")
    private Long id;

    @Column(name = "account_Number", nullable = false, unique = true, length = 50)
    private String accountNumber;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "middle_name", nullable = false, length = 20)
    private String middleName;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile", nullable = false, length = 15)
    private String mobile;

    @Column(name = "identification_number", nullable = false, length = 15)
    private String identificationNumber;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "identification_type_id", referencedColumnName = "id", nullable = false)
    private IdentificationTypeLookup identificationType;

    @ManyToOne
    @JoinColumn(name = "account_type_id", referencedColumnName = "id", nullable = false)
    private AccountTypeLookup accountType;

    @ManyToOne
    @JoinColumn(name = "account_role_id", referencedColumnName = "id", nullable = false)
    private AccountRoleLookup accountRole;

    @ManyToOne
    @JoinColumn(name = "account_status_id", referencedColumnName = "id", nullable = false)
    private AccountStatusLookup status;

}
