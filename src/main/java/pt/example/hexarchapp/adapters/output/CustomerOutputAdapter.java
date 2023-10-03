package pt.example.hexarchapp.adapters.output;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pt.example.hexarchapp.adapters.output.persistence.mappers.CustomerMapper;
import pt.example.hexarchapp.adapters.output.persistence.CustomerJPARepository;
import pt.example.hexarchapp.application.ports.output.CustomerOutputPort;
import pt.example.hexarchapp.domain.model.Customer;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomerOutputAdapter implements CustomerOutputPort {

	private final CustomerJPARepository customerJPARepository;
	private final CustomerMapper customerMapper;

	@Override public Optional<Customer> save( Customer customer ) {
		return Optional.of( customerMapper.toDomain(
				customerJPARepository.save( customerMapper.toData( customer ) ) ) );
	}

	@Override public Optional<Customer> findById( Long id ) {
		return customerJPARepository.findById( id )
				.map( customerMapper::toDomain );
	}
}
