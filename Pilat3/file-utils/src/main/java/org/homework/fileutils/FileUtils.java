package org.homework.fileutils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {
    public static void writeToFile(String directoryPath, String fileName, String content) throws IOException {
        String targetDir = (directoryPath == null || directoryPath.isEmpty()) ? "." : directoryPath;

        Path dirPath = Paths.get(targetDir);

        Files.createDirectories(dirPath);

        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("Ім'я файлу не може бути порожнім.");
        }

        Path filePath = dirPath.resolve(fileName);

        Files.writeString(filePath, content);
    }
}