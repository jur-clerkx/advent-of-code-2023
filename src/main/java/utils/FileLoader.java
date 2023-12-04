package utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.List;

import com.google.common.io.Resources;

public class FileLoader {

    private FileLoader() {
        // Utils method doesn't need to be instantiated
    }

    public static List<String> readFile(String path) throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(Resources.getResource(path).toURI()));
    }
}
