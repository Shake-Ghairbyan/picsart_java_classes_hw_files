package Exceptions.FileExceptions;

public class NameException extends Exception {

    public NameException(String name) {
        super("Wrong value for name input: " + name);
    }
}
