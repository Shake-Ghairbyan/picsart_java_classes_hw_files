package Comparators;

import Model.PDF;

import java.util.Comparator;

public class PagesComparator implements Comparator<PDF> {

    @Override
    public int compare(PDF p1, PDF p2) {
        return Integer.compare(p1.getNumberOfPages(), p2.getNumberOfPages());
    }
}
