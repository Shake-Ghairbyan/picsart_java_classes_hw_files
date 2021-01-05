package Services;

import Exceptions.RegistrationExceptions.InvalidEmailException;
import Exceptions.RegistrationExceptions.InvalidFullNameException;
import Exceptions.RegistrationExceptions.InvalidUsernameException;
import Model.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * This class is used for working with user class instances and has methods for creating user /signUp()/,
 * reading created users from text file, and if user is in the database, allowing the user to enter to
 * next level menu.
 *
 * @author Shake Gharibyan
 * @version 1.0
 * @since 2021-01-04
 */
public class UserService {

    /**
     * This field shows the name of .txt file where created users' info will be written/stored.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    private static final String PATH = "database.txt";

    /**
     * This method is created to be used to create User and write them in the database if succeeded.
     *
     * @throws Exception
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    public static void signUp() {
        Scanner scan = new Scanner(System.in);
        User user = new User();
        try {
            System.out.println("Insert Name and Surname");
            System.out.println("/Name and surname must start with UpperCase and separated by space/");
            user.setFullName(scan.nextLine());
            System.out.println("Insert username /at least 10 symbols/.");
            String insertedUsername = scan.nextLine();
            if (!readUsers().isEmpty()) {
                System.out.println("Checking if such username is already used .... ");
                if (readUsers().containsKey(insertedUsername)) {
                    throw new InvalidUsernameException("Such username already exists: ", insertedUsername);
                }
            }
            user.setUsername(insertedUsername);
            System.out.println("Insert email address.");
            user.setEmail(scan.nextLine());
            System.out.println("Insert password /at least 8 symbols, 2 upper case letters and 3 numbers/.");
            user.setPassword(scan.nextLine());
            FileService.write(PATH, user);
            System.out.println("Congrats! Successfully signed up.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Inputs are discarded");
        }
    }

    /**
     * This method is created to be used to read already created users from the database text file.
     *
     *
     * @throws IndexOutOfBoundsException
     * @throws InvalidEmailException
     * @throws InvalidFullNameException
     * @throws InvalidUsernameException
     * @throws IOException
     * @return HashMap of Users
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public static HashMap<String, User> readUsers() {
        HashMap<String, User> users = new HashMap<>();
        try {
            List<String> strings = FileService.read(PATH);
            for (String s : strings) {
                User user = new User(s);
                users.put(user.getUsername(), user);
            }
            return users;
        } catch (IndexOutOfBoundsException | InvalidEmailException | InvalidFullNameException | InvalidUsernameException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Users database is empty.");
        }
        return new HashMap<>();
    }

    /**
     * This method is created to be used to allow registered user to access Files_Menus, if true.
     *
     * @return boolean
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     * */
    public static boolean login() {
        if (!readUsers().isEmpty()) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Insert username.");
            String username = scan.nextLine();
            HashMap<String, User> users = readUsers();
            User currentUser = users.get(username);
            if (currentUser != null) {
                System.out.println("Insert password");
                String password = scan.nextLine();
                if (currentUser.checkPassword(password)) {
                    System.out.println("Successfully logged in.");
                    Files_Menus.executeMainMenu();
                    return true;
                } else {
                    System.out.println("Incorrect password!");
                }
            } else {
                System.out.println("Incorrect login!");
            }
        }
        return false;
    }
}
