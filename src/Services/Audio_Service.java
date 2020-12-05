package Services;

import Media_SubClasses.Audio;
import Text_SubClasses.PDF;

import java.io.IOException;
import java.util.Scanner;

public class Audio_Service {
    private static final String PATH = "ForAudioObjects.txt";

    public static Audio createAudioFile() throws Exception {
        Scanner scan = new Scanner(System.in);
        Audio audio = new Audio();
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
        try {
            File_Service.write(PATH, audio);
        } catch (IOException e){
            System.out.println("Could not write to the file.");
        }        System.out.println("***************************");
        return audio;
    }

    private static Audio[] readAudioFiles() {
        String[] strings = {};
        try {
            strings = File_Service.read(PATH);
        } catch (IOException e) {
            System.out.println("Could not read Audio files");
        }
        Audio[] audios = new Audio[strings.length];
        for (int i = 0; i < audios.length; i++) {
            try {
                audios[i] = new Audio(strings[i]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Could not read PDF files due to corrupted record");
                return new Audio[]{};
            }
        }
        return audios;
    }

    public static void printAudioFiles() throws Exception {
        for (Audio a : readAudioFiles()) {
            a.printInfo();
        }
    }

    public static void sortByTrackDuration() throws Exception {
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
}

