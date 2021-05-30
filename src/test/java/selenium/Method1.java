package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Method1 {

	public static void main(String[] args) throws Exception 
	{
		//Launch Browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","True");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.amazon.co.in");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contact")));
		driver.findElement(By.linkText("Contact")).click();
		Thread.sleep(5000);
		//Close 
		driver.close();
	}

}
