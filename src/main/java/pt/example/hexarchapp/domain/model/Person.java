package pt.example.hexarchapp.domain.model;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Person implements Serializable {

	@Serial private static final long serialVersionUID = 4115921701750398677L;

	private Long id;

	private String firstName;

	private String lastName;

	private LocalDate dateOfBirth;

	private String email;

	private String phoneNumber;

	private String address;

	private String taxIdentifier;

}
