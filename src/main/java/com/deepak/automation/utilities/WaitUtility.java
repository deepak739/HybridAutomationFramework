package com.deepak.automation.utilities;

import com.deepak.automation.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {

    private final WebDriverWait wait;

    public WaitUtility(WebDriver driver) {

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getExplicitWait())
        );
    }

    public WebElement waitForVisibility(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public WebElement waitForClickable(By locator) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));

    }

    public boolean waitForVisibilityOfElement(By locator) {

        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(locator))
                .isDisplayed();

    }

}