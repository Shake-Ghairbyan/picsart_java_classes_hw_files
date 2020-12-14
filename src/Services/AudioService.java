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

public class AudioService {
    private static final String PATH = "ForAudioObjects.txt";

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

    private static List<Audio> readAudioFiles() {
        try {
            List<String> strings = FileService.read(PATH);
            List<Audio> audios = new ArrayList<>();
            for (String s: strings) {
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

    public static void printAudioFiles() {
        PrintableService.printAllInfo(readAudioFiles());
    }

    public static void sortByTrackDuration() {
        List<Audio> audios = readAudioFiles();
        Collections.sort(audios, new DurationComparator());
        PrintableService.printAllInfo(audios);
    }

    public static void printSortedByAuthor() {
        List<Audio> audios = readAudioFiles();
        Collections.sort(audios, new AuthorComparator());
        PrintableService.printAllInfo(audios);
    }
}

