package pt.example.hexarchapp.application.usecases;

import pt.example.hexarchapp.domains.model.Transaction;

import java.util.Optional;

public interface FetchTransactionUseCase {

    Optional<Transaction> findById(Long id);
}
