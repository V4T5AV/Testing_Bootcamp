package NavigationCommands;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverNavigationComands {
	WebDriver driver;
	
	@Test(priority=0)
	public void NavigateDemo() {
		driver =new ChromeDriver();
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		String BrowserTitle=driver.getTitle();
		System.out.println(BrowserTitle);
		String BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		
		driver.navigate().back();
		BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		
	}
	
    @Test(priority=1)
	
	public void NavigateRefresh() {
		driver =new ChromeDriver();
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		String URL=driver.getCurrentUrl();
		System.out.println(URL);
		String BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		
		driver.navigate().back();
		BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		
	}
	
	@Test(priority=3)
	
	public void NavigateForward() {
		driver =new ChromeDriver();
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		String BrowserTitle=driver.getTitle();
		System.out.println(BrowserTitle);
		String BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		
		driver.navigate().back();
		BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		
		driver.navigate().forward();
		BrowserURL=driver.getCurrentUrl();
		System.out.println(BrowserURL);
		
		
	}

}