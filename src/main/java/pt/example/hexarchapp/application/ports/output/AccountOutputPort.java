package pt.example.hexarchapp.application.ports.output;

import pt.example.hexarchapp.domain.enuns.AccountTypeEnum;
import pt.example.hexarchapp.domain.model.Account;

import java.util.Optional;

public interface AccountOutputPort {

	Optional<Account> save( Account account );

	Optional<Account> findById( Long id );

	Optional<Account> findByAccountNumber( String accountNumber );

	Optional<Account> findByCustomerId( Long customerId );

	Optional<Account> changeAccountType( Long id, AccountTypeEnum accountType );
}
