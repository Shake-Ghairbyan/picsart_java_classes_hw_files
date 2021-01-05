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
                case 1 -> UserService.signUp();
                case 2 -> {
                    if (UserService.login()) {
                        System.out.println("Successfully logged in.");
                        Files_Menus.executeMainMenu();
                    };
                }
                case 3 -> {
                    System.out.println("Leaving so soon?");
                    System.out.println("Bye");
                    isActive = false;
                }
                default -> System.out.println("Invalid command.");
            }
        }
    }
}

