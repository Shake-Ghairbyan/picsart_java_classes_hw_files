package Model;

import Exceptions.InvalidAuthorNameException;
import Exceptions.InvalidFileNameException;
import Interfaces.Printable;
import Interfaces.CSVable;

/**
 * This class implements Printable, CSVable interface and is created tp provide
 * its instances base File features /fields, methods/.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public abstract class File implements Printable, CSVable {
    private String creationDate = "No date";
    private String fileName = "No name";
    private String author = "No Name";

    /**
     * This method is used to get the creation date
     * of an instance of File class.
     *
     * @return creationDate
     * @since 2021-01-04
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * This method is used to set the creation date
     * for an instance of File class.
     *
     * @param creationDate creation Date of the File's instance
     * @since 2021-01-04
     */
    public void setCreationDate(String creationDate) {
        if (creationDate.length() > 0) {
            this.creationDate = creationDate;
        }
    }

    /**
     * This method is used to get the file name
     * of an instance of File class.
     *
     * @return String fileName
     * @since 2021-01-04
     */

    public String getFileName() {
        return fileName;
    }

    /**
     * This method is used to set the file name
     * for an instance of File class.
     *
     * @param fileName file name of the File's instance
     * @throws InvalidFileNameException is thrown when name of the file of the File class' instance is not valid
     *                                  /non-empty string/.
     * @since 2021-01-04
     */

    public void setFileName(String fileName) throws InvalidFileNameException {
        if (fileName.length() <= 0) {
            throw new InvalidFileNameException(fileName);
        }
        this.fileName = fileName;
    }

    /**
     * This method is used to get the Author's name
     * of an instance of File class.
     *
     * @return author
     * @since 2021-01-04
     */

    public String getAuthor() {
        return author;
    }

    /**
     * This method is used to set the Author's name
     * for an instance of File class.
     *
     * @param author inserted value for the Author's name for an instance of File class.
     * @throws InvalidAuthorNameException is thrown when Author's name of File's
     *                                    instance is not valid.
     * @since 2021-01-04
     */

    public void setAuthor(String author) throws InvalidAuthorNameException {
        if (!author.matches("[A-Za-z\\s\\.]+")) {
            throw new InvalidAuthorNameException(author);
        }
        this.author = author;
    }

    @Override
    public String toCSVString() {
        return creationDate + "," + fileName + "," + author;
    }

    @Override
    public void printInfo() {
        System.out.println("___________________________");
        System.out.println("File name: " + getFileName());
        System.out.println("Author: " + getAuthor());
        System.out.println("Created: " + getCreationDate());
        System.out.println("Estimated Storage Size: " + getEstimatedStorageSize() + " bytes");
    }

    /**
     * This method is to be used to get the estimated storage size of
     * a new instance of File class.
     *
     * @return int
     * @since 2021-01-04
     */
    public abstract int getEstimatedStorageSize();
}
