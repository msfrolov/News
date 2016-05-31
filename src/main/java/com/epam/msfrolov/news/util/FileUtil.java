package com.epam.msfrolov.news.util;

import com.epam.msfrolov.news.exception.AppException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class FileUtil {

    public static Properties getProperties(String fileName) {
        try {
            Properties properties = new Properties();
            properties.load(FileUtil.class.getClassLoader().getResourceAsStream(fileName));
            return properties;
        } catch (IOException e) {
            throw new AppException("IOException: failed to get property", e);
        }
    }

    public static List<String> read(String uri) {
        Path path = Paths.get(uri);
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new AppException("IOException: failed to get strings from file", e);
        }
    }

}
