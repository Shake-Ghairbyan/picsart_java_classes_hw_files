package Main;

import Services.AudioService;
import Services.FileService;
import Services.PDFService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        executeMainMenu();
    }

    static void executeMainMenu() {
        Scanner scan = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("----------Menu-----------");
            System.out.println("1. Choose PDF SubMenu");
            System.out.println("2. Choose Audio SubMenu");
            System.out.println("3. Print total count of created Files.");
            System.out.println("4. Exit the Menu!");

            int command = scan.nextInt();
            switch (command) {
                case 1:
                    executePDFSubMenu();
                    break;
                case 2:
                    executeAudioSubMenu();
                    break;
                case 3:
                    System.out.println("Total number of created files during current session: " + FileService.getCount());
                    break;
                case 4:
                    System.out.println("Have a nice day.");
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    static void executePDFSubMenu() {
        Scanner scan = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("------------PDF SubMenu--------------");
            System.out.println("1. Create PDF File");
            System.out.println("2. Print all PDF files");
            System.out.println("3. Print all PDF files by number of pages.");
            System.out.println("4. Print all PDF files by Authors.");
            System.out.println("5. Exit the PDF SubMenu");
            int command = scan.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Creating PDF files");
                    PDFService.createPDFFile();
                    break;
                case 2:
                    System.out.println("Printing all PDF files");
                    PDFService.printPDFFiles();
                    break;
                case 3:
                    PDFService.printPDFFilesSortedByPNumberOfPages();
                    break;
                case 4:
                    PDFService.printSortedByAuthor();
                    break;
                case 5:
                    System.out.println("Exit SubMenu");
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    static void executeAudioSubMenu() {
        Scanner scan = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("------------Audio SubMenu--------------");
            System.out.println("1. Create Audio File");
            System.out.println("2. Print all Audio files");
            System.out.println("3. Print all Audio files sorted by duration.");
            System.out.println("4. Print all Audio files sorted by Author.");
            System.out.println("5. Exit the Audio SubMenu");
            int command = scan.nextInt();
            switch (command) {
                case 1:
                    AudioService.createAudioFile();
                    break;
                case 2:
                    AudioService.printAudioFiles();
                    break;
                case 3:
                    AudioService.sortByTrackDuration();
                    break;
                case 4:
                    AudioService.printSortedByAuthor();
                    break;
                case 5:
                    System.out.println("Back to the Main Menu.");
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}

