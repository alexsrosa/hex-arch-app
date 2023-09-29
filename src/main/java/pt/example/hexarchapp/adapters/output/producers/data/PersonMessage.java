package pt.example.hexarchapp.adapters.output.producers.data;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class PersonMessage implements Serializable {

	@Serial private static final long serialVersionUID = -5410981055670915378L;

	public static final String QUEUE_NAME = "persons";

	private Long id;

	private String firstName;

	private String lastName;

	private LocalDate dateOfBirth;

	private String email;

	private String phoneNumber;

	private String address;

	private String taxIdentifier;

}
