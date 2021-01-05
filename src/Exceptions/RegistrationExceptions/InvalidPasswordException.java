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

public class InvalidPasswordException extends Exception {

    /**
     * This method constructs a new PasswordException with specified detail message.
     *
     * @param /String message/
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public InvalidPasswordException(String message){
        super(message);
    }
}
