package Comparators;

import Model.Audio;

import java.util.Comparator;

public class DurationComparator implements Comparator<Audio> {
    @Override
    public int compare(Audio a1, Audio a2) {
        return Double.compare(a1.getDurationOfTrack(), a2.getDurationOfTrack());
    }
}
