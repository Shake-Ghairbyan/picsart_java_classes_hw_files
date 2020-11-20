package Text_SubClasses;
import Model.File;
public class PDF extends File {
    private int numberOfPages;
    private boolean isSecured;

    public boolean isSecured() {
        return isSecured;
    }

    public void setSecured(boolean secured) {
        isSecured = secured;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
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

