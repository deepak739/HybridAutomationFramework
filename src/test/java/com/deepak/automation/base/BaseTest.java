package com.deepak.automation.base;

import com.deepak.automation.config.ConfigReader;
import com.deepak.automation.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {

        //ConfigReader.loadProperties();

        DriverFactory.initializeBrowser();

        WebDriver driver = DriverFactory.getDriver();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.get(ConfigReader.getUrl());

        System.out.println("Browser Name = " +
                ((org.openqa.selenium.remote.RemoteWebDriver) DriverFactory.getDriver())
                        .getCapabilities()
                        .getBrowserName());

        System.out.println("Browser Version = " +
                ((org.openqa.selenium.remote.RemoteWebDriver) DriverFactory.getDriver())
                        .getCapabilities()
                        .getBrowserVersion());

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        //DriverFactory.quitDriver();

        System.out.println("AfterMethod Executed");

       // Thread.sleep(60000);

    }
}