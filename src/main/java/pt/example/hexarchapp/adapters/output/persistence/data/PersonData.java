package pt.example.hexarchapp.adapters.output.persistence.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
public class PersonData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 150)
    private String lastName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false, length = 150)
    private String email;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Column(nullable = false, length = 150)
    private String address;

    @Column(nullable = false, length = 15)
    private String taxIdentifier;

    @OneToOne
    private CustomerData customer;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        PersonData that = (PersonData) o;

        return new EqualsBuilder().append(id, that.id)
                .append(firstName, that.firstName).append(lastName, that.lastName)
                .append(dateOfBirth, that.dateOfBirth).append(email, that.email)
                .append(phoneNumber, that.phoneNumber)
                .append(address, that.address).append(taxIdentifier, that.taxIdentifier).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(firstName).append(lastName).append(dateOfBirth)
                .append(email).append(phoneNumber).append(address).append(taxIdentifier).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("dateOfBirth", dateOfBirth)
                .append("email", email)
                .append("phoneNumber", phoneNumber)
                .append("address", address)
                .append("taxIdentifier", taxIdentifier)
                .toString();
    }
}
