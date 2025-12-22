package com.ali.fitness.FitAccount.entity;

import com.ali.fitness.FitAccount.entity.lookup.AccountLevelTypeLookup;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(
        name = "account_level",
        schema = "account"
)
public class AccountLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_level_gen")
    @SequenceGenerator(name = "account_level_gen", sequenceName = "account_level_seq", allocationSize = 1, schema = "account")
    private Long id;

    @Column(name = "status", nullable = false)
    private String status;

    @CreationTimestamp
    @Column(name = "creation_Date", nullable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "account_info_id", referencedColumnName = "id", nullable = false)
    private AccountInfo accountInfo;

    @ManyToOne
    @JoinColumn(name = "account_level_type_lookup_id", referencedColumnName = "id", nullable = false)
    private AccountLevelTypeLookup accountLevelType;


    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AccountLevel that = (AccountLevel) o;
        return Objects.equals(status, that.status)
                && Objects.equals(accountInfo, that.accountInfo)
                && Objects.equals(accountLevelType, that.accountLevelType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, accountInfo, accountLevelType);
    }
}
