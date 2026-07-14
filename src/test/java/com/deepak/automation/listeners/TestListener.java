package com.deepak.automation.listeners;

import com.aventstack.extentreports.Status;
import com.deepak.automation.driver.DriverFactory;
import com.deepak.automation.reporting.ExtentManager;
import com.deepak.automation.reporting.ExtentTestManager;
import com.deepak.automation.utilities.ScreenshotUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {

        logger.info("Execution Started");

        ExtentManager.getInstance();

    }

    @Override
    public void onTestStart(ITestResult result) {

        logger.info("Starting Test : {}",
                result.getMethod().getMethodName());

        ExtentTestManager.setTest(

                ExtentManager
                        .getInstance()
                        .createTest(result.getMethod().getMethodName())

        );

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        logger.info("Test Passed : {}",
                result.getMethod().getMethodName());

        ExtentTestManager
                .getTest()
                .log(Status.PASS, "Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        logger.error("Test Failed : {}",
                result.getMethod().getMethodName());

        String screenshotPath =
                ScreenshotUtility.captureScreenshot(
                        DriverFactory.getDriver(),
                        result.getMethod().getMethodName());

        ExtentTestManager
                .getTest()
                .log(Status.FAIL, result.getThrowable());

        try {

            ExtentTestManager
                    .getTest()
                    .addScreenCaptureFromPath(screenshotPath);

        } catch (Exception e) {

            logger.error("Unable to attach screenshot", e);

        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        logger.warn("Test Skipped : {}",
                result.getMethod().getMethodName());

        ExtentTestManager
                .getTest()
                .log(Status.SKIP, "Test Skipped");

    }

    @Override
    public void onFinish(ITestContext context) {

        logger.info("Execution Finished");

        ExtentManager.flushReport();

        ExtentTestManager.unload();

    }

}