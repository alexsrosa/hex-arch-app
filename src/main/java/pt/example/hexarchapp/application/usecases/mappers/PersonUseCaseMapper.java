package pt.example.hexarchapp.application.usecases.mappers;

import org.mapstruct.Mapper;
import pt.example.hexarchapp.application.usecases.data.commands.CreatePersonCommand;
import pt.example.hexarchapp.domains.model.Person;

@Mapper(componentModel = "spring")
public interface PersonUseCaseMapper {

    Person toData(CreatePersonCommand createPersonCommand);

    CreatePersonCommand toCommand(Person person);

}
