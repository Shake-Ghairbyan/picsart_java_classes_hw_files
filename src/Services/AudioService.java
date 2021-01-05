package Services;

import Comparators.AuthorComparator;
import Comparators.DurationComparator;
import Exceptions.NameException;
import Exceptions.TrackDurationException;
import Model.Audio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class is used for working with audio type files /creating, reading, printing,
 * sorting by different options, etc./.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */


public class AudioService {
    /**
     * This field shows where created audio files will be written.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    private static final String PATH = "ForAudioObjects.txt";

    /**
     * This method is used to create new audio file.
     *
     * @throws NameException
     * @throws IOException
     * @throws TrackDurationException
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public static void createAudioFile() {
        Scanner scan = new Scanner(System.in);
        Audio audio = new Audio();
        try {
            System.out.println("***************************");
            System.out.println("Insert creation Date");
            audio.setCreationDate(scan.nextLine());
            System.out.println("Print file name");
            audio.setFileName(scan.nextLine());
            System.out.println("Print Author's name");
            audio.setAuthor(scan.nextLine());
            System.out.println("Insert duration of the track in seconds");
            audio.setDurationOfTrack(scan.nextInt());
            System.out.println("Set mode for record status: 1. Licensed , 2. Not Licensed.");
            audio.setLicensedRecord(scan.nextInt() == 1);
            FileService.write(PATH, audio);
            System.out.println("***************************");
        } catch (NameException | TrackDurationException | IOException e) {
            System.out.println(e);
            System.out.println("Inputs are discarded");
        }
    }

    /**
     * This method reads audio files from the text file and
     * returns the written pdf files as an ArrayList of audio files.
     *
     * @return List
     * @throws IndexOutOfBoundsException
     * @throws NameException
     * @throws TrackDurationException
     * @throws IOException
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    private static List<Audio> readAudioFiles() {
        try {
            List<String> strings = FileService.read(PATH);
            List<Audio> audios = new ArrayList<>();
            for (String s : strings) {
                audios.add(new Audio(s));
            }
            return audios;
        } catch (IndexOutOfBoundsException | NameException | TrackDurationException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Could not read Audio files");
        }
        return new ArrayList<>();
    }

    /**
     * Prints audio files written in the text file.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public static void printAudioFiles() {
        PrintableService.printAllInfo(readAudioFiles());
    }

    /**
     * Prints audio files written in the text file sorted by track duration in ascending order.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public static void sortByTrackDuration() {
        List<Audio> audios = readAudioFiles();
        Collections.sort(audios, new DurationComparator());
        PrintableService.printAllInfo(audios);
    }

    /**
     * Prints audio files written in the text file sorted by track duration in ascending order.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public static void printSortedByAuthor() {
        List<Audio> audios = readAudioFiles();
        Collections.sort(audios, new AuthorComparator());
        PrintableService.printAllInfo(audios);
    }
}

