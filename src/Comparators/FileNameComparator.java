package Comparators;

import Model.File;

import java.util.Comparator;

/**
 * This class implements Comparator interface and is used as a comparator to
 * compare two instances of File class by their names.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class FileNameComparator implements Comparator<File> {
    private final boolean desc;

    /**
     * This method is used to assign boolean value to desc field.
     *
     * @param desc boolean variable to set the order in which instances of
     *             File class will be compared:
     *             true - descending, false - ascending.
     * @since 2021-01-04
     */

    public FileNameComparator(boolean desc) {
        this.desc = desc;
    }

    /**
     * This method is used to compare two instances of File class by comparing
     * their names in lexicographical order, if desc is false, and reversed
     * lexicographical order, if desc is true.
     *
     * @param o1 first File instance to be compared
     * @param o2 second File instance to be compared
     * @return int
     * @since 2021-01-04
     */

    @Override
    public int compare(File o1, File o2) {
        if (desc) {
            return -o1.getFileName().compareTo(o2.getFileName());
        }
        return o1.getFileName().compareTo(o2.getFileName());
    }
}
