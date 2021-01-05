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

public class PageException extends Exception {

    /**
     * This method constructs a new PageException with specified detail message.
     *
     * @param /int numberOfPage/
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public PageException(int numberOfPage) {
        super("Number of Pages can't be negative: " + numberOfPage);
    }
}
