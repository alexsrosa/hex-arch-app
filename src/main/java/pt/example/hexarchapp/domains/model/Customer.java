package pt.example.hexarchapp.domains.model;

import lombok.Data;

@Data
public class Customer {

	private Long id;

	private String customerType;

	private Person person;

}
