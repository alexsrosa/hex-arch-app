package pt.example.hexarchapp.application.usecases;

import pt.example.hexarchapp.domains.model.Person;

import java.util.Optional;

public interface FetchPersonUseCase {

    Optional<Person> findById(Long id);
}
