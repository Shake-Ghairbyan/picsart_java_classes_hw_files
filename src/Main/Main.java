package Main;

import Services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        entryMenu();
    }

    /**
     * This method is used to implement a menu for users registration /sing up, login.../.
     *
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    private static void entryMenu() {
        Scanner scan = new Scanner(System.in);
        boolean isActive = true;
        while (isActive) {
            System.out.println("----------Menu-----------");
            System.out.println("1. Sign up.");
            System.out.println("2. Already signed in? Log in.");
            System.out.println("3. Exit Login Menu.");
            int command = scan.nextInt();
            switch (command) {
                case 1:
                    UserService.signUp();
                    break;
                case 2:
                    UserService.login();
                    break;
                case 3:
                    System.out.println("Leaving so soon?");
                    System.out.println("Bye");
                    isActive = false;
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }
}

