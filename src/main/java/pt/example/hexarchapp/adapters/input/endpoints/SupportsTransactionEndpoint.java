package pt.example.hexarchapp.adapters.input.endpoints;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.example.hexarchapp.application.usecases.SupportsTransactionUseCase;
import pt.example.hexarchapp.application.usecases.data.commands.CreateTransactionCommand;
import pt.example.hexarchapp.domains.model.Transaction;

@Tag(name = "Transactions")
@RequiredArgsConstructor
@RestController
@RequestMapping("/transactions")
public class SupportsTransactionEndpoint {

    private final SupportsTransactionUseCase supportsTransactionUseCase;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody CreateTransactionCommand createTransactionCommand) {
        return ResponseEntity.of(supportsTransactionUseCase.create(createTransactionCommand));
    }
}
