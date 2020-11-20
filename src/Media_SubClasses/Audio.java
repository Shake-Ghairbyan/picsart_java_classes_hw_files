package Media_SubClasses;
import Model.File;
public class Audio extends File {
    private double durationOfTrack = 0.0;
    private int voice_volume = 0;
    private boolean isPlaybackAvailable;
    private String playlist = "Empty"; // should be array, but not for now
    private boolean isOriginalRecord;

    public double getDurationOfTrack() {
        return durationOfTrack;
    }

    public void setDurationOfTrack(double durationOfTrack) {
        this.durationOfTrack = durationOfTrack;
    }

    public int getVoice_volume() {
        return voice_volume;
    }

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

    public void setPlaybackAvailable(boolean playbackAvailable) {
        isPlaybackAvailable = playbackAvailable;
    }

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        if (playlist.length() > 0) {
            this.playlist = playlist;
        }
    }

    public boolean isOriginalRecord() {
        return isOriginalRecord;
    }

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
}

