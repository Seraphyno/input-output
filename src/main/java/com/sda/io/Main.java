package com.sda.io;

import java.util.List;

public class Main {

    private static IFileManipulator legacyFileManipulator = new LegacyFileManipulator();
    private static IFileManipulator modernFileManipulator = new ModernFileManipulator();

    public static void main(String[] args) {
        final List<String> lines = readFileAndPrint(legacyFileManipulator, PathType.ABSOLUTE);
        writeFile(lines, legacyFileManipulator);
        readFileAndPrint(legacyFileManipulator, PathType.RELATIVE);

        final List<String> lines1 = readFileAndPrint(modernFileManipulator, PathType.ABSOLUTE);
        writeFile(lines1, modernFileManipulator);
        readFileAndPrint(modernFileManipulator, PathType.RELATIVE);
    }

    private static List<String> readFileAndPrint(IFileManipulator fileManipulator,
                                                 PathType pathType) {
        System.out.println("Reading from file with " +
                fileManipulator.getClass().getSimpleName());
        List<String> lines = fileManipulator.readFromFile(pathType);
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("================================");

        return lines;
    }

    private static void writeFile(List<String> lines, IFileManipulator fileManipulator) {
        System.out.println("Writing to file with " +
                fileManipulator.getClass().getSimpleName());
        fileManipulator.writeToFile(lines);
        System.out.println("Lines written to file");
    }
}
