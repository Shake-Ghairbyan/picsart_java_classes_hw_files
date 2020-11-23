package Interfaces;

public interface I_File {

    void printInfo();

    void printAuthor();

    void setCreationDate(String str);

    void setAuthor(String str);

    void setLastModified(String lastModified);

    void setFileName(String fileName);

    void setStorageSize(double storageSize);

    void setFileFormat(String fileFormat); //getters as well

}
