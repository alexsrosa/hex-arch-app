package pt.example.hexarchapp.adapters.input.endpoints.hateoas;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import pt.example.hexarchapp.adapters.input.endpoints.FetchPersonEndpoint;
import pt.example.hexarchapp.domain.model.Person;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PersonAssembler implements RepresentationModelAssembler<Person, EntityModel<Person>> {
    @Override
    public EntityModel<Person> toModel(Person person) {

        return EntityModel.of(person,
                linkTo(methodOn(FetchPersonEndpoint.class).findById(person.getId())).withSelfRel(),
                linkTo(methodOn(FetchPersonEndpoint.class).findAll(Pageable.unpaged())).withRel("persons"));
    }
}
