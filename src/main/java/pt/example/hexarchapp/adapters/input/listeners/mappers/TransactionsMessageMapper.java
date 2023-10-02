package pt.example.hexarchapp.adapters.input.listeners.mappers;

import org.mapstruct.Mapper;
import pt.example.hexarchapp.adapters.input.listeners.data.TransactionsMessage;
import pt.example.hexarchapp.application.usecases.data.commands.CreateTransactionCommand;

@Mapper( componentModel = "spring" )
public interface TransactionsMessageMapper {

	CreateTransactionCommand toCommand( TransactionsMessage transactionsMessage );

}
