package pt.example.hexarchapp.application.ports.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pt.example.hexarchapp.application.ports.output.TransactionOutputPort;
import pt.example.hexarchapp.application.usecases.FetchTransactionUseCase;
import pt.example.hexarchapp.application.usecases.SupportsTransactionUseCase;
import pt.example.hexarchapp.application.usecases.data.commands.CreateTransactionCommand;
import pt.example.hexarchapp.application.usecases.mappers.TransactionUseCaseMapper;
import pt.example.hexarchapp.domain.exceptions.NotFoundException;
import pt.example.hexarchapp.domain.model.Transaction;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TransactionInputPort implements SupportsTransactionUseCase, FetchTransactionUseCase {

    public static final String TRANSACTION_NOT_FOUND = "Transaction Not Found";

    private final TransactionOutputPort transactionOutputPort;

    private final TransactionUseCaseMapper transactionUseCaseMapper;

    @Override
    public Optional<Transaction> create(CreateTransactionCommand createTransactionCommand) {
        return transactionOutputPort.save(transactionUseCaseMapper.toData(createTransactionCommand));
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return Optional.ofNullable(transactionOutputPort.findById(id)
                .orElseThrow(() -> new NotFoundException(TRANSACTION_NOT_FOUND)));
    }
}
