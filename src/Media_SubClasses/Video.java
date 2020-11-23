package Media_SubClasses;

import Interfaces.I_Video;

public class Video extends Audio implements I_Video {
    private String resolution = "1920x720";
    private String producer = "No name";
    private String artist = "No info.";
    private String videoGenre = "No genre specified.";


    public String getVideoGenre() {
        return videoGenre;
    }

    @Override
    public void setVideoGenre(String videoGenre) {
        if (videoGenre.length() > 0 && videoGenre != null) {
            this.videoGenre = videoGenre;
        }
    }

    public String getResolution() {
        return resolution;
    }

    @Override
    public void setResolution(String resolution) {
        if (resolution != null && resolution.length() > 0) {
            this.resolution = resolution;
        }
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public void setArtist(String artist) {
        if (artist != null && artist.length() > 0) {
            this.artist = artist;
        }
    }

    public Video(String creationDate, String lastModified, String fileFormat, String fileName, double storageSize,
                 String author, double durationOfTrack, boolean isOriginalRecord, boolean isPlaybackAvailable,
                 String playlist, String artist, String producer, String resolution, String videoGenre) {
        super(creationDate, lastModified, fileFormat, fileName, storageSize, author, durationOfTrack, isOriginalRecord,
                isPlaybackAvailable, playlist);
        setArtist(artist);
        setProducer(producer);
        setResolution(resolution);
        setVideoGenre(videoGenre);
    }

    @Override
    public void printInfo() {
        if (getDurationOfTrack() <= 0) {
            System.out.println("No data in the video file");
        } else {
            super.printInfo();
            System.out.println("Resolution of the video: " + resolution);
            System.out.println("Producer: " + producer);
            System.out.println("Artist: " + artist);
            System.out.println("Video Genre: " + videoGenre);
        }
    }

    @Override
    public void zoomIn() {
        System.out.println("You just zoomed in the video");
    }

    @Override
    public void zoomOut() {
        System.out.println("You just zoomed out the video");
    }

    @Override
    public void changeQuality(String res) {
        if (resolution.compareTo(res) != 0) {
            resolution = res;
            System.out.println("Quality is changed to " + resolution);
        } else {
            System.out.println("No changes made");
        }

    }

    @Override
    public String turnOnCaptions() {
        return "Turned On";
    }

    @Override
    public String turnOffCaptions(){
        return  "Turned On";
    }
}

