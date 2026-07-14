package com.deepak.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class BrowserFactory {

    private BrowserFactory() {
        // Prevent object creation
    }

    public static WebDriver getBrowser(String browser) {

        if (browser == null || browser.trim().isEmpty()) {
            throw new IllegalArgumentException("Browser name cannot be null or empty.");
        }

        switch (browser.toLowerCase().trim()) {

            case "chrome":
                return new ChromeDriver();

            case "firefox":
                return new FirefoxDriver();

            case "edge":
                return new EdgeDriver();

            default:
                throw new IllegalArgumentException(
                        "Unsupported browser: " + browser);
        }
    }
}