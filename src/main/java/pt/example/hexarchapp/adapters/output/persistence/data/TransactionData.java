package pt.example.hexarchapp.adapters.output.persistence.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import pt.example.hexarchapp.domains.enuns.TransactionTypeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "transactions" )
public class TransactionData {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Enumerated( EnumType.STRING )
	@Column( nullable = false )
	private TransactionTypeEnum transactionType;

	@Column( nullable = false )
	private BigDecimal amount;

	@Column( nullable = false )
	private LocalDateTime transactionDate;

	@Override public boolean equals( Object o ) {
		if ( this == o )
			return true;

		if ( o == null || getClass() != o.getClass() )
			return false;

		TransactionData that = (TransactionData) o;

		return new EqualsBuilder().append( id, that.id )
				.append( transactionType, that.transactionType ).append( amount, that.amount )
				.append( transactionDate, that.transactionDate ).isEquals();
	}

	@Override public int hashCode() {
		return new HashCodeBuilder( 17, 37 ).append( id ).append( transactionType ).append( amount )
				.append( transactionDate ).toHashCode();
	}

	@Override public String toString() {
		return new ToStringBuilder( this )
				.append( "id", id )
				.append( "transactionType", transactionType )
				.append( "amount", amount )
				.append( "transactionDate", transactionDate )
				.toString();
	}
}
