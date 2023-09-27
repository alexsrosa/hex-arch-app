package pt.example.hexarchapp.domains.exceptions;

public class CustomerNotFoundException extends GenericException {

    public static final String CUSTOMER_NOT_FOUND = "Customer Not Found";

    public CustomerNotFoundException() {
        super(CUSTOMER_NOT_FOUND);
    }

}
