package pt.example.hexarchapp.adapters.input.endpoints;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.example.hexarchapp.application.usecases.SupportsCustomerUseCase;
import pt.example.hexarchapp.application.usecases.data.commands.CreateCustomerCommand;
import pt.example.hexarchapp.domain.model.Customer;

@Tag(name = "Customers")
@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class SupportsCustomerEndpoint {

    private final SupportsCustomerUseCase supportsCustomerUseCase;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerCommand createCustomerCommand) {
        return ResponseEntity.of(
                supportsCustomerUseCase.create(createCustomerCommand));
    }
}
