package com.deepak.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    // Locators
    private final By usernameTextBox = By.name("username");
    private final By passwordTextBox = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enters username in the username field.
     */
    public LoginPage enterUsername(String username) {

        logger.info("Entering username.");

        type(usernameTextBox, username);

        return this;
    }

    /**
     * Enters password in the password field.
     */
    public LoginPage enterPassword(String password) {

        logger.info("Entering password.");

        type(passwordTextBox, password);

        return this;
    }

    /**
     * Clicks on Login button.
     */
    public DashboardPage clickLoginButton() {

        logger.info("Clicking Login button.");

        click(loginButton);

        return new DashboardPage(driver);
    }

    /**
     * Performs complete login.
     */
    public DashboardPage login(String username, String password) {

        logger.info("Login process started.");

        enterUsername(username);

        enterPassword(password);

        DashboardPage dashboardPage = clickLoginButton();

        logger.info("Login process completed.");

        return dashboardPage;
    }

}