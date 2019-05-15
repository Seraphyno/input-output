package com.sda.io;

import java.util.List;

/**
 * Describes the behavior of file access
 */
public interface IFileManipulator {

    String ABSOLUTE_FILE_PATH = "C:\\Users\\Serafino\\Desktop\\b.txt";
    String RELATIVE_FILE_PATH = IFileManipulator.class.getClassLoader()
                        .getResource("a.txt").getPath()
                        .replaceFirst("/", "");

    /**
     * reads data from the file
     * @return Lines in a collection
     */
    List<String> readFromFile(PathType pathType);

    /**
     * writes the input to the file
     * @param linesToWrite the data to be stored
     */
    void writeToFile(List<String> linesToWrite);
}
