package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetCssValue {

	public static void main(String[] args) 
	{
		        //Launch browser
				System.setProperty("webdriver.chrome.driver","chromedriver.exe");
				ChromeDriver driver=new ChromeDriver();
				driver.get("http://www.way2sms.com");
				WebDriverWait wait=new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
				driver.manage().window().maximize();
				String y=driver.findElement(By.name("mobileNo")).getCssValue("front-size");
			    System.out.println("Font size value for mobile number element is "+y);
			    String z=driver.findElement(By.linkText("Forgot password")).getCssValue("color");
				System.out.println("Css Value for forgot password element is "+z);
				driver.close();

	}

}
