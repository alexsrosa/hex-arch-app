package pt.example.hexarchapp.application.usecases;

import pt.example.hexarchapp.domains.model.Account;

import java.util.Optional;

public interface FetchAccountUseCase {

	Optional<Account> findById( Long id );

	Optional<Account> findByAccountNumber( String accountNumber );

}
