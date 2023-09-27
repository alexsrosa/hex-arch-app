package pt.example.hexarchapp.application.usecases.mappers;

import org.mapstruct.Mapper;
import pt.example.hexarchapp.application.usecases.data.commands.CreateCustomerCommand;
import pt.example.hexarchapp.domains.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerUseCaseMapper {

    Customer toData(CreateCustomerCommand createCustomerCommand);

    CreateCustomerCommand toCommand(Customer customer);

}
