package com.deepak.automation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementActions {

    private final WebDriver driver;

    private final WaitUtility waitUtility;

    public ElementActions(WebDriver driver) {

        this.driver = driver;

        this.waitUtility = new WaitUtility(driver);

    }

    public void click(By locator) {

        waitUtility.waitForClickable(locator).click();

    }

    public void type(By locator, String text) {

        WebElement element =
                waitUtility.waitForVisibility(locator);

        element.clear();

        element.sendKeys(text);

    }

    public String getText(By locator) {

        return waitUtility.waitForVisibility(locator).getText();

    }

    public boolean isDisplayed(By locator) {

        return waitUtility.waitForVisibility(locator).isDisplayed();

    }

}