package Exceptions;

/**
 * This class extends Exception and InvalidFileNameException is thrown
 * when name of the file of the File class' instance is not valid /non-empty string/.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class InvalidFileNameException extends Exception {

    /**
     * This method constructs a new InvalidFileNameException with specified detail message.
     *
     * @param fileName name of the file of the File class' instance /non-empty value/.
     * @version 1.0
     * @since 2021-01-04
     */

    public InvalidFileNameException(String fileName) {
        super("Invalid input for file name: " + fileName);
    }
}
