package Model;

import Exceptions.InvalidAuthorNameException;
import Exceptions.InvalidFileNameException;
import Exceptions.InvalidPageNumberException;

/**
 * This class is used to create PDF files.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class PDF extends File {
    private static final int PAGE_SIZE = 70 * 1024;
    private int numberOfPages;
    private boolean isSecured;

    /**
     * This method is used to get the status of the instance of PDF class, whether it is secured or not.
     *
     * @return boolean
     * @since 2021-01-04
     */
    public boolean isSecured() {
        return isSecured;
    }

    /**
     * This method is used to set the status of the instance of PDF class, whether it is secured or not.
     *
     * @param isSecured boolean variable to set the status of the PDf class' instance:
     *                  true: Secured status, false: Not - Secured Status.
     * @since 2021-01-04
     */
    public void setSecured(boolean isSecured) {
        this.isSecured = isSecured;
    }

    /**
     * This method is used to get the number of pages of the instance of PDF class.
     *
     * @return numberOfPages
     * @since 2021-01-04
     */

    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * This method is used to set the number of pages for the instance of PDF class.
     *
     * @param numberOfPages inserted number of pages for the instance of PDF class.
     * @throws InvalidPageNumberException is thrown when assigned values of pages of PDF file is negative.
     * @since 2021-01-04
     */

    public void setNumberOfPages(int numberOfPages) throws InvalidPageNumberException {
        if (numberOfPages < 0) {
            throw new InvalidPageNumberException(numberOfPages);
        }
        this.numberOfPages = numberOfPages;
    }

    /**
     * This method is used to construct new instance of PDF class.
     *
     * @since 2021-01-04
     */

    public PDF() {
    }

    /**
     * This method is used to construct new instance of PDF class,
     * from the stringified file.
     *
     * @param s CSVString of PDF class.
     * @throws InvalidAuthorNameException is thrown when Author's full name of the File class' instance is not valid
     *                                    /both first name and last name must be UpperCase and should
     *                                    be separated by space/.
     * @throws IndexOutOfBoundsException  is thrown if an index of some sort (such as to an array, to a string,
     *                                    or to a vector) is out of range.
     * @throws InvalidPageNumberException is thrown when assigned values of pages of PDF file is negative.
     * @since 2021-01-04
     */

    public PDF(String s) throws IndexOutOfBoundsException, InvalidAuthorNameException,
            InvalidPageNumberException, InvalidFileNameException {
        String[] split = s.split(",");
        setCreationDate(split[0]);
        setFileName(split[1]);
        setAuthor(split[2]);
        setNumberOfPages(Integer.parseInt(split[3]));
        setSecured(Boolean.parseBoolean(split[4]));
    }

    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + numberOfPages + "," + isSecured;
    }

    @Override
    public void printInfo() {
        if (!isSecured) {
            super.printInfo();
            System.out.println("Number of pages: " + numberOfPages);
            System.out.println("Status of PDF file: Not Secured.");
        } else {
            System.out.println("___________________________________________________");
            System.out.println("Status of PDF file: Secured: Info is not available.");
        }
    }

    @Override
    public int getEstimatedStorageSize() {
        return numberOfPages * PAGE_SIZE;
    }
}

