package pt.example.hexarchapp.domains.exceptions;

public class AccountAlreadyClosedException extends GenericException {

	public AccountAlreadyClosedException() {
		super( "Account Already Closed" );
	}

}
