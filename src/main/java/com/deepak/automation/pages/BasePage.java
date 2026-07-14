package com.deepak.automation.pages;

import com.deepak.automation.utilities.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected final WebDriver driver;

    protected final ElementActions elementActions;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        this.elementActions = new ElementActions(driver);

    }

    protected void click(By locator){

        elementActions.click(locator);

    }

    protected void type(By locator,String text){

        elementActions.type(locator,text);

    }

    protected String getText(By locator){

        return elementActions.getText(locator);

    }

    protected boolean isDisplayed(By locator){

        return elementActions.isDisplayed(locator);

    }

}


//package com.deepak.automation.pages;
//
//import com.deepak.automation.utilities.WaitUtility;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class BasePage {
//
//    protected final WebDriver driver;
//    protected final WaitUtility waitUtility;
//
//    public BasePage(WebDriver driver) {
//
//        this.driver = driver;
//        this.waitUtility = new WaitUtility(driver);
//
//    }
//
//    protected void click(By locator) {
//
//        waitUtility.waitForClickable(locator).click();
//
//    }
//
//    protected void type(By locator, String text) {
//
//        WebElement element = waitUtility.waitForVisibility(locator);
//
//        element.clear();
//        element.sendKeys(text);
//    }
//
//    protected String getText(By locator) {
//
//        return waitUtility.waitForVisibility(locator).getText();
//
//    }
//
//    protected boolean isDisplayed(By locator) {
//
//        return waitUtility.waitForVisibility(locator).isDisplayed();
//
//    }
//}