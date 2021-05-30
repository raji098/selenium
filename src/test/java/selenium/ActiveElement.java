package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActiveElement {

	public static void main(String[] args)throws Exception 
	{
		//Launch Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.switchTo().activeElement().sendKeys("rajkumaripalaadugula");
		Thread.sleep(3000);
		driver.findElement(By.name("identifier")).clear();
		Thread.sleep(3000);
		//Close site
		driver.close();	

	}

}
