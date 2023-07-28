package com.superProject.testCases;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.superProject.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	//public String baseURL="https://demo.guru99.com/v4/index.php";
	//public String username="mngr493310";
	//public String password="hAdehAs";
	
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword();
	public String pagetitle="Guru99 Bank Manager HomePage";
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String br)
	{
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe" );
		logger= Logger.getLogger("superProject");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{	
		System.setProperty("webdriver.chrome.driver",readConfig.getChrompath());
		driver= new ChromeDriver();	
		}
		else if(br.equals("edge"))
		{
		System.setProperty("webdriver.edge.driver",readConfig.getEdgepath());
		driver= new EdgeDriver();	
		}
		//else if(br.equals("ie")) {
		//System.setProperty("webdriver.ie.driver",readConfig.getIEpath());
		//driver= new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		//2) Open the new tab on the browser:
		//driver.switchTo().newWindow(WindowType.TAB);
		//driver.navigate().to("https://www.crmpro.com/");
		
		//3) Open a new window on the browser:
		//driver.switchTo().newWindow(WindowType.WINDOW);
		//driver.navigate().to("https://www.google.com/");
		
	}
		
	    
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();	
	}
	
	
	

}
