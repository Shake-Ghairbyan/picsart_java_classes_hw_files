package Services;

import Interfaces.CSVable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * File Service is used to write/read to/from text file for classes that implements CSVable interface.
 */
public class FileService {

    /**
     * This field is created to be used as count keeper of how many files were created during current session.
     *
     * @since 2021-01-04
     */

    private static int count = 0;

    /**
     * This method is used to get the count of how many files were created during current session
     * at the called moment.
     *
     * @return count
     * @since 2021-01-04
     */
    public static int getCount() {
        return count;
    }


    /**
     * This method is used to read stringified instances of File class from their path
     * and return them as List of Strings.
     *
     * @param path the path of the text file from where stringified instances of File class are read.
     * @throws IOException is thrown if an I/O error occurs writing to or creating the file
     * @since 2021-01-04
     */

    static List<String> read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    /**
     * This method is used to write instances of File class to their specified path,
     * and if such path doesn't exist, create that path.
     * .
     *
     * @param path the path to the file.
     * @param t    the instance of class that implements CSVable interface
     *             to be written to the file with provided
     * @throws IOException is thrown if an I/O error occurs writing to or creating the file.
     * @since 2021-01-04
     */

    static void write(String path, CSVable t) throws IOException {
        String s = t.toCSVString() + "\n";
        Path path1 = Paths.get(path);
        if (Files.exists(path1)) {
            Files.write(path1, s.getBytes(), StandardOpenOption.APPEND);
        } else {
            Files.write(path1, s.getBytes(), StandardOpenOption.CREATE_NEW);
        }
        ++count;
    }
}
