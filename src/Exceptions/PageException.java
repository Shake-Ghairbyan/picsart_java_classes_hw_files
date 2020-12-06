package Exceptions;

public class PageException extends Exception {

    public PageException(int numberOfPage) {
        super("Number of Pages can't be negative: " + numberOfPage);
    }
}
