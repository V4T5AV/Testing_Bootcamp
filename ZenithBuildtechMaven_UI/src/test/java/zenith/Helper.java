package zenith;

import java.io.File;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Helper {
    public static WebDriver startBrowser() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    public static String appUrl() {
        URL resource = Helper.class.getClassLoader().getResource("enquiry.html");
        if (resource == null) throw new IllegalStateException("enquiry.html not found");
        return new File(resource.getFile()).toURI().toString();
    }
    public static WebDriverWait wait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10));
    }
}
