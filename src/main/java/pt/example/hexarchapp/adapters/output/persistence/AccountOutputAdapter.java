package pt.example.hexarchapp.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pt.example.hexarchapp.adapters.output.persistence.mappers.AccountMapper;
import pt.example.hexarchapp.adapters.output.persistence.repository.AccountJPARepository;
import pt.example.hexarchapp.application.ports.output.AccountOutputPort;
import pt.example.hexarchapp.domains.model.Account;

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
		return Optional.empty();
	}

	@Override public Optional<Account> findByCustomerId( Long customerId ) {
		return Optional.empty();
	}
}
