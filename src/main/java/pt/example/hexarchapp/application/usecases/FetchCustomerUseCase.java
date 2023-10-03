package pt.example.hexarchapp.application.usecases;

import pt.example.hexarchapp.domain.model.Customer;

import java.util.Optional;

public interface FetchCustomerUseCase {

    Optional<Customer> findById(Long id);
}
