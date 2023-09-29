package pt.example.hexarchapp.application.usecases.mappers;

import org.mapstruct.Mapper;
import pt.example.hexarchapp.application.usecases.data.commands.CreateTransactionCommand;
import pt.example.hexarchapp.domains.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionUseCaseMapper {

    Transaction toData(CreateTransactionCommand createTransactionCommand);

    CreateTransactionCommand toCommand(Transaction transaction);

}
