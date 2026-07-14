package com.deepak.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    // Locator
    private final By lblDashboard = By.xpath("//h6[text()='Dashboard']");

    // Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Business Method
     * Verifies whether Dashboard page is displayed.
     */
    public boolean isDashboardDisplayed() {

        return isDisplayed(lblDashboard);

    }
}