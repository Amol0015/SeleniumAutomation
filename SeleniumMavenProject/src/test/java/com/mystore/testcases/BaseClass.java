package com.mystore.testcases;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.mystore.pageobject.IndexPage;
import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readCon =new ReadConfig();
	
	String url=readCon.getBaseUrl();
	String browser=readCon.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() {
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;
			
			default:
				driver=null;
				break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//for logger
		logger = LogManager.getLogger("SeleniumMavenProject");
	}
	@BeforeMethod
	public void login() {
		driver.get(url);
		
		logger.info("url open");
	
		IndexPage pg= new IndexPage(driver);
		
		pg.clickOnSingIn("Admin");
		pg.clickOnPassword("admin123");
		pg.clickOnSubmit();
	}
	
	//@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
