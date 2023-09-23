package pt.example.hexarchapp.infrastructure.handlers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pt.example.hexarchapp.domains.exceptions.AccountNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler( value = { AccountNotFoundException.class } )
	protected ResponseEntity<Object> handleInvalidClientIdentifierException( RuntimeException ex, WebRequest request ) {
		return handleExceptionInternal( ex, ErrorResponse.builder()
						.message( ex.getMessage() )
						.build(),
				new HttpHeaders(), HttpStatus.NOT_FOUND, request );
	}
}
