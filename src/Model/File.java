package Model;

import Interfaces.I_File;


public class File implements I_File {
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

    public void setFileName(String fileName) {
        if (fileName != null && fileName.length() > 0) {
            this.fileName = fileName;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && author.length() > 0) {
            this.author = author;
        }
    }

    public File() {
        ++count;
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

    @Override
    public void printAuthor() {
        System.out.println("Author of the file is : " + getAuthor());
    }

}
