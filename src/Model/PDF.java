package Model;

import Exceptions.NameException;
import Exceptions.PageException;

public class PDF extends File {
    private static final int PAGE_SIZE = 70 * 1024;
    private int numberOfPages;
    private boolean isSecured;

    public boolean isSecured() {
        return isSecured;
    }

    public void setSecured(boolean isSecured) {
        this.isSecured = isSecured;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        if (numberOfPages < 0) {
            throw new PageException(numberOfPages);
        } else {
            this.numberOfPages = numberOfPages;
        }
    }

    public PDF() {
    }

    public PDF(String s) throws IndexOutOfBoundsException {
        String[] split = s.split(",");
        setCreationDate(split[0]);
        try {
            setFileName(split[1]);
        } catch (NameException e) {
            e.printStackTrace();
        }
        try {
            setAuthor(split[2]);
        } catch (NameException e) {
            e.printStackTrace();
        }
        numberOfPages = Integer.parseInt(split[3]);
        isSecured = Boolean.parseBoolean(split[4]);
    }

    @Override
    public String toString() {
        return super.toString() + "," + numberOfPages + "," + isSecured;
    }

    @Override
    public void printInfo() {
        if (!isSecured) {
            super.printInfo();
            System.out.println("Number of pages: " + numberOfPages);
            System.out.println("Status of PDF file: Not Secured.");
        } else {
            System.out.println("Status of PDF file: Secured: Info is not available.");
        }
    }

    @Override
    public int getEstimatedStorageSize() {
        return numberOfPages * PAGE_SIZE;
    }
}

