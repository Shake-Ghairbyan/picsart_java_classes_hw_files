package Text_SubClasses;

import Model.File;

public class PDF extends File {
    private int numberOfPages;
    private boolean isSecured;

    public boolean isSecured() {
        return isSecured;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setSecured(boolean isSecured) {
        this.isSecured = isSecured;
    }

    public PDF() {
    }

    public PDF(String s) throws IndexOutOfBoundsException {
        String[] split = s.split(",");
        setCreationDate(split[0]);
        setFileName(split[1]);
        setAuthor(split[2]);
        numberOfPages = Integer.parseInt(split[3]);
        isSecured = Boolean.parseBoolean(split[4]);
    }

    @Override
    public String toString() {
        return super.toString() + "," + numberOfPages + "," + isSecured + "\n";
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
}

