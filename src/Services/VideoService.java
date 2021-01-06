package Services;

import Exceptions.InvalidAuthorNameException;
import Exceptions.InvalidFileNameException;
import Exceptions.InvalidTrackDurationException;
import Model.Video;

import java.io.IOException;
import java.util.*;

public class VideoService {
    /**
     * This field shows where created files will be written.
     *
     * @since 2021-01-04
     */
    private static final String PATH = "VideoObjects.txt";

    /**
     * This method is used to create new video file.
     *
     * @since 2021-01-04
     */

    public static void createVideoFile() {
        Scanner scan = new Scanner(System.in);
        Video video = new Video();
        try {
            System.out.println("***************************");
            System.out.println("Insert creation Date");
            video.setCreationDate(scan.nextLine());
            System.out.println("Print file name");
            video.setFileName(scan.nextLine());
            System.out.println("Print Author's name");
            video.setAuthor(scan.nextLine());
            System.out.println("Insert duration of the video in milliseconds");
            video.setDuration(scan.nextInt());
            scan.nextLine();
            System.out.println("Insert the content to be played");
            video.setContents(scan.nextLine());
            FileService.write(PATH, video);
            System.out.println("***************************");
        } catch (InvalidAuthorNameException | InvalidTrackDurationException | IOException |
                InvalidFileNameException e) {
            System.out.println(e);
            System.out.println("Inputs are discarded");
        }
    }

    /**
     * This method reads video files from the text file and
     * returns the written video files as an ArrayList of video files.
     *
     * @return new ArrayList<>();
     * @since 2021-01-04
     */

    private static List<Video> readVideoFiles() {
        try {
            List<String> strings = FileService.read(PATH);
            List<Video> videos = new ArrayList<>();
            for (String s : strings) {
                videos.add(new Video(s));
            }
            return videos;
        } catch (IndexOutOfBoundsException | InvalidAuthorNameException | InvalidTrackDurationException |
                InvalidFileNameException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Could not read Video files");
        }
        return new ArrayList<>();
    }

    /**
     * Prints video files written in the text file.
     *
     * @since 2021-01-04
     */
    public static void printVideoFiles() {
        PrintableService.printAllInfo(readVideoFiles());
    }

    /**
     * Prints video files written in the text file sorted by video's duration in ascending order.
     *
     * @since 2021-01-04
     */
    public static void sortByDuration() {
        List<Video> videos = readVideoFiles();
        videos.sort(Comparator.comparingLong(Video::getDuration));
        PrintableService.printAllInfo(videos);
    }

    /**
     * Prints video files written in the text file sorted by video's content's length in ascending order.
     *
     * @since 2021-01-04
     */
    public static void sortByContentsLength() {
        List<Video> videos = readVideoFiles();
        videos.sort(Comparator.comparingInt(v -> v.getContents().length()));
        PrintableService.printAllInfo(videos);
    }

    /**
     * This method is used to print those instances of the Video class that are read from text file,
     * which have duration greater than mills.
     *
     * @param mills to compare to.
     * @since 2021-01-04
     */
    public static void printVideosWithDurationGreaterThan(long mills) {
        readVideoFiles()
                .stream()
                .filter(a -> a.getDuration() > mills)
                .forEach(Video::printInfo);
    }

    /**
     * This method is used to print those instances of the Video class that are read from text file,
     * which have duration less/equal than mills.
     *
     * @param mills to compare to.
     * @since 2021-01-04
     */
    public static void printVideosWithDurationLessOrEqualThan(long mills) {
        readVideoFiles()
                .stream()
                .filter(a -> a.getDuration() <= mills)
                .forEach(Video::printInfo);
    }

    /**
     * Prints selected video file out of videos written in the text file sorted by video's content's length in ascending order.
     *
     * @since 2021-01-04
     */
    public static void playSelectedVideo() {
//        List<Video> videos = readVideoFiles();
//        int videosSize = videos.size();
//
//        if (videosSize == 0) {
//            System.out.println("Videos are empty.");
//            return;
//        }
//
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Please input number from 1 to " + videosSize
//                + " to print selected video file.");
//        System.out.println("Videos are sorted in ascending order based on contents length");
//        int index = scan.nextInt() - 1;
//
//        if (index < 0 || index > videosSize) {
//            System.out.println("Inputted number is out of range!");
//        } else {
//            videos.get(scan.nextInt()).printInfo();
//        }
    }
}

