package selenium;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindow {

	public static void main(String[] args) throws Exception 
	{
		//Launch Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.sbicard.com/");
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Login'])[4]")));
		driver.findElement(By.xpath("(//*[text()='Login'])[4]")).click();
		Thread.sleep(5000);
		ArrayList<String> s=new ArrayList<String>(driver.getWindowHandles());
		//Set<String> a=driver.getWindowHandles();
		//ArrayList<String> s=new ArrayList<String>(a);
		int c=s.size();
		System.out.println("No of tabs opened are"+c);
		for(int i=0;i<s.size();i++)
		{
			System.out.println("Browser tab "+(i+1)+" is "+s.get(i));
		}
		driver.switchTo().window(s.get(1));
		driver.findElement(By.name("username")).sendKeys("raji");
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(s.get(0));
		driver.findElement(By.xpath("(//*[text()='Pay Now'])[2]")).click();
		Thread.sleep(3000);
		//close browser
		driver.quit();

	}

}
