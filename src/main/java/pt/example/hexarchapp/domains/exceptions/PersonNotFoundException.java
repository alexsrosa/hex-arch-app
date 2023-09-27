package pt.example.hexarchapp.domains.exceptions;

public class PersonNotFoundException extends GenericException {

    public static final String PERSON_NOT_FOUND = "Person Not Found";

    public PersonNotFoundException() {
        super(PERSON_NOT_FOUND);
    }

}
