package pt.example.hexarchapp.application.ports.input;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pt.example.hexarchapp.application.ports.output.PersonOutputPort;
import pt.example.hexarchapp.application.usecases.FetchPersonUseCase;
import pt.example.hexarchapp.application.usecases.SupportsPersonUseCase;
import pt.example.hexarchapp.application.usecases.data.commands.CreatePersonCommand;
import pt.example.hexarchapp.application.usecases.mappers.PersonUseCaseMapper;
import pt.example.hexarchapp.domains.exceptions.PersonNotFoundException;
import pt.example.hexarchapp.domains.model.Person;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonInputPort implements SupportsPersonUseCase, FetchPersonUseCase {

    private final PersonOutputPort personOutputPort;

    private final PersonUseCaseMapper personUseCaseMapper;

    @Override
    public Optional<Person> create(CreatePersonCommand createPersonCommand) {
        return personOutputPort.save(personUseCaseMapper.toData(createPersonCommand));
    }

    @Override
    public Optional<Person> findById(Long id) {
        return Optional.ofNullable(personOutputPort.findById(id)
                .orElseThrow(PersonNotFoundException::new));
    }
}
