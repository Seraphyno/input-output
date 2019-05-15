package com.sda.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;

public class ModernFileManipulator implements IFileManipulator {

    @Override
    public List<String> readFromFile(PathType pathType) {
        List<String> lines = new LinkedList<>();
        try {
            switch (pathType) {
                case ABSOLUTE:
                    lines = Files.readAllLines(Paths.get(ABSOLUTE_FILE_PATH));
                    break;
                case RELATIVE:
                    lines = Files.readAllLines(Paths.get(RELATIVE_FILE_PATH));
                    break;
                default:
                    System.out.println("Unsupported type: " + pathType);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return lines;
    }

    @Override
    public void writeToFile(List<String> linesToWrite) {
        try {
            Path path = Paths.get(RELATIVE_FILE_PATH);
            Files.write(path, linesToWrite, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
