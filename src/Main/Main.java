package Main;

import Model.File;

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
                    System.out.println("Total number of created files: " + File.count);
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
                    Services.PDF_Service.createPDFFile();
                    break;
                case 2:
                    System.out.println("Printing all PDF files");
                    Services.PDF_Service.printPDFFiles();
                    break;
                case 3:
                    Services.PDF_Service.printPDFFilesSortedByPNumberOfPages();
                    break;
                case 4:
                    Services.PDF_Service.printSortedByAuthor();
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
                    Services.Audio_Service.createAudioFile();
                    break;
                case 2:
                    Services.Audio_Service.printAudioFiles();
                    break;
                case 3:
                    Services.Audio_Service.sortByTrackDuration();
                    break;
                case 4:
                    Services.Audio_Service.printSortedByAuthor();
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

