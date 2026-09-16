package radioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButtonsDemo2 {
	
	@Test
	public void TestDemo() throws Exception{
		WebDriver driver =new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement male =driver.findElement(By.id("male"));
		male.click();
		System.out.println("Male selected :"+male.isSelected());
		
		boolean status=driver.findElement(By.id("male")).isSelected();
		System.out.println(status);
		
		boolean displayed=driver.findElement(By.id("male")).isDisplayed();
		System.out.println(displayed);
		
		boolean enabled=driver.findElement(By.id("male")).isEnabled();
		System.out.println(enabled);
		
	}

}
