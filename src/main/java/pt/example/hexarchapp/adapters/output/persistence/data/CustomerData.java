package pt.example.hexarchapp.adapters.output.persistence.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import pt.example.hexarchapp.domains.enuns.CustomerTypeEnum;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "customer" )
public class CustomerData {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@Enumerated( EnumType.STRING )
	@Column( nullable = false )
	private CustomerTypeEnum customerType;

	@OneToOne
	private PersonData person;

	@Override public boolean equals( Object o ) {
		if ( this == o )
			return true;

		if ( o == null || getClass() != o.getClass() )
			return false;

		CustomerData that = (CustomerData) o;

		return new EqualsBuilder().append( id, that.id )
				.append( customerType, that.customerType ).isEquals();
	}

	@Override public int hashCode() {
		return new HashCodeBuilder( 17, 37 ).append( id ).append( customerType ).toHashCode();
	}

	@Override public String toString() {
		return new ToStringBuilder( this )
				.append( "id", id )
				.append( "customerType", customerType )
				.toString();
	}
}
