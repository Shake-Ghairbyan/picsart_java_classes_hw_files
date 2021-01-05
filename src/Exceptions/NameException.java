package Exceptions;

/**
 * This class extends Exception and NameException is thrown
 * when Author's full name of the File class' instance is not valid /does not correspond
 * to specifications/.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class NameException extends Exception {

    /**
     * This method constructs a new NameException with specified detail message.
     *
     * @param /String name/
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public NameException(String name) {
        super("Wrong value for name input: " + name);
    }
}
