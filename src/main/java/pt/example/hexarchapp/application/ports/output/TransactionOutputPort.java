package pt.example.hexarchapp.application.ports.output;

import pt.example.hexarchapp.domains.model.Transaction;

import java.util.Optional;

public interface TransactionOutputPort {

	Optional<Transaction> save( Transaction transaction );

	Optional<Transaction> findById( Long id );
}
