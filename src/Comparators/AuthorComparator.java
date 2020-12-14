package Comparators;

import Model.File;

import java.util.Comparator;

public class AuthorComparator implements Comparator<File> {

    @Override
    public int compare(File o1, File o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}



