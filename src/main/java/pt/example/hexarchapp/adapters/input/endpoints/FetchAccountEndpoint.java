package pt.example.hexarchapp.adapters.input.endpoints;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.example.hexarchapp.application.usecases.FetchAccountUseCase;
import pt.example.hexarchapp.domains.model.Account;

@RequiredArgsConstructor
@RestController
@RequestMapping( value = "/accounts" )
public class FetchAccountEndpoint {

	private final FetchAccountUseCase fetchAccountUseCase;

	@GetMapping( value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<Account> fetchAccountById( @PathVariable Long id ) {
		return ResponseEntity.of( fetchAccountUseCase.findById( id ) );
	}

	@GetMapping( value = "/{accountNumber}/accountNumber", produces = { MediaType.APPLICATION_JSON_VALUE } )
	public ResponseEntity<Account> fetchAccountByAccountNumber( @PathVariable String accountNumber ) {
		return ResponseEntity.of( fetchAccountUseCase.findByAccountNumber( accountNumber ) );
	}
}
