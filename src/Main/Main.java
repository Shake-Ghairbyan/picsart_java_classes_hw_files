package Main;

import Media_SubClasses.*;
import Text_SubClasses.*;

public class Main {
    public static void main(String[] args) {
        Audio audio1 = new Audio("20 Nov 2020", "20 Nov 2020", "mp3", "audio1",
                444, "Gharibyan Sh.", 44, false, false,
                "some tracks");
        audio1.printInfo();
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
        System.out.println("***************************");

        PPT ppt1 = new PPT("", "", "ppt", "ppt1", 128, "Sam Smith",
                12, true);
        ppt1.printInfo();
    }
}
