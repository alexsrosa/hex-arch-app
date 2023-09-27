package pt.example.hexarchapp.application.usecases;

import pt.example.hexarchapp.application.usecases.data.commands.CreateCustomerCommand;
import pt.example.hexarchapp.domains.model.Customer;

import java.util.Optional;

public interface SupportsCustomerUseCase {

    Optional<Customer> create(CreateCustomerCommand createCustomerCommand);
}
