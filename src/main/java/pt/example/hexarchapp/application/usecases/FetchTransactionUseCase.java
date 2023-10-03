package pt.example.hexarchapp.application.usecases;

import pt.example.hexarchapp.domain.model.Transaction;

import java.util.Optional;

public interface FetchTransactionUseCase {

    Optional<Transaction> findById(Long id);
}
