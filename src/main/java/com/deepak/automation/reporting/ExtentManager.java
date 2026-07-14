package com.deepak.automation.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentManager {

    private static ExtentReports extentReports;

    private ExtentManager() {

    }

    public static ExtentReports getInstance() {

        if (extentReports == null) {

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(
                            ReportConstants.REPORT_PATH);

            sparkReporter.config().setReportName(
                    ReportConstants.REPORT_TITLE);

            sparkReporter.config().setDocumentTitle(
                    ReportConstants.DOCUMENT_TITLE);

            extentReports = new ExtentReports();

            extentReports.attachReporter(sparkReporter);

        }

        return extentReports;

    }

    public static void flushReport() {

        if (extentReports != null) {

            extentReports.flush();

        }

    }

}