package Services;

import Exceptions.TrackDurationException;
import Exceptions.NameException;
import Model.Audio;
import Model.File;

import java.io.IOException;
import java.util.Scanner;

public class AudioService {
    private static final String PATH = "ForAudioObjects.txt";

    public static Audio createAudioFile() {
        Scanner scan = new Scanner(System.in);
        Audio audio = new Audio();
        System.out.println("***************************");
        System.out.println("Insert creation Date");
        audio.setCreationDate(scan.nextLine());
        System.out.println("Print file name");
        try {
            audio.setFileName(scan.nextLine());
        } catch (NameException e) {
            e.printStackTrace();
        }
        System.out.println("Print Author's name");
        try {
            audio.setAuthor(scan.nextLine());
        } catch (NameException e) {
            e.printStackTrace();
        }
        System.out.println("Insert duration of the track in seconds");
        try{
            audio.setDurationOfTrack(scan.nextInt());
        } catch (TrackDurationException e){
            e.printStackTrace();
            ++File.count;
        }
        System.out.println("Set mode for record status: 1. Licensed , 2. Not Licensed.");
        audio.setLicensedRecord(scan.nextInt() == 1);
        try {
            FileService.write(PATH, audio);
        } catch (IOException e) {
            System.out.println("Could not write to the file.");
        }
        System.out.println("***************************");
        return audio;
    }

    private static Audio[] readAudioFiles() {
        String[] strings = {};
        try {
            strings = FileService.read(PATH);
        } catch (IOException e) {
            System.out.println("Could not read Audio files");
        }
        Audio[] audios = new Audio[strings.length];
        for (int i = 0; i < audios.length; i++) {
            try {
                audios[i] = new Audio(strings[i]);
            } catch (IndexOutOfBoundsException | NameException | TrackDurationException e) {
                System.out.println("Could not read PDF files due to corrupted record");
                return new Audio[]{};
            }
        }
        return audios;
    }

    public static void printAudioFiles() {
        for (Audio a : readAudioFiles()) {
            a.printInfo();
        }
    }

    public static void sortByTrackDuration() {
        Audio[] audios = readAudioFiles();
        for (int i = 0; i < audios.length; i++) {
            for (int j = 0; j < audios.length - 1 - i; j++) {
                if (audios[j].getDurationOfTrack() > audios[j + 1].getDurationOfTrack()) {
                    Audio reservedAudio = audios[j];
                    audios[j] = audios[j + 1];
                    audios[j + 1] = reservedAudio;
                }
            }
        }
        for (Audio a : audios) {
            a.printInfo();
        }
    }

    public static void printSortedByAuthor() {
        Audio[] audios = readAudioFiles();
        for (int i = 0; i < audios.length; i++) {
            for (int j = 0; j < audios.length - 1 - i; j++) {
                int compare = audios[j].getAuthor().compareTo(audios[j + 1].getAuthor());
                if (compare > 0) {
                    Audio reservedAudio = audios[j];
                    audios[j] = audios[j + 1];
                    audios[j + 1] = reservedAudio;
                }
            }
        }
        for (Audio a : audios) {
            a.printInfo();
        }
    }
}

