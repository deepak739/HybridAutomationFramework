package com.deepak.automation.driver;

import com.deepak.automation.config.ConfigReader;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory() {
    }

    // Thread-safe WebDriver storage
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initializeBrowser() {

        String systemBrowser = System.getProperty("browser");
        String configBrowser = ConfigReader.getBrowser();

        System.out.println("====================================");
        System.out.println("System Property Browser : " + systemBrowser);
        System.out.println("Config Browser          : " + configBrowser);

        String browser = System.getProperty("browser", configBrowser);

        System.out.println("Final Browser           : " + browser);

        setDriver(BrowserFactory.getBrowser(browser));

        System.out.println("Driver Class            : " + getDriver().getClass().getName());
        System.out.println("====================================");
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