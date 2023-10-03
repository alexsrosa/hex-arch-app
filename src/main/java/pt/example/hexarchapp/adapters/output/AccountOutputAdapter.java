package pt.example.hexarchapp.adapters.output;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pt.example.hexarchapp.adapters.output.persistence.mappers.AccountMapper;
import pt.example.hexarchapp.adapters.output.persistence.AccountJPARepository;
import pt.example.hexarchapp.application.ports.output.AccountOutputPort;
import pt.example.hexarchapp.domain.enuns.AccountTypeEnum;
import pt.example.hexarchapp.domain.model.Account;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AccountOutputAdapter implements AccountOutputPort {

	private final AccountJPARepository accountJPARepository;
	private final AccountMapper accountMapper;

	@Override public Optional<Account> save( Account account ) {
		return Optional.of( accountMapper.toDomain(
				accountJPARepository.save( accountMapper.toData( account ) ) ) );
	}

	@Override public Optional<Account> findById( Long id ) {
		return accountJPARepository.findById( id )
				.map( accountMapper::toDomain );
	}

	@Override public Optional<Account> findByAccountNumber( String accountNumber ) {
		return accountJPARepository.findByAccountNumber( accountNumber )
				.map( accountMapper::toDomain );
	}

	@Override public Optional<Account> findByCustomerId( Long customerId ) {
		return accountJPARepository.findByCustomer_Id( customerId )
				.map( accountMapper::toDomain );
	}

	@Override public Optional<Account> changeAccountType( Long id, AccountTypeEnum accountType ) {
		return accountJPARepository.changeAccountType( id, accountType )
				.map( accountMapper::toDomain );
	}
}
