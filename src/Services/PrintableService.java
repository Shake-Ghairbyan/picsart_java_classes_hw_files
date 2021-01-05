package Services;

import Interfaces.Printable;

import java.util.List;

/**
 * This class implements Printable interface.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class PrintableService {

    /**
     * This method is used to print all the files which implement Printable interface.
     *
     * @param / List < ? extends Printable> printables /
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public static void printAllInfo(List<? extends Printable> printables) {
        for (Printable p : printables) {
            p.printInfo();
        }
    }
}
