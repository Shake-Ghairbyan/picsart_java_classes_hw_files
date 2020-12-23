package Comparators;

import Model.File;

import java.util.Comparator;

public class FileNameComparator implements Comparator<File> {
    private boolean desc;

    public FileNameComparator(boolean desc) {
        this.desc = desc;
    }

    @Override
    public int compare(File o1, File o2) {
        if(desc)
            return o1.getFileName().compareTo(o2.getFileName());
        return -o1.getFileName().compareTo(o2.getFileName());
    }
}
