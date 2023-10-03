package pt.example.hexarchapp.application.usecases;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pt.example.hexarchapp.domain.model.Person;

import java.util.Optional;

public interface FetchPersonUseCase {

    Optional<Person> findById(Long id);

    Optional<Page<Person>> findAll(Pageable pageable);
}
