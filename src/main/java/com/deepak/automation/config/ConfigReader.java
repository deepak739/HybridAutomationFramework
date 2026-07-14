package com.deepak.automation.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ConfigReader{

    private static Properties properties = new Properties();

    static {
        loadProperties();
    }

    private ConfigReader() {

    }
    public static void loadProperties() {
        try (FileInputStream file = new FileInputStream("src/main/resources/config.properties")) {

            properties.load(file);

        } catch (IOException e) {

            throw new RuntimeException("Failed to load config.properties", e);

        }
    }
    public static String getBrowser()
    {
        return properties.getProperty("browser");
    }
    public static String getUrl()
    {
        return properties.getProperty("url");
    }
    public static String getUserName()
    {
        return properties.getProperty("username");
    }
    public static String getPassword()
    {
        return properties.getProperty("password");
    }
    public static int getExplicitWait() {
        return Integer.parseInt(properties.getProperty("explicitWait"));
    }

    }
