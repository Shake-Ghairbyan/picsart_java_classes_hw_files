package Interfaces;

public interface I_Media extends I_File {
    void play();
    void stop();
    String volumeUp();
    String volumeDown();
    void recordAudio();
    void setDurationOfTrack(double dur);
    void setVoice_volume(int volume);
    void setPlaybackAvailable(boolean bb);
    void setPlaylist(String list);
    void setOriginalRecord(boolean orRec);
}
