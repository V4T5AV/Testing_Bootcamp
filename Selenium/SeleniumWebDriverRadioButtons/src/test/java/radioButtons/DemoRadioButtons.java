package radioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoRadioButtons {

	@Test
	public void TestRadiobtn() throws Exception{
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.xpath("//input[@id='male']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='female']")).click();
		Thread.sleep(5000);


		int radiobtn =driver.findElements(By.xpath("//input[@id='sex']")).size();
		System.out.println("No.of radio buttons :"+radiobtn);
		driver.quit();
		

	}
}
