package pt.example.hexarchapp.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pt.example.hexarchapp.adapters.output.persistence.mappers.PersonMapper;
import pt.example.hexarchapp.adapters.output.persistence.repository.PersonJPARepository;
import pt.example.hexarchapp.application.ports.output.PersonOutputPort;
import pt.example.hexarchapp.domains.model.Person;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PersonOutputAdapter implements PersonOutputPort {

	private final PersonJPARepository personJPARepository;

	private final PersonMapper personMapper;

	@Override public Optional<Person> save( Person person ) {
		return Optional.of( personMapper.toDomain(
				personJPARepository.save( personMapper.toData( person ) ) ) );
	}

	@Override public Optional<Person> findById( Long id ) {
		return personJPARepository.findById( id )
				.map( personMapper::toDomain );
	}
}
