package pt.example.hexarchapp.domain.exceptions;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String message ) {
		super( message );
	}

}
