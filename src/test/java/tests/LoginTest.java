package tests;

import com.deepak.automation.base.BaseTest;
import com.deepak.automation.config.ConfigReader;
import com.deepak.automation.driver.DriverFactory;
import com.deepak.automation.pages.DashboardPage;
import com.deepak.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        // Arrange
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

        // Act
        DashboardPage dashboardPage = loginPage.login(
                ConfigReader.getUserName(),
                ConfigReader.getPassword());

        // Assert
        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard is not displayed after login."
        );
    }
}