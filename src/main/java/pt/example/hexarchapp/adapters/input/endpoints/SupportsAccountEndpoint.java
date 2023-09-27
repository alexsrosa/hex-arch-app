package pt.example.hexarchapp.adapters.input.endpoints;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.example.hexarchapp.application.usecases.SupportsAccountUseCase;
import pt.example.hexarchapp.application.usecases.data.commands.ChangeAccountStatusCommand;
import pt.example.hexarchapp.application.usecases.data.commands.ChangeAccountTypeCommand;
import pt.example.hexarchapp.application.usecases.data.commands.CreateAccountCommand;
import pt.example.hexarchapp.domains.model.Account;

@Tag(name = "Accounts")
@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class SupportsAccountEndpoint {

    private final SupportsAccountUseCase supportsAccountUseCase;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody CreateAccountCommand createAccountCommand) {
        return ResponseEntity.of(
                supportsAccountUseCase.create(createAccountCommand));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Account> changeAccountStatus(
            @PathVariable Long id,
            @RequestBody ChangeAccountStatusCommand changeAccountStatusCommand) {
        return ResponseEntity.of(
                supportsAccountUseCase.changeAccountStatus(id, changeAccountStatusCommand.getAccountStatus()));
    }

    @PutMapping("/{id}/type")
    public ResponseEntity<Account> changeAccountType(
            @PathVariable Long id,
            @RequestBody ChangeAccountTypeCommand changeAccountTypeCommand) {
        return ResponseEntity.of(
                supportsAccountUseCase.changeAccountType(id, changeAccountTypeCommand.getAccountTypeEnum()));
    }

}
