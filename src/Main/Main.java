package Main;

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
            System.out.println("3. Exit the Menu!");

            int command = scan.nextInt();
            switch (command) {
                case 1:
                    executePDFSubMenu();
                    break;
                case 2:
                    executeAudioSubMenu();
                    break;
                case 3:
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
            System.out.println("3. Exit the PDF SubMenu");
            int command = scan.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Creating PDF files");
                    //Services.PDF_Service.createPDFFile();
                    break;
                case 2:
                    System.out.println("Printing all PDF files");
                    break;
                case 3:
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
            System.out.println("3. Exit the Audio SubMenu");
            int command = scan.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Creating Audio File");
                    break;
                case 2:
                    System.out.println("Printing all Audio files");
                    break;
                case 3:
                    System.out.println("Exit SubMenu");
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}

