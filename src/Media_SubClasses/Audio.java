package Media_SubClasses;

import Model.File;
import Interfaces.I_Media;

public class Audio extends File implements I_Media {
    private double durationOfTrack = 0.0;
    private int voice_volume = 0;
    private boolean isPlaybackAvailable;
    private String playlist = "Empty"; // should be array, but not for now
    private boolean isOriginalRecord;

    public double getDurationOfTrack() {
        return durationOfTrack;
    }

    @Override
    public void setDurationOfTrack(double durationOfTrack) {
        this.durationOfTrack = durationOfTrack;
    }

    public int getVoice_volume() {
        return voice_volume;
    }

    @Override
    public void setVoice_volume(int voice_volume) {
        if (voice_volume < 0) {
            System.out.println("Invalid input for voice volume!");
        } else {
            this.voice_volume = voice_volume;
        }
    }

    public boolean isPlaybackAvailable() {
        return isPlaybackAvailable;
    }

    @Override
    public void setPlaybackAvailable(boolean playbackAvailable) {
        isPlaybackAvailable = playbackAvailable;
    }

    public String getPlaylist() {
        return playlist;
    }

    @Override
    public void setPlaylist(String playlist) {
        if (playlist.length() > 0) {
            this.playlist = playlist;
        }
    }

    public boolean isOriginalRecord() {
        return isOriginalRecord;
    }

    @Override
    public void setOriginalRecord(boolean originalRecord) {
        isOriginalRecord = originalRecord;
    }

    public Audio(String creationDate, String lastModified, String fileFormat, String fileName, double storageSize,
                 String author, double durationOfTrack, boolean isOriginalRecord, boolean isPlaybackAvailable,
                 String playlist) {
        super(creationDate, lastModified, fileFormat, fileName, storageSize, author);
        setDurationOfTrack(durationOfTrack);
        setOriginalRecord(isOriginalRecord);
        setPlaybackAvailable(isPlaybackAvailable);
        setPlaylist(playlist);
    }

    @Override
    public void printInfo() {
        if (getDurationOfTrack() > 0) {
            super.printInfo();
            System.out.println("Duration of track (s): " + getDurationOfTrack() + "s");
            System.out.println("Voice volume: " + voice_volume);
            System.out.println("Playback availability: " + (isPlaybackAvailable() ? "Yes" : "No"));
            System.out.println("Original Record Status: " + (isOriginalRecord() ? "Yes" : "No"));
            System.out.println("Playlist of the file: " + getPlaylist());
        } else {
            System.out.println("Audio file is empty.");
        }
    }

    @Override
    public void play() {
        System.out.println(getFileName() + " is playing now.");
    }

    @Override
    public void stop() {
        System.out.println(getFileName() + " is on pause.");
    }

    @Override
    public String volumeUp() {
        if (voice_volume >= 100) {
            voice_volume = 100;
            return "Voice is on " + voice_volume + ".. Can't be increased.";
        } else {
            ++voice_volume;
            return "Current voice volume is " + voice_volume;
        }
    }

    @Override
    public String volumeDown() {
        if (voice_volume <= 0) {
            voice_volume = 0;
            return "Voice is on " + voice_volume + ". Can't be decreased.";
        } else {
            --voice_volume;
            return "Current voice volume is " + voice_volume;
        }
    }

    @Override
    public void recordAudio() {
        System.out.println("This file " + getFileName() + " is being recorded");
    }
}

