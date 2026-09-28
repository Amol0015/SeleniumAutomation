package com.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	static WebDriver driver;
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,2200)");
		 
		 WebElement el=driver.findElement(By.xpath("//input[@id='comboBox']"));
		 el.click();
		 List <WebElement> li=driver.findElements(By.xpath("//div[@id='dropdown']/div"));
		 System.out.println(li.size());

		 for (WebElement option : li) {
	            String optionText = option.getText();
	            System.out.println("पर्याय: " + optionText);

	            // समजा आपल्याला "Java" या ऑप्शनवर क्लिक करायचे आहे
	            if (optionText.equalsIgnoreCase("Item 37")) {
	                option.click();
	                break; // ऑप्शन सापडून क्लिक झाल्यावर लूप थांबवा
	            }
	}
	}

}
