package Services;

import Media_SubClasses.Audio;
import Text_SubClasses.PDF;

import java.util.Scanner;

public class Audio_Service {
    private static String path = "ForAudioObjects.txt";

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
        File_Service.write(path, audio);
        System.out.println("***************************");
        return audio;
    }

    public static void printAudioFiles() throws Exception {
        String[] audios = File_Service.read(path);
        if (File_Service.checkArrayIsEmpty(audios)) {
            return;
        }
        for (String a : audios) {
            Audio audio = new Audio(a);
            audio.printInfo();
        }
    }

    public static void sortByTrackDuration() throws Exception {
        String[] audios = File_Service.read(path);
        if (File_Service.checkArrayIsEmpty(audios)) {
            return;
        }
        Audio[] real_Audios = new Audio[audios.length];
        for (int i = 0; i < real_Audios.length; i++) {
            real_Audios[i] = new Audio(audios[i]);
        }
        for (int i = 0; i < real_Audios.length; i++) {
            for (int j = 0; j < audios.length - 1 - i; j++) {
                if (real_Audios[j].getDurationOfTrack() > real_Audios[j + 1].getDurationOfTrack()) {
                    Audio reservedAudio = real_Audios[j];
                    real_Audios[j] = real_Audios[j + 1];
                    real_Audios[j + 1] = reservedAudio;
                }
            }
        }
        for (Audio a : real_Audios) {
            a.printInfo();
        }
    }
}

