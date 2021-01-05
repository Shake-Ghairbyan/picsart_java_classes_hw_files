package Exceptions.RegistrationExceptions;

/**
 * This class extends Exception and FullNameException is thrown
 * when full name of the user is not valid /does not correspond
 * to specifications/.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class InvalidFullNameException extends Exception {

    /**
     * This method constructs a new FullNameException with specified detail message.
     *
     * @param /String fullName/
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public InvalidFullNameException(String fullName) {
        super("Wrong input for full name: " + fullName);
    }
}
