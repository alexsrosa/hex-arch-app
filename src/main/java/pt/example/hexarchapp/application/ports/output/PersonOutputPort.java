package pt.example.hexarchapp.application.ports.output;

import pt.example.hexarchapp.domains.model.Person;

import java.util.Optional;

public interface PersonOutputPort {

	Optional<Person> save( Person person );

	Optional<Person> findById( Long id );
}
