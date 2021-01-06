package Main;

import Services.AudioService;
import Services.FileService;
import Services.PDFService;
import Services.VideoService;

import java.util.Scanner;

/**
 * This class is used for executing separate menus of different file formats and main menu
 * for the registered users.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */

public class FilesMenus {
    /**
     * This function executes Main Menu for the registered users allowing them
     * to enter to files' submenus.
     *
     * @since 2021-01-04
     */
    static void executeMainMenu() {
        Scanner scan = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("----------Menu-----------");
            System.out.println("1. Choose PDF SubMenu");
            System.out.println("2. Choose Audio SubMenu");
            System.out.println("3. Choose Video SubMenu");
            System.out.println("4. Print total count of created Files.");
            System.out.println("5. Exit the Menu!");

            int command = scan.nextInt();
            switch (command) {
                case 1 -> executePDFSubMenu();
                case 2 -> executeAudioSubMenu();
                case 3 -> executeVideoSubMenu();
                case 4 -> System.out.println("Total number of created files during current session: "
                        + FileService.getCount());
                case 5 -> {
                    System.out.println("Have a nice day.");
                    isActive = false;
                }
                default -> System.out.println("Invalid command");
            }
        }
    }

    /**
     * This function executes submenu for pdf files, allowing registered users create pdf file,
     * and read pdf files, that are already written into the text file, with given options.
     *
     * @since 2021-01-04
     */

    static void executePDFSubMenu() {
        Scanner scan = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("------------PDF SubMenu--------------");
            System.out.println("1. Create PDF File");
            System.out.println("2. Print all PDF files");
            System.out.println("3. Print all PDF files by number of pages.");
            System.out.println("4. Print all PDF files by Authors.");
            System.out.println("5. Print all PDF files by file names in ascending order.");
            System.out.println("6. Print all PDF files by file names in descending order.");
            System.out.println("7. Print all Non-Secured PDF files.");
            System.out.println("8. Exit the PDF SubMenu");
            int command = scan.nextInt();
            switch (command) {
                case 1 -> PDFService.createPDFFile();
                case 2 -> PDFService.printPDFFiles();
                case 3 -> PDFService.printPDFFilesSortedByPNumberOfPages();
                case 4 -> PDFService.printSortedByAuthor();
                case 5 -> PDFService.printSortedByPDFFileNameInAscendingOrder();
                case 6 -> PDFService.printSortedByPDFFileNameInDescendingOrder();
                case 7 -> PDFService.printNonSecuredPDFFiles();
                case 8 -> {
                    System.out.println("Exit SubMenu");
                    isActive = false;
                }
                default -> System.out.println("Invalid command");
            }
        }
    }

    /**
     * This function executes submenu for audio files, allowing registered users create audio file,
     * and read audio files, that are already written into the text file, with given options.
     *
     * @since 2021-01-04
     */
    static void executeAudioSubMenu() {
        Scanner scan = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("------------Audio SubMenu--------------");
            System.out.println("1. Create Audio File");
            System.out.println("2. Print all Audio files");
            System.out.println("3. Print all Audio files sorted by duration.");
            System.out.println("4. Print all Audio files sorted by Author.");
            System.out.println("5. Print all Audio files by file names in ascending order.");
            System.out.println("6. Print all Audio files by file names in descending order.");
            System.out.println("7. Print all Licensed Audio files");
            System.out.println("8. Exit the Audio SubMenu");
            int command = scan.nextInt();
            switch (command) {
                case 1 -> AudioService.createAudioFile();
                case 2 -> AudioService.printAudioFiles();
                case 3 -> AudioService.sortByTrackDuration();
                case 4 -> AudioService.printSortedByAuthor();
                case 5 -> AudioService.printSortedByAudioFileNameInAscendingOrder();
                case 6 -> AudioService.printSortedByAudioFileNameInDescendingOrder();
                case 7 -> AudioService.printLicensedAudioFiles();
                case 8 -> {
                    System.out.println("Back to the Main Menu.");
                    isActive = false;
                }
                default -> System.out.println("Invalid command");
            }
        }
    }

    /**
     * This function executes submenu for video files, allowing registered users create video file,
     * and read video files, that are already written into the text file, with given options.
     *
     * @since 2021-01-04
     */
    static void executeVideoSubMenu() {
        Scanner scan = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("------------Video SubMenu--------------");
            System.out.println("1. Create Video File");
            System.out.println("2. Print all Video files");
            System.out.println("3. Print all Video files sorted by duration.");
            System.out.println("4. Print Video files with duration more than 10 seconds /10,000 mls/.");
            System.out.println("5. Print Video files with duration less/equal than/to 10 seconds /10,000 mls/.");
            System.out.println("6. Print all Video files sorted by their contents length.");
            System.out.println("7. Play selected Video file from the Video files.");
            System.out.println("8. Exit the Video SubMenu");
            int command = scan.nextInt();
            switch (command) {
                case 1 -> VideoService.createVideoFile();
                case 2 -> VideoService.printVideoFiles();
                case 3 -> VideoService.sortByDuration();
                case 4 -> VideoService.printVideosWithDurationGreaterThan(10000);
                case 5 -> VideoService.printVideosWithDurationLessOrEqualThan(10000);
                case 6 -> VideoService.sortByContentsLength();
                case 7 -> VideoService.playSelectedVideo();
                case 8 -> {
                    System.out.println("Back to the Main Menu.");
                    isActive = false;
                }
                default -> System.out.println("Invalid command");
            }
        }
    }
}
