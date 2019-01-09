package Utilities;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSelect {
	public static WebDriver driver= null;
	public static void startApplication(String browserName)
	{
		String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();
		System.out.println("Realtive path is : "+relativePath);
		if(browserName.equalsIgnoreCase("firefox"))
		{
	        System.setProperty("webdriver.gecko.driver",relativePath+"\\src\\main\\resources\\BrowserDrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		if(browserName.equalsIgnoreCase("IE"))
		{  
			System.setProperty("webdriver.ie.driver",relativePath+"\\src\\main\\resources\\BrowserDrivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","//usr//local//bin//chromedriver");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		// driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 String getUrl = "http://demo.borland.com/gmopost/";
		//		 ConfigReader.ConfigurationReader(AppURL);
		// System.out.println("Application URL is =>"+getUrl);
		 driver.get(getUrl);
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}
}
