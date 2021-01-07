package Interfaces;

/**
 * This interface is to be implemented to execute its toCSVString() method,
 * which will be used to convert the information of the instance of the
 * class, which implements CSVable interface, to string.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public interface CSVable {
    /**
     * This method is to be used to convert the information of the instance
     * of the class, which implements CSVable interface, to string.
     *
     * @since 2021-01-04
     */

    String toCSVString();
}
