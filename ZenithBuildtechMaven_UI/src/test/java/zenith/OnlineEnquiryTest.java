package zenith;

import static org.testng.Assert.assertTrue;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OnlineEnquiryTest {
    WebDriver driver;
    Path screenshotDir = Paths.get("target", "screenshots");

    @BeforeMethod
    public void setup() throws Exception {
        Files.createDirectories(screenshotDir);
        driver = Helper.startBrowser();
        driver.get(Helper.appUrl());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test(priority=1)
    public void validEnquirySubmission() throws Exception {
        fillValidData();
        driver.findElement(By.id("send")).click();
        assertTrue(driver.findElement(By.id("result")).getText().equals("Enquiry Sent"));
        screenshot("TC01_Valid_Submission.png");
    }

    @Test(priority=2)
    public void mandatoryFieldsValidation() throws Exception {
        driver.findElement(By.id("send")).click();
        assertTrue(driver.findElement(By.id("error")).getText().contains("Name is required"));
        screenshot("TC02_Mandatory_Validation.png");
    }

    @Test(priority=3)
    public void nameValidation() throws Exception {
        driver.findElement(By.id("name")).sendKeys("John123");
        driver.findElement(By.id("address")).sendKeys("12 Main Road");
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("john@example.com");
        driver.findElement(By.id("message")).sendKeys("Need a residential construction enquiry.");
        driver.findElement(By.id("send")).click();
        assertTrue(driver.findElement(By.id("error")).getText().contains("Name must contain"));
        screenshot("TC03_Name_Validation.png");
    }

    @Test(priority=4)
    public void phoneValidation() throws Exception {
        driver.findElement(By.id("name")).sendKeys("John");
        driver.findElement(By.id("address")).sendKeys("12 Main Road");
        driver.findElement(By.id("phone")).sendKeys("12345");
        driver.findElement(By.id("email")).sendKeys("john@example.com");
        driver.findElement(By.id("message")).sendKeys("Need a residential construction enquiry.");
        driver.findElement(By.id("send")).click();
        assertTrue(driver.findElement(By.id("error")).getText().contains("Phone No must contain exactly 10 digits"));
        screenshot("TC04_Phone_Validation.png");
    }

    @Test(priority=5)
    public void emailValidation() throws Exception {
        driver.findElement(By.id("name")).sendKeys("John");
        driver.findElement(By.id("address")).sendKeys("12 Main Road");
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("johnexample.com");
        driver.findElement(By.id("message")).sendKeys("Need a residential construction enquiry.");
        driver.findElement(By.id("send")).click();
        assertTrue(driver.findElement(By.id("error")).getText().contains("Enter a valid email"));
        screenshot("TC05_Email_Validation.png");
    }

    @Test(priority=6)
    public void pinCodeValidation() throws Exception {
        driver.findElement(By.id("name")).sendKeys("John");
        driver.findElement(By.id("address")).sendKeys("12 Main Road");
        driver.findElement(By.id("pin")).sendKeys("5000");
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("john@example.com");
        driver.findElement(By.id("message")).sendKeys("Need a residential construction enquiry.");
        driver.findElement(By.id("send")).click();
        assertTrue(driver.findElement(By.id("error")).getText().contains("Pin Code must contain exactly 6 digits"));
        screenshot("TC06_Pin_Validation.png");
    }

    @Test(priority=7)
    public void clearFunctionality() throws Exception {
        driver.findElement(By.id("name")).sendKeys("John");
        driver.findElement(By.id("address")).sendKeys("12 Main Road");
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("john@example.com");
        driver.findElement(By.id("message")).sendKeys("Test message");
        driver.findElement(By.id("clear")).click();
        assertTrue(driver.findElement(By.id("name")).getAttribute("value").isEmpty());
        assertTrue(driver.findElement(By.id("message")).getAttribute("value").isEmpty());
        screenshot("TC07_Clear_Functionality.png");
    }

    @Test(priority=8)
    public void companyAndCityOptional() throws Exception {
        fillValidData();
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("send")).click();
        assertTrue(driver.findElement(By.id("result")).getText().equals("Enquiry Sent"));
        screenshot("TC08_Optional_Fields.png");
    }

    @Test(priority=9)
    public void addressMandatoryValidation() throws Exception {
        driver.findElement(By.id("name")).sendKeys("John");
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("john@example.com");
        driver.findElement(By.id("message")).sendKeys("Need a residential construction enquiry.");
        driver.findElement(By.id("send")).click();
        assertTrue(driver.findElement(By.id("error")).getText().contains("Address is required"));
        screenshot("TC09_Address_Mandatory.png");
    }

    @Test(priority=10)
    public void messageMandatoryValidation() throws Exception {
        driver.findElement(By.id("name")).sendKeys("John");
        driver.findElement(By.id("address")).sendKeys("12 Main Road");
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("john@example.com");
        driver.findElement(By.id("send")).click();
        assertTrue(driver.findElement(By.id("error")).getText().contains("Message is required"));
        screenshot("TC10_Message_Mandatory.png");
    }

    private void fillValidData() {
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("company")).sendKeys("Zenith Homes");
        driver.findElement(By.id("address")).sendKeys("12 Main Road, Hyderabad");
        driver.findElement(By.id("city")).sendKeys("Hyderabad");
        driver.findElement(By.id("pin")).sendKeys("500001");
        driver.findElement(By.id("phone")).sendKeys("9876543210");
        driver.findElement(By.id("email")).sendKeys("john@example.com");
        driver.findElement(By.id("message")).sendKeys("I would like an enquiry about constructing a residence.");
    }

    private void screenshot(String name) throws Exception {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(src.toPath(), screenshotDir.resolve(name), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    }
}
