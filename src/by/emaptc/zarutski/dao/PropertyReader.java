package by.emaptc.zarutski.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static PropertyReader instance = new PropertyReader();
    private Properties properties = new Properties();

    private PropertyReader() {
    }

    public static PropertyReader getInstance() {
        return instance;
    }

    public String getProperty(String propertyName) {
        String property = null;

        try (InputStream input = new FileInputStream("resources" + File.separator + "regex.properties")) {
            properties.load(input);
            property = properties.getProperty(propertyName);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }

        return property;
    }
}
