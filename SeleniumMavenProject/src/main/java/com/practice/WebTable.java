package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	static WebDriver driver;
	public static void main(String[] args) {
	
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 
		 List<WebElement> staticTable=driver.findElements(By.xpath("//table[@name='BookTable']//tr/th | //table[@name='BookTable']//tr/td"));
		
		 System.out.println( staticTable.size());
		 for(WebElement cell : staticTable) {
	            System.out.print(cell.getText());
	            System.out.println(cell.getSize());
	        }
	}

}
