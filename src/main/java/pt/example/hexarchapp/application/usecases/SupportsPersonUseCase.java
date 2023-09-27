package pt.example.hexarchapp.application.usecases;

import pt.example.hexarchapp.application.usecases.data.commands.CreatePersonCommand;
import pt.example.hexarchapp.domains.model.Person;

import java.util.Optional;

public interface SupportsPersonUseCase {

    Optional<Person> create(CreatePersonCommand createPersonCommand);
}
