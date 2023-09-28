package pt.example.hexarchapp.application.usecases;

import pt.example.hexarchapp.application.usecases.data.commands.CreatePersonCommand;
import pt.example.hexarchapp.domains.model.Person;

public interface SupportsPersonUseCase {

    Person create(CreatePersonCommand createPersonCommand);
}
