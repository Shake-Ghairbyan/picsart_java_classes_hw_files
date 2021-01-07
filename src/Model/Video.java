package Model;

import Exceptions.InvalidAuthorNameException;
import Exceptions.InvalidCommaException;
import Exceptions.InvalidFileNameException;
import Exceptions.InvalidTrackDurationException;

public class Video extends File {
    private static final int BIT_RATE = 1280 * 720;
    private long duration;
    private String contents;

    /**
     * This method is used to get the duration of the track in milliseconds.
     *
     * @since 2021-01-04
     */
    public long getDuration() {
        return duration;
    }

    /**
     * This method is used to set the duration of the video instance.
     *
     * @param duration inserted value for the duration of the video
     * @throws InvalidTrackDurationException is thrown when video's duration was assigned a negative value.
     * @since 2021-01-04
     */
    public void setDuration(long duration) throws InvalidTrackDurationException {
        if (duration < 0) {
            throw new InvalidTrackDurationException(duration);
        }
        this.duration = duration;
    }

    /**
     * This method is used to get the content of the video for an instance of Video class.
     *
     * @since 2021-01-04
     */
    public String getContents() {
        return contents;
    }

    /**
     * This method is used to set the contents of the video for an instance of Video class.
     *
     * @param contents inserted value for the duration of the video
     * @since 2021-01-04
     */
    public void setContents(String contents) throws InvalidCommaException {
        if (!contents.matches("[^,]+")) {
            throw new InvalidCommaException(contents);
        }
        this.contents = contents;
    }

    public Video() {
    }

    /**
     * This method is used to construct new instance of Video class,
     * from the stringified file.
     *
     * @param a CSVString of Video class.
     * @throws InvalidAuthorNameException    is thrown when Author name of File's instance is invalid.
     * @throws InvalidTrackDurationException is thrown when Track Duration of the Video's instance
     *                                       is given negative value.
     * @throws InvalidFileNameException      is thrown when name of the file of the File class'
     *                                       instance is not valid /non-empty string/.
     * @since 2021-01-04
     */

    public Video(String a) throws InvalidAuthorNameException, InvalidTrackDurationException,
            InvalidFileNameException, InvalidCommaException {
        String[] split = a.split(",");
        setCreationDate(split[0]);
        setFileName(split[1]);
        setAuthor(split[2]);
        setDuration(Long.parseLong(split[3]));
        setContents(split[4]);
    }

    @Override
    public int getEstimatedStorageSize() {
        return BIT_RATE * contents.length() / 8;
    }

    @Override
    public String toCSVString() {
        return super.toCSVString() + "," + duration + "," + contents;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Duration of the video (mls): " + duration);
        System.out.println("Contents of the video: " + contents);
    }


    public void play() {
        Thread thread = new Thread(() -> {
            int length = contents.length();
            for (int i = 0; i < length; i++) {
                System.out.print(contents.charAt(i));
                try {
                    Thread.sleep(duration / length);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
