package pt.example.hexarchapp.adapters.output.producers.mappers;

import org.mapstruct.Mapper;
import pt.example.hexarchapp.adapters.output.producers.data.PersonMessage;
import pt.example.hexarchapp.domains.model.Person;

@Mapper( componentModel = "spring" )
public interface PersonMessageMapper {

	PersonMessage toMessage( Person person );

}
