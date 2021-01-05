package Exceptions.ExceptionsForRegistration;

/**
 * This class extends Exception and PasswordException is thrown
 * when password of the user is not valid /does not correspond
 * to specifications/.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class UsernameException extends Exception {

    /**
     * This method constructs a new UsernameException with specified detail message.
     *
     * @param message
     * @param username
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public UsernameException(String message, String username) {
        super(message + username);
    }
}
