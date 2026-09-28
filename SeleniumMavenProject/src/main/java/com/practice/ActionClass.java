package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClass {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,2500)");
		 
		 Actions act = new Actions(driver); 
		 WebElement mainMenu = driver.findElement(By.xpath("//button[text()='Point Me']"));

		// १. Mouse Hover
		act.moveToElement(mainMenu).perform(); 
		//Double Click 
		WebElement doubleClickBtn = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Thread.sleep(4000);
		act.doubleClick(doubleClickBtn).perform();
		//
		WebElement sourceElement = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));

		// २. जिथे सोडायचे आहे तो एलिमेंट (Target)
		WebElement targetElement = driver.findElement(By.id("droppable"));

		// ३. ड्रॅग आणि ड्रॉप करणे
		act.dragAndDrop(sourceElement, targetElement).perform();
		
		System.out.println("Pass");

	}

}
