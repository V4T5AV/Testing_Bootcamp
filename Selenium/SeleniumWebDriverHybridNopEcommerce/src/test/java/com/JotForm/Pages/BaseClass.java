package com.JotForm.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import Utility.BrowserFactory;
import Utility.ConfigDataProvider;
import Utility.ExcelDataReader;
import Utility.Helper;

public class BaseClass {

    public WebDriver driver;
    public ExcelDataReader excel;
    public ConfigDataProvider config;

    @BeforeSuite
    public void setUp() {

        excel = new ExcelDataReader();
        config = new ConfigDataProvider();
    }

    @BeforeClass
    public void browserTest() {

        driver = BrowserFactory.startBrowser(
                config.getBrowser(),
                config.getAppURL()
        );
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println("Test failed. Taking screenshot...");

            if (driver != null) {
                Helper.capturedScreenShot(driver);
            }
        }
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            BrowserFactory.closeBrowser(driver);
        }
    }
}