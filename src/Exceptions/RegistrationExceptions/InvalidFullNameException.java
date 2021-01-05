package Exceptions.RegistrationExceptions;

/**
 * This class extends Exception and FullNameException is thrown
 * to indicate that full name of the user is not valid
 * /first name and last name must start with UpperCase and separated by space/.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class InvalidFullNameException extends Exception {

    /**
     * This method constructs a new FullNameException with specified detail message.
     *
     * @param fullName Full Name of the User's instance
     *                /must start with UpperCase and separated by space/.
     * @version 1.0
     * @since 2021-01-04
     */

    public InvalidFullNameException(String fullName) {
        super("Wrong input for full name: " + fullName);
    }
}
