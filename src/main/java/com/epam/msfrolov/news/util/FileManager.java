package com.epam.msfrolov.news.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 */
public class FileManager {

    /**
     *
     * @param fileName
     * @return
     */
    public static Properties getProperties(String fileName) {
        try {
            Properties properties = new Properties();
            properties.load(FileManager.class.getClassLoader().getResourceAsStream(fileName));
            return properties;
        } catch (IOException e) {
            throw new AppException("IOException: failed to get property", e);
        }
    }

    /**
     *
     * @param path
     * @return
     */
    public static List<String> read(String path) {

        //Files.readAllLines(path); // use it

        InputStream in = FileManager.class.getClassLoader().getResourceAsStream(path);
        Scanner sc = new Scanner(in);
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine())
            lines.add(sc.nextLine());
        return lines;
    }

}
