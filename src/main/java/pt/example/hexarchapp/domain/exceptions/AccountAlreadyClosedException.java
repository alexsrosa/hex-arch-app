package pt.example.hexarchapp.domain.exceptions;

public class AccountAlreadyClosedException extends GenericException {

	public AccountAlreadyClosedException() {
		super( "Account Already Closed" );
	}

}
