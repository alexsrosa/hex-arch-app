package pt.example.hexarchapp.adapters.output.persistence.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "accounts" )
public class AccountData {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Column( nullable = false, unique = true )
	private String accountNumber;

	@Enumerated( EnumType.STRING )
	@Column( nullable = false )
	private AccountTypeEnum accountType;

	private BigDecimal currentBalance;

	@Column( nullable = false )
	private LocalDate dataOpened;

	private LocalDate dateClosed;

	@Enumerated( EnumType.STRING )
	@Column( nullable = false )
	private AccountStatusEnum accountStatus;

	@ManyToOne
	@JoinColumn( name = "customerId", nullable = false, updatable = false )
	private CustomerData customer;

	@OneToMany
	private Set<TransactionData> transactions;

	@Override public boolean equals( Object o ) {
		if ( this == o )
			return true;

		if ( o == null || getClass() != o.getClass() )
			return false;

		AccountData that = (AccountData) o;

		return new EqualsBuilder().append( id, that.id )
				.append( accountNumber, that.accountNumber ).append( accountType, that.accountType )
				.append( currentBalance, that.currentBalance ).append( dataOpened, that.dataOpened )
				.append( dateClosed, that.dateClosed ).append( accountStatus, that.accountStatus ).isEquals();
	}

	@Override public int hashCode() {
		return new HashCodeBuilder( 17, 37 ).append( id ).append( accountNumber ).append( accountType )
				.append( currentBalance ).append( dataOpened ).append( dateClosed ).append( accountStatus )
				.toHashCode();
	}

	@Override public String toString() {
		return new ToStringBuilder( this )
				.append( "id", id )
				.append( "accountNumber", accountNumber )
				.append( "accountType", accountType )
				.append( "currentBalance", currentBalance )
				.append( "dataOpened", dataOpened )
				.append( "dateClosed", dateClosed )
				.append( "accountStatus", accountStatus )
				.toString();
	}
}
