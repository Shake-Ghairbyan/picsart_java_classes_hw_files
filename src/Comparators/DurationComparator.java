package Comparators;

import Model.Audio;

import java.util.Comparator;

/**
 * This class implements Comparator interface and is used as a comparator to
 * compare two instances of Audio class by their Duration.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class DurationComparator implements Comparator<Audio> {

    /**
     * This method is used to compare two instances of Audio class by comparing
     * their durations length.
     *
     * @param /Audio audio/
     * @param /Audio audio/
     * @return int
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    @Override
    public int compare(Audio a1, Audio a2) {
        return Double.compare(a1.getDurationOfTrack(), a2.getDurationOfTrack());
    }
}
