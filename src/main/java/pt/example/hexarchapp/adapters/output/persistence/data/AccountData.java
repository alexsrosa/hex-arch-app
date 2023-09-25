package pt.example.hexarchapp.adapters.output.persistence.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import pt.example.hexarchapp.domains.enuns.AccountStatusEnum;
import pt.example.hexarchapp.domains.enuns.AccountTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class AccountData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 15)
    private String accountNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private AccountTypeEnum accountType;

    @Builder.Default
    @Column(nullable = false)
    private BigDecimal currentBalance = BigDecimal.ZERO;

    @Builder.Default
    @Column(nullable = false)
    private LocalDate dataOpened = LocalDate.now();

    private LocalDate dateClosed;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 6)
    private AccountStatusEnum accountStatus = AccountStatusEnum.OPENED;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = false, updatable = false)
    private CustomerData customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private Set<TransactionData> transactions = new HashSet<>(0);

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AccountData that = (AccountData) o;

        return new EqualsBuilder().append(id, that.id)
                .append(accountNumber, that.accountNumber).append(accountType, that.accountType)
                .append(currentBalance, that.currentBalance).append(dataOpened, that.dataOpened)
                .append(dateClosed, that.dateClosed).append(accountStatus, that.accountStatus).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(accountNumber).append(accountType)
                .append(currentBalance).append(dataOpened).append(dateClosed).append(accountStatus)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("accountNumber", accountNumber)
                .append("accountType", accountType)
                .append("currentBalance", currentBalance)
                .append("dataOpened", dataOpened)
                .append("dateClosed", dateClosed)
                .append("accountStatus", accountStatus)
                .toString();
    }
}
