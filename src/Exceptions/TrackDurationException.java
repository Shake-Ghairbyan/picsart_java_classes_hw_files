package Exceptions;

/**
 * This class extends Exception and TrackDurationException is thrown
 * when track's duration was assigned a negative value.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class TrackDurationException extends Exception {

    /**
     * This method constructs a new TrackDurationException with specified detail message.
     *
     * @param /double trackDuration/
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public TrackDurationException(double t) {
        super("Track duration can't be negative" + t);
    }
}
