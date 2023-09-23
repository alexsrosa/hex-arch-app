package pt.example.hexarchapp.domains.exceptions;

public class AccountNotFoundException extends GenericException {

	public static final String ACCOUNT_NOT_FOUND = "Account Not Found";

	public AccountNotFoundException() {
		super( ACCOUNT_NOT_FOUND );
	}

}
