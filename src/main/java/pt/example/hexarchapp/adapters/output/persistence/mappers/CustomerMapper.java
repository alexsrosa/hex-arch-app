package pt.example.hexarchapp.adapters.output.persistence.mappers;

import org.mapstruct.Mapper;
import pt.example.hexarchapp.adapters.output.persistence.data.AccountData;
import pt.example.hexarchapp.adapters.output.persistence.data.CustomerData;
import pt.example.hexarchapp.domains.model.Account;
import pt.example.hexarchapp.domains.model.Customer;

@Mapper( componentModel = "spring" )
public interface CustomerMapper {

	CustomerData toData( Customer customer );

	Customer toDomain( CustomerData customerData );
}
