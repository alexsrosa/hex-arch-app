package pt.example.hexarchapp.adapters.output.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import pt.example.hexarchapp.adapters.output.persistence.mappers.PersonMapper;
import pt.example.hexarchapp.adapters.output.persistence.repository.PersonJPARepository;
import pt.example.hexarchapp.application.ports.output.PersonOutputPort;
import pt.example.hexarchapp.domains.model.Person;


import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PersonOutputAdapter implements PersonOutputPort {

    private final PersonJPARepository personJPARepository;

    private final PersonMapper personMapper;

    @Override
    public Person save(Person person) {
        return personMapper.toDomain(personJPARepository.save(personMapper.toData(person)));
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personJPARepository.findById(id)
                .map(personMapper::toDomain);
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        return personJPARepository.findAll(pageable)
                .map(personMapper::toDomain);
    }
}
