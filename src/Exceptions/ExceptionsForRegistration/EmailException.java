package Exceptions.ExceptionsForRegistration;

public class EmailException extends Exception {
    public EmailException(String email) {
        super("Invalid email address: " + email);
    }
}
