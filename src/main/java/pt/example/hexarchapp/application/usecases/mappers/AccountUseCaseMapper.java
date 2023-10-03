package pt.example.hexarchapp.application.usecases.mappers;

import org.mapstruct.Mapper;
import pt.example.hexarchapp.application.usecases.data.commands.CreateAccountCommand;
import pt.example.hexarchapp.domain.model.Account;

@Mapper( componentModel = "spring" )
public interface AccountUseCaseMapper {

	Account toData( CreateAccountCommand createAccountCommand );

	CreateAccountCommand toCommand( Account account );

}
