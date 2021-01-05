package Exceptions.RegistrationExceptions;

/**
 * This class extends Exception and PasswordException is thrown
 * to indicate that username of the user is not valid
 * /should contain at least 10 symbols/.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class InvalidUsernameException extends Exception {

    /**
     * This method constructs a new UsernameException with specified detail message.
     *
     * @param message  The detail message (which is saved for later retrieval by the getMessage() method)
     * @param username username of the User's instance which should be at least 10 symbols.
     * @version 1.0
     * @since 2021-01-04
     */
    public InvalidUsernameException(String message, String username) {
        super(message + username);
    }
}
