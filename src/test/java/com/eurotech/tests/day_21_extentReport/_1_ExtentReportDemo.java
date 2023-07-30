package com.eurotech.tests.day_21_extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_ExtentReportDemo {

    ExtentReports report;

    ExtentHtmlReporter htmlReporter;

    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){

        report= new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String reportPath=projectPath+"/test-output/report.html";

        htmlReporter=new ExtentHtmlReporter(reportPath);

        report.attachReporter(htmlReporter);


        htmlReporter.config().setReportName("Smoke Test");

        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Ramazan");
        report.setSystemInfo("PO","Jack Reacher");

    }
    @Test
    public void test1(){
        extentLogger = report.createTest("TC001 Demo Test");

        extentLogger.info("Open Chrome browser");

        extentLogger.info("Navigate to Website "+ConfigurationReader.get("url"));

        extentLogger.info("write an email");

        extentLogger.info("write a password");

        extentLogger.info("click the login");

        extentLogger.info("verify the login with userName "+ConfigurationReader.get("userName"));

        extentLogger.pass("Passed");

    }

    @AfterMethod
    public void tearDown(){
        report.flush();
    }

}
