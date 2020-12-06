package Services;

import Model.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


class File_Service {
    public static String[] read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
    }

    public static void write(String path, File file) throws IOException {
        Files.write(Paths.get(path), file.toString().getBytes(), StandardOpenOption.APPEND);
    }
}