package Model;

import Exceptions.NameException;
import Interfaces.Printable;
import Interfaces.Stringify;


public abstract class File implements Printable, Stringify {
    private String creationDate = "No date";
    private String fileName = "No name";
    private String author = "No Name";

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        if (creationDate.length() > 0) {
            this.creationDate = creationDate;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) throws NameException {
        if (fileName.length() > 0) {
            this.fileName = fileName;
        } else {
            throw new NameException(fileName);
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws NameException {
        if (author.matches("[A-Za-z\\s\\.]+")) {
            this.author = author;
        } else {
            throw new NameException(author);
        }
    }

    @Override
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
