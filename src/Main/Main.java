package Main;

import Interfaces.I_File;
import Interfaces.I_Video;
import Media_SubClasses.*;
import Model.File;
import Text_SubClasses.*;

public class Main {
    public static void main(String[] args) {
        Audio audio1 = new Audio("20 Nov 2020", "20 Nov 2020", "mp3", "audio1",
                444, "Gharibyan Sh.", 44, false, false,
                "some tracks");
        audio1.printInfo();
        audio1.recordAudio();
        audio1.setVoice_volume(66);
        System.out.println(audio1.getVoice_volume());
        audio1.stop();
        System.out.println(audio1.volumeUp());
        System.out.println("***************************");

        PDF pdf1 = new PDF();
        pdf1.setFileFormat("pdf");
        pdf1.setFileName("SmithSmith");
        pdf1.setNumberOfPages(4);
        pdf1.setSecured(true);
        pdf1.printInfo();
        System.out.println("***************************");

        Video video1 = new Video("20 Nov 2020", "20 Nov 2020", "mp4", "video1",
                12560, "Jack Daniels", 3600, false, true,
                "Avatar, Great Gatsby", "", "", "1,280×720", "Fantasy");
        video1.printInfo();
        System.out.println(video1.volumeDown());
        video1.play();
        video1.zoomIn();
        video1.zoomOut();
        video1.changeQuality("1920x720");
        video1.turnOnCaptions();
        video1.turnOffCaptions();
        System.out.println("***************************");

        PPT ppt1 = new PPT("", "", "ppt", "ppt1", 128, "Sam Smith",
                12, true);
        ppt1.printInfo();
        System.out.println("***************************");
        ppt1.printAuthor();
        ppt1.setAuthor("Guuuan hisdl");
        ppt1.printAuthor();
        ppt1.setCreationDate("20 Nov 2020");
        printFile(video1);
    }

    public static void printFile(I_File f) {
        f.printAuthor();
    }

}

