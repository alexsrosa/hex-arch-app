package pt.example.hexarchapp.domains.model;

import lombok.Data;
import pt.example.hexarchapp.domains.enuns.CustomerTypeEnum;

@Data
public class Customer {

	private Long id;

	private CustomerTypeEnum customerType;

	private Person person;

}
