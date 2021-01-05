package Model;

import Exceptions.ExceptionsForRegistration.EmailException;
import Exceptions.ExceptionsForRegistration.FullNameException;
import Exceptions.ExceptionsForRegistration.PasswordException;
import Exceptions.ExceptionsForRegistration.UsernameException;
import Exceptions.NameException;
import Exceptions.PageException;
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
     * @throws FullNameException
     * @throws UsernameException
     * @throws EmailException
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public User(String s) throws FullNameException, UsernameException, EmailException {
        String[] split = s.split(",");
        setFullName(split[0]);
        setUsername(split[1]);
        setEmail(split[2]);
        passwordHash = split[3];
    }

    /**
     * This method is used to construct new instance of User class.
     *
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public User() {

    }

    /**
     * This method is used to get the full name of the instance of User class.
     *
     * @return fullName
     * @author Shake Gharibyan
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
     * @throws FullNameException
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public void setFullName(String fullName) throws FullNameException {
        if (fullName.matches("[A-Z][a-z]*[ ][A-Z][a-z]*")) {
            this.fullName = fullName;
        } else {
            throw new FullNameException(fullName);
        }
    }

    /**
     * This method is used to get the username of the instance of User class.
     *
     * @return username
     * @author Shake Gharibyan
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
     * @throws UsernameException
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public void setUsername(String username) throws UsernameException {
        if (username.length() > 10) {
            this.username = username;
        } else {
            throw new UsernameException("Invalid input data: ", username);
        }
    }

    /**
     * This method is used to get the email of the instance of User class.
     *
     * @return email
     * @author Shake Gharibyan
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
     * @throws EmailException
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public void setEmail(String email) throws EmailException {
        if (validate(email)) {
            this.email = email;
        } else {
            throw new EmailException(email);
        }
    }


    /**
     * This method is used to set the password for the instance of User class.
     *
     * @param password
     * @throws PasswordException
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    public void setPassword(String password) throws PasswordException {
        if (password.length() <= 8) {
            throw new PasswordException(password);
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
     * @author Shake Gharibyan
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
     * This method is used to check whether the entered password
     * for the instance of User class equals the hashed password
     * kept in database.
     *
     * @return enteredPassword
     * @author Shake Gharibyan
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
     * @param password
     * @return boolean
     * @throws PasswordException
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */

    private static boolean validatePasswordNums(String password) throws PasswordException {
        int counOfNums = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                ++counOfNums;
            }
        }
        if (counOfNums >= 3) {
            return true;
        }
        throw new PasswordException("Inserted password doesn't contain numbers or not sufficient quantity.");
    }


    /**
     * This method is used to validate if the entered password
     * for the instance of User class contains at least two UpperCase
     * letters, that are required to be for password field.
     *
     * @param password
     * @return boolean
     * @throws PasswordException
     * @author Shake Gharibyan
     * @version 1.0
     * @since 2021-01-04
     */
    private static boolean validatePasswordUpperCase(String password) throws PasswordException {
        int countOfUpperCase = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                ++countOfUpperCase;
            }
        }
        if (countOfUpperCase >= 2) {
            return true;
        }
        throw new PasswordException("Inserted password doesn't contain UpperCase letters /at least 2/.");
    }
}
