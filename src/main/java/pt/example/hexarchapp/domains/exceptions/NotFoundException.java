package pt.example.hexarchapp.domains.exceptions;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String message ) {
		super( message );
	}

}
