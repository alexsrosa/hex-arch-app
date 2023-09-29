package pt.example.hexarchapp.adapters.output.persistence.mappers;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import pt.example.hexarchapp.adapters.output.persistence.data.PersonData;
import pt.example.hexarchapp.domains.model.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonData toData(Person person);

    Person toDomain(PersonData personData);

    default Page<Person> toDomain(Page<PersonData> personDataPage) {
        return personDataPage.map(this::toDomain);
    }
}
