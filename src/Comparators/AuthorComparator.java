package Comparators;

import Model.File;

import java.util.Comparator;

/**
 * This class implements Comparator interface and is used as a comparator to
 * compare two instances of File class by their author.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class AuthorComparator implements Comparator<File> {

    /**
     *This method is used to compare two instances of File class by comparing
     *their authors names in lexicographical order.
     *
     * @param /File file/
     * @param /File file/
     * @return int
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    @Override
    public int compare(File o1, File o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}



