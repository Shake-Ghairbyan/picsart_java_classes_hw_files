package Services;

import Model.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


class FileService {
    public static String[] read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
    }

    public static void write(String path, File file) throws IOException {
        String s = file.toString() + "\n";
        Path path1 = Paths.get(path);
        if (Files.exists(path1)) {
            Files.write(path1, s.getBytes(), StandardOpenOption.APPEND);
        } else {
            Files.write(path1, s.getBytes(), StandardOpenOption.CREATE_NEW);
        }
    }
}