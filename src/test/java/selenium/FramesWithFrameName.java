package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesWithFrameName {

	public static void main(String[] args)
	{
       //Launch browser
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert2");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tryhome']")));
		//driver.switchTo().frame("iframeResult");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Try it']")));
		driver.findElement(By.xpath("//*[text()='Try it']")).click();
		String a=driver.switchTo().alert().getText();
		System.out.println("the text in alert is "+a);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		driver.close();
		}
}
