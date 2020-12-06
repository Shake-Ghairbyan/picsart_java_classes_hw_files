package Exceptions.AudioExceptions;

public class TrackDurationException extends RuntimeException {

    public TrackDurationException(double t) {
        super("Track duration can't be negative" + t);
    }
}
