package com.sda.io;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class LegacyFileManipulator implements IFileManipulator {

    @Override
    public List<String> readFromFile(PathType pathType) {
        List<String> fileLines = new LinkedList<>();
        String path = "";
        switch (pathType) {
            case RELATIVE:
                path = RELATIVE_FILE_PATH;
                break;
            case ABSOLUTE:
                path = ABSOLUTE_FILE_PATH;
                break;
            default:
                System.out.println("Unsupported type: " + pathType);
        }

        try (BufferedReader inputStream =
                     new BufferedReader(new FileReader(path))) {
            String line = inputStream.readLine();
            while (line != null) {
                fileLines.add(line);
                line = inputStream.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileLines;
    }

    @Override
    public void writeToFile(List<String> linesToWrite) {
        try (FileWriter fileWriter = new FileWriter(RELATIVE_FILE_PATH, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             PrintWriter printWriter = new PrintWriter(bufferedWriter);) {

            for (String line : linesToWrite) {
                printWriter.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
