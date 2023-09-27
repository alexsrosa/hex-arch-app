package pt.example.hexarchapp.adapters.input.endpoints;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.example.hexarchapp.application.usecases.FetchCustomerUseCase;
import pt.example.hexarchapp.domains.model.Customer;

@Tag(name = "Customers")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/customers")
public class FetchCustomerEndpoint {

    private final FetchCustomerUseCase fetchCustomerUseCase;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Customer> fetchAccountById(@PathVariable Long id) {
        return ResponseEntity.of(fetchCustomerUseCase.findById(id));
    }
}
