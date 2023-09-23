package pt.example.hexarchapp.application.usecases;

import pt.example.hexarchapp.application.usecases.data.commands.CreateAccountCommand;
import pt.example.hexarchapp.domains.enuns.AccountStatusEnum;
import pt.example.hexarchapp.domains.enuns.AccountTypeEnum;
import pt.example.hexarchapp.domains.model.Account;

import java.util.Optional;

public interface SupportsAccountUseCase {

	Optional<Account> create( CreateAccountCommand createAccountCommand );

	Optional<Account> changeAccountType( Long id, AccountTypeEnum accountType );

	Optional<Account> changeAccountStatus( Long id, AccountStatusEnum accountStatus );

}
