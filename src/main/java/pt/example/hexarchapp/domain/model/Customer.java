package pt.example.hexarchapp.domain.model;

import lombok.Data;
import pt.example.hexarchapp.domain.enuns.CustomerTypeEnum;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Customer implements Serializable {

	@Serial private static final long serialVersionUID = -3706511262450063248L;

	private Long id;

	private CustomerTypeEnum customerType;

	private Person person;

}
