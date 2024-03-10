package com.appium.core.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertyManager {
    public static final String PATH_TO_PROJECT_PROPERTIES = "src/test/resources/project.properties";
    public String getProperty(String propertyName) {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream(String.valueOf(Paths.get(PATH_TO_PROJECT_PROPERTIES)));
            property.load(fis);
        } catch (IOException e) {
            System.err.println("File is not existed");
        }
        return property.getProperty(propertyName);

    }
}
