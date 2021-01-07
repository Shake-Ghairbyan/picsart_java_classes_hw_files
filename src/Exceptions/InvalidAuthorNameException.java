package Exceptions;

/**
 * This class extends Exception and InvalidAuthorNameException is thrown
 * when Author's full name of the File class' instance is not valid.*
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class InvalidAuthorNameException extends Exception {

    /**
     * This method constructs a new InvalidAuthorNameException with specified detail message.
     *
     * @param name Author's full name of the File class' instance.
     * @since 2021-01-04
     */
    public InvalidAuthorNameException(String name) {
        super("Wrong value for Author's name input: " + name);
    }
}
