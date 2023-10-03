package pt.example.hexarchapp.adapters.input.endpoints;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import pt.example.hexarchapp.adapters.input.endpoints.hateoas.PersonAssembler;
import pt.example.hexarchapp.application.usecases.SupportsPersonUseCase;
import pt.example.hexarchapp.application.usecases.data.commands.CreatePersonCommand;
import pt.example.hexarchapp.domain.model.Person;

@Tag(name = "Persons")
@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class SupportsPersonEndpoint {

    private final SupportsPersonUseCase supportsPersonUseCase;

    private final PersonAssembler personAssembler;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody @Valid CreatePersonCommand createPersonCommand,
                                               UriComponentsBuilder uriComponentsBuilder) {
        Person person = supportsPersonUseCase.create(createPersonCommand);
        return ResponseEntity
                .created(uriComponentsBuilder.path("/persons/" + person.getId()).build().toUri())
                .body(personAssembler.toModel(person).getContent());
    }
}
