package Comparators;

import Model.PDF;

import java.util.Comparator;

/**
 * This class implements Comparator interface and is used as a comparator to
 * compare two instances of PDF class by their page counts.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class PagesComparator implements Comparator<PDF> {

    /**
     * This method is used to compare two instances of PDF class by comparing
     * their page counts.
     *
     * @param /PDF pdf/
     * @param /PDF pdf/
     * @return int
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    @Override
    public int compare(PDF p1, PDF p2) {
        return Integer.compare(p1.getNumberOfPages(), p2.getNumberOfPages());
    }
}
