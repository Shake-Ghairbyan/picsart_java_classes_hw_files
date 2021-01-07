package Exceptions;

/**
 * This class extends Exception and TrackDurationException is thrown
 * when track's duration was assigned a negative value.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class InvalidTrackDurationException extends Exception {

    /**
     * This method constructs a new TrackDurationException with specified detail message.
     *
     * @param t Track duration of the Audio's instance:
     *          should be non negative value.
     * @since 2021-01-04
     */

    public InvalidTrackDurationException(double t) {
        super("Track duration can't be negative" + t);
    }
}
