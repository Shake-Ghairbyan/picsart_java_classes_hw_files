package Model;


public class File {
    private String creationDate = "No info available";
    private String lastModified = "No info available";
    private String fileFormat = "No info available.";
    private String fileName = "No name";
    private double storageSize;
    private String author = "No Name";

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        if (creationDate != null && creationDate.length() > 0) {
            this.creationDate = creationDate;
        }
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        if (lastModified != null && lastModified.length() > 0) {
            this.lastModified = lastModified;
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

    public double getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(double storageSize) {
        if (storageSize < 0) {
            System.out.println("Invalid input for storage size");
        } else {
            this.storageSize = storageSize;
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

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        if (fileFormat != null && fileFormat.length() > 0) {
            this.fileFormat = fileFormat;
        }
    }


    public  File(){

    }
    public File(String creationDate, String lastModified, String fileFormat, String fileName, double storageSize, String author) {
        setCreationDate(creationDate);
        setLastModified(lastModified);
        setFileFormat(fileFormat);
        setFileName(fileName);
        setStorageSize(storageSize);
        setAuthor(author);
    }

    public void printInfo() {
        System.out.println("___________________________");
        System.out.println("File name: " + getFileName() + "." + getFileFormat());
        System.out.println("Author: " + getAuthor()); //%s - string
        System.out.println("Created: " + getCreationDate());
        System.out.println("Last Modified: " + getLastModified());
        System.out.println("File Size: " + getStorageSize());
    }
}
