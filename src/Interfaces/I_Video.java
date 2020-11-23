package Interfaces;

public interface I_Video extends I_Media{
    void zoomIn();
    void zoomOut();
    void changeQuality(String res);
    String turnOnCaptions();
    void setVideoGenre(String genre);
    void setResolution(String res);
    void setArtist(String art);
    String turnOffCaptions();
    void setProducer(String prd);
}
