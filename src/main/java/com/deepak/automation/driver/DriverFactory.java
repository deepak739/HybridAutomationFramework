package com.deepak.automation.driver;

import com.deepak.automation.config.ConfigReader;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory() {
    }

    // Thread-safe WebDriver storage
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeBrowser() {

        String browser = ConfigReader.getBrowser();

        setDriver(BrowserFactory.getBrowser(browser));

        getDriver().manage().window().maximize();

        getDriver().manage().deleteAllCookies();

        getDriver().get(ConfigReader.getUrl());
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