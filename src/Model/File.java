package Model;

import Exceptions.FileExceptions.NameException;
import Interfaces.Printable;


public abstract class File implements Printable {
    private String creationDate = "15 Nov 2020";
    private String fileName = "No name";
    private String author = "No Name";
    public static int count = 0;

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        if (creationDate != null && creationDate.length() > 0) {
            this.creationDate = creationDate;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) throws NameException {
        if (author != null) {
            this.fileName = fileName;
        } else {
            throw new NameException(fileName);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws NameException {
        if (author.length() != 0 ) {
            this.author = author;
        } else {
            throw new NameException(author);
        }
    }

    public String toString() {
        return creationDate + "," + fileName + "," + author;
    }

    @Override
    public void printInfo() {
        System.out.println("___________________________");
        System.out.println("File name: " + getFileName());
        System.out.println("Author: " + getAuthor());
        System.out.println("Created: " + getCreationDate());
    }

    public abstract int getEstimatedStorageSize();
}
