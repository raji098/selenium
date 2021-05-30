package selenium;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTestinf {

	public static void main(String[] args) throws Exception
	{
		//Declare Global objects
		RemoteWebDriver driver = null;
		
		//Take Input from Keyboard
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Browser Name");
		String bn=s.nextLine();
		s.close();
		
		//Similar for all Browsers
		System.setProperty("webdriver.chrome.driver","F:\\raji\\selenium");
		//System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		

      //Bonigarcia dependency code to get compatible browser driver s/w automatically wrt browse
		
		
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.silentOutput","true");
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
          //maximize
		  driver.manage().window().maximize();
		  //Launch  site
		  driver.get("http://www.google.co.in");
		  Thread.sleep(5000);
		  //close site
		  driver.close();
	}

}
