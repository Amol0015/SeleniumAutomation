package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {

	public static void main(String[] args) {

		 WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//Implicit Wait (सर्व एलिमेंट्ससाठी एक कॉमन वेळ)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//NoSuchElementException
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 
		 //२. Explicit Wait (विशिष्ट एलिमेंट आणि अटीसाठी)
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
         // २. अट (Condition) देणे: बटण क्लिक करण्यायोग्य होईपर्यंत थांबा
		WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
        submitBtn.click();

	}

}
