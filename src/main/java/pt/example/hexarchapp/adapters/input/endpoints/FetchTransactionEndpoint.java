package pt.example.hexarchapp.adapters.input.endpoints;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.example.hexarchapp.application.usecases.FetchTransactionUseCase;
import pt.example.hexarchapp.domain.model.Transaction;

@Tag(name = "Transactions")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/transactions")
public class FetchTransactionEndpoint {

    private final FetchTransactionUseCase fetchTransactionUseCase;

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Transaction> fetchById(@PathVariable Long id) {
        return ResponseEntity.of(fetchTransactionUseCase.findById(id));
    }
}
