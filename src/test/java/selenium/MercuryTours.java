package selenium;

import java.util.Scanner;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MercuryTours {

	public static void main(String[] args)throws Exception
	{
		//Declare Global objects
		RemoteWebDriver driver = null;
		
		//Take input from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Browser Name");
		String bn=sc.nextLine();
		sc.close();
		
		//Similar for all browsers
		//System.setProperty("webdriver.chrome.driver","E:\\Automation\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
           
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		else if(bn.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			 driver=new InternetExplorerDriver();
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			 driver=new OperaDriver();
		}
		else
		{
		System.out.println("Enter correct browser name");
		System.exit(0); //Stop execution forcibly
		}
		//Maximize
		driver.manage().window().maximize();
		//Launch Site
		driver.get("http://demo.guru99.com/test/newtours/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("REGISTER"))).click();
		//fill fields
		driver.findElement(By.name("firstName")).sendKeys("rajkumari");
		driver.findElement(By.name("lastName")).sendKeys("p");
		driver.findElement(By.name("phone")).sendKeys("8073406336");
		driver.findElement(By.name("userName")).sendKeys("raji");
		driver.findElement(By.name("address1")).sendKeys("bangari camp");
		driver.findElement(By.name("city")).sendKeys("sindhanur");
		driver.findElement(By.name("state")).sendKeys("karnataka");
		driver.findElement(By.name("postalCode")).sendKeys("584128");
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		s.selectByVisibleText("INDIA");
		////s.selectByValue("INDIA");
		driver.findElement(By.name("email")).sendKeys("rajkumarichinnu@gmail.com");
		driver.findElement(By.name("password")).sendKeys("raj123");
		driver.findElement(By.name("confirmPassword")).sendKeys("raj123");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("submit"))).click();
		Thread.sleep(5000);
		String x=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your user name is rajkumarichinnu')]"))).getText();
		if(x.contains("rajkumarichinnu"))
		{
			System.out.println("Registration Test Passed");
		}
		else
		{
			System.out.println("Registration Test failed");
		}
		driver.close();
		}
		
		
		

}
