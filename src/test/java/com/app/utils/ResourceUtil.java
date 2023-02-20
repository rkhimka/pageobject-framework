package com.app.utils;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ResourceUtil {

    private ResourceUtil() {
    }

    public static String getConfigPropertyValue(String property) {
        return getConfigProperties().getProperty(property);
    }

    /**
     * for Jira test management system integration TODO
     * @param property
     */
    public static String getTmsPropertyValue(String property) {
        return getTmsProperties().getProperty(property);
    }

    public static Properties getConfigProperties() {
        return getProperties("config.properties");
    }

    /**
     * for Jira test management system integration TODO
     */
    public static Properties getTmsProperties() {
        return getProperties("testmanagementsystem.properties");
    }

    @SneakyThrows(IOException.class)
    public static Properties getProperties(String propertiesFileName) {
        Properties prop = new Properties();
        InputStream input = ResourceUtil.class.getClassLoader().getResourceAsStream(propertiesFileName);
        prop.load(input);
        return prop;
    }

}

