package Exceptions.RegistrationExceptions;

/**
 * This class extends Exception and PasswordException is thrown
 * to indicate that password of the user is not valid
 * /should contain at least 8 symbols, 2 upper case letters and 3 numbers/.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class InvalidPasswordException extends Exception {

    /**
     * This method constructs a new PasswordException with specified detail message.
     *
     * @param message The detail message (which is saved for later retrieval by the getMessage() method)
     * @version 1.0
     * @since 2021-01-04
     */
    public InvalidPasswordException(String message) {
        super(message);
    }
}
