package pt.example.hexarchapp.adapters.output;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pt.example.hexarchapp.adapters.output.persistence.mappers.TransactionMapper;
import pt.example.hexarchapp.adapters.output.persistence.TransactionJPARepository;
import pt.example.hexarchapp.application.ports.output.TransactionOutputPort;
import pt.example.hexarchapp.domain.model.Transaction;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TransactionOutputAdapter implements TransactionOutputPort {

	private final TransactionJPARepository transactionJPARepository;
	private final TransactionMapper transactionMapper;

	@Override public Optional<Transaction> save( Transaction transaction ) {
		return Optional.of( transactionMapper.toDomain(
				transactionJPARepository.save( transactionMapper.toData( transaction ) ) ) );
	}

	@Override public Optional<Transaction> findById( Long id ) {
		return transactionJPARepository.findById( id )
				.map( transactionMapper::toDomain );
	}
}
