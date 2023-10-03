package pt.example.hexarchapp.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pt.example.hexarchapp.domain.model.Person;


import java.util.Optional;

public interface PersonOutputPort {

	Person save( Person person );

	Optional<Person> findById( Long id );

	Page<Person> findAll(Pageable pageable);
}
