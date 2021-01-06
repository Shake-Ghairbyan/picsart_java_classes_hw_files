package Services;

import Interfaces.Printable;

import java.util.List;

/**
 * This class is used to work with the instances of the class which implement Printable interface.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class PrintableService {

    /**
     * This method is used to print all the files which implement Printable interface.
     *
     * @param printables List of the instances of the class, which implements Printable Interface
     * @since 2021-01-04
     */

    public static void printAllInfo(List<? extends Printable> printables) {
        printables.forEach(Printable::printInfo);
    }
}
