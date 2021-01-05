package Exceptions.RegistrationExceptions;

/**
 * This class extends Exception and EmailException is thrown
 * when email of the user is not valid /does not correspond
 * to specifications/.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class InvalidEmailException extends Exception {

    /**
     * This method constructs a new EmailException with specified detail message.
     *
     * @param /String email/
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public InvalidEmailException(String email) {
        super("Invalid email address: " + email);
    }
}
