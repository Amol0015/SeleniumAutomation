package com.practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 
		 //capture fullscreenshot
		 //step1: covert webdriver object to takescreenshot interface
		 TakesScreenshot screenshot=((TakesScreenshot)driver);
		 //step2: call getScreenshotAs to create image file
		File source= screenshot.getScreenshotAs(OutputType.FILE);
		 
		 File dest =new File("C:\\Amol\\Total Project\\SeleniumWorkspace\\NewMavenProject\\SeleniumMavenProject\\Screenshots\\fullpage.png");
		 FileUtils.copyFile(source, dest);
		 
		 
		 
		 //capture section of webpage  and webelement logic is same
		 WebElement ele=driver.findElement(By.xpath("//a[text()='Data Entry Form']"));
		 File source1= ele.getScreenshotAs(OutputType.FILE);
		 File dest1 =new File("C:\\Amol\\Total Project\\SeleniumWorkspace\\NewMavenProject\\SeleniumMavenProject\\Screenshots\\section.png");
		 FileUtils.copyFile(source1, dest1);
	}

}
