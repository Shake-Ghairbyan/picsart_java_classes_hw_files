package Exceptions;

/**
 * This class extends Exception and PageException is thrown
 * when assigned values of pages of PDF file is negative.
 *
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class InvalidPageNumberException extends Exception {

    /**
     * This method constructs a new PageException with specified detail message.
     *
     * @param numberOfPage number of pages of PDF's instance:
     *                     should be non negative value.
     * @version 1.0
     * @since 2021-01-04
     */
    public InvalidPageNumberException(int numberOfPage) {
        super("Number of Pages can't be negative: " + numberOfPage);
    }
}
