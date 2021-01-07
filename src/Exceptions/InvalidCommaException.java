package Exceptions;


/**
 * This class extends Exception and InvalidCommaException is thrown
 * when content of the Video class' instance contains comma.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class InvalidCommaException extends Exception{
    /**
     * This method constructs a new InvalidCommaException with specified detail message.
     *
     * @param message  The detail message (which is saved for later retrieval by the getMessage() method)
     * @since 2021-01-04
     */

    public InvalidCommaException(String message){
        super("Content should be without comma. Your input: " + message);
    }
}
