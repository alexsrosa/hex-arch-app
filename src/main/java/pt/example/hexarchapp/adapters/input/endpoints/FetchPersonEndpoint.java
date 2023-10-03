package pt.example.hexarchapp.adapters.input.endpoints;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.example.hexarchapp.application.usecases.FetchPersonUseCase;
import pt.example.hexarchapp.domain.model.Person;


@Tag(name = "Persons")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/persons")
public class FetchPersonEndpoint {

    private final FetchPersonUseCase fetchPersonUseCase;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        return ResponseEntity.of(fetchPersonUseCase.findById(id));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Page<Person>> findAll(Pageable pageable) {
        return ResponseEntity.of(fetchPersonUseCase.findAll(pageable));
    }
}
