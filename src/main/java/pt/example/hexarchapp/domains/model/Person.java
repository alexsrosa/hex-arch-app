package pt.example.hexarchapp.domains.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Person {

	private Long id;

	private String firstName;

	private String lastName;

	private LocalDate dateOfBirth;

	private String email;

	private String phoneNumber;

	private String address;

	private String taxIdentifier;

}
