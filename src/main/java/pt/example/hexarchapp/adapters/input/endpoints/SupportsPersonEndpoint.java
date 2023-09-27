package pt.example.hexarchapp.adapters.input.endpoints;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.example.hexarchapp.application.usecases.SupportsCustomerUseCase;
import pt.example.hexarchapp.application.usecases.SupportsPersonUseCase;
import pt.example.hexarchapp.application.usecases.data.commands.CreateCustomerCommand;
import pt.example.hexarchapp.application.usecases.data.commands.CreatePersonCommand;
import pt.example.hexarchapp.domains.model.Customer;
import pt.example.hexarchapp.domains.model.Person;

@Tag(name = "Persons")
@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class SupportsPersonEndpoint {

    private final SupportsPersonUseCase supportsPersonUseCase;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody CreatePersonCommand createPersonCommand) {
        return ResponseEntity.of(
                supportsPersonUseCase.create(createPersonCommand));
    }
}
