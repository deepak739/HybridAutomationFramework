package com.deepak.automation.driver;

import com.deepak.automation.config.ConfigReader;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory() {
    }

    // Thread-safe WebDriver storage
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeBrowser() {

        String browser = System.getProperty("browser", ConfigReader.getBrowser());
        setDriver(BrowserFactory.getBrowser(browser));
    }

    public static WebDriver getDriver() {

        return driver.get();

    }

    public static void setDriver(WebDriver webDriver) {

        driver.set(webDriver);

    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();

            driver.remove();

        }
    }
}