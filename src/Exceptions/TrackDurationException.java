package Exceptions;

public class TrackDurationException extends Exception {

    public TrackDurationException(double t) {
        super("Track duration can't be negative" + t);
    }
}
