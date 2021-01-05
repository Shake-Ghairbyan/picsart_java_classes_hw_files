package Exceptions.RegistrationExceptions;

/**
 * This class extends Exception and PasswordException is thrown
 * when password of the user is not valid /does not correspond
 * to specifications/.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class InvalidUsernameException extends Exception {

    /**
     * This method constructs a new UsernameException with specified detail message.
     *
     * @param message
     * @param username
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public InvalidUsernameException(String message, String username) {
        super(message + username);
    }
}
