package pt.example.hexarchapp.application.ports.output;

import pt.example.hexarchapp.domain.model.Customer;

import java.util.Optional;

public interface CustomerOutputPort {

	Optional<Customer> save( Customer customer );

	Optional<Customer> findById( Long id );
}
