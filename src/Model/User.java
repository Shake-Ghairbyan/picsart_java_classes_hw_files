package Model;

import Exceptions.RegistrationExceptions.InvalidEmailException;
import Exceptions.RegistrationExceptions.InvalidFullNameException;
import Exceptions.RegistrationExceptions.InvalidPasswordException;
import Exceptions.RegistrationExceptions.InvalidUsernameException;
import Interfaces.Stringify;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Stringify {
    private String fullName;
    private String username;
    private String email;
    private String passwordHash;

    /**
     * This method is used to construct new instance of User class,
     * from the stringified file that is read from "database.txt".
     *
     * @param s
     * @throws InvalidFullNameException
     * @throws InvalidUsernameException
     * @throws InvalidEmailException
     * @version 1.0
     * @since 2021-01-04
     */

    public User(String s) throws InvalidFullNameException, InvalidUsernameException, InvalidEmailException {
        String[] split = s.split(",");
        setFullName(split[0]);
        setUsername(split[1]);
        setEmail(split[2]);
        passwordHash = split[3];
    }

    /**
     * This method is used to construct new instance of User class.
     *
     * @version 1.0
     * @since 2021-01-04
     */

    public User() {

    }

    /**
     * This method is used to get the full name of the instance of User class.
     *
     * @return fullName
     * @version 1.0
     * @since 2021-01-04
     */

    public String getFullName() {
        return fullName;
    }


    /**
     * This method is used to set the full name for the instance of User class.
     *
     * @param fullName
     * @throws InvalidFullNameException
     * @version 1.0
     * @since 2021-01-04
     */

    public void setFullName(String fullName) throws InvalidFullNameException {
        if (fullName.matches("[A-Z][a-z]*[ ][A-Z][a-z]*")) {
            this.fullName = fullName;
        } else {
            throw new InvalidFullNameException(fullName);
        }
    }

    /**
     * This method is used to get the username of the instance of User class.
     *
     * @return username
     * @version 1.0
     * @since 2021-01-04
     */

    public String getUsername() {
        return username;
    }

    /**
     * This method is used to set the username for the instance of User class.
     *
     * @param username
     * @throws InvalidUsernameException
     * @version 1.0
     * @since 2021-01-04
     */

    public void setUsername(String username) throws InvalidUsernameException {
        if (username.length() > 10) {
            this.username = username;
        } else {
            throw new InvalidUsernameException("Invalid input data: ", username);
        }
    }

    /**
     * This method is used to get the email of the instance of User class.
     *
     * @return email
     * @version 1.0
     * @since 2021-01-04
     */

    public String getEmail() {
        return email;
    }

    /**
     * This method is used to set the username for the instance of User class.
     *
     * @param email
     * @throws InvalidEmailException
     * @version 1.0
     * @since 2021-01-04
     */

    public void setEmail(String email) throws InvalidEmailException {
        if (validate(email)) {
            this.email = email;
        } else {
            throw new InvalidEmailException(email);
        }
    }


    /**
     * This method is used to set the password for the instance of User class.
     *
     * @param password
     * @throws InvalidPasswordException
     * @version 1.0
     * @since 2021-01-04
     */

    public void setPassword(String password) throws InvalidPasswordException {
        if (password.length() <= 8) {
            throw new InvalidPasswordException(password);
        }
        validatePasswordUpperCase(password);
        validatePasswordNums(password);
        this.passwordHash = getMd5(password);
    }

    @Override
    public String toString() {
        return fullName + "," + username + "," + email + "," + passwordHash;
    }

    /**
     * This method is used to hash the password for the instance of User class.
     *
     * @param input
     * @throws RuntimeException
     * @version 1.0
     * @since 2021-01-04
     */

    private static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * This method is used to check whether the entered password /hashed/
     * for the instance of User class equals the hashed password
     * kept in database for the current user /username/.
     *
     * @param enteredPassword inserted password to be checked whether its hashed version equals
     *                        the hashed password kept in database for the current user /username/.
     * @return boolean
     * @version 1.0
     * @since 2021-01-04
     */

    public boolean checkPassword(String enteredPassword) {
        return getMd5(enteredPassword).equals(passwordHash);
    }

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    /**
     * This method is used to validate if the entered password
     * for the instance of User class contains at least three
     * digits, that are required to be for password field.
     *
     * @param password password of the User's instance.
     * @return boolean
     * @throws InvalidPasswordException is thrown to indicate that password of the user is not valid
     *                                  /should contain at least 8 symbols, 2 upper case letters and 3 numbers/.
     * @version 1.0
     * @since 2021-01-04
     */

    private static boolean validatePasswordNums(String password) throws InvalidPasswordException {
        int counOfNums = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                ++counOfNums;
            }
        }
        if (counOfNums >= 3) {
            return true;
        }
        throw new InvalidPasswordException("Inserted password doesn't contain numbers or not sufficient quantity.");
    }


    /**
     * This method is used to validate if the entered password
     * for the instance of User class contains at least two UpperCase
     * letters, that are required to be for password field.
     *
     * @param password password of the User's instance.
     * @return boolean
     * @throws InvalidPasswordException is thrown to indicate that password of the user is not valid
     *                                  /should contain at least 8 symbols, 2 upper case letters and 3 numbers/.
     * @version 1.0
     * @since 2021-01-04
     */
    private static boolean validatePasswordUpperCase(String password) throws InvalidPasswordException {
        int countOfUpperCase = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                ++countOfUpperCase;
            }
        }
        if (countOfUpperCase >= 2) {
            return true;
        }
        throw new InvalidPasswordException("Inserted password doesn't contain UpperCase letters /at least 2/.");
    }
}
