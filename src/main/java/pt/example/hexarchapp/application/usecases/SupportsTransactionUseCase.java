package pt.example.hexarchapp.application.usecases;

import pt.example.hexarchapp.application.usecases.data.commands.CreateTransactionCommand;
import pt.example.hexarchapp.domains.model.Transaction;

import java.util.Optional;

public interface SupportsTransactionUseCase {

    Optional<Transaction> create(CreateTransactionCommand createTransactionCommand);
}
