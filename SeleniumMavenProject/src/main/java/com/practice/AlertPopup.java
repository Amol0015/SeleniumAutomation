package com.practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopup {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, AWTException
{
		
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
	WebElement simpleAlert=	 driver.findElement(By.xpath("//button[@id='alertBtn']"));
	simpleAlert.click();
	Thread.sleep(2000);
	//हा ब्राउझरचा JavaScript Alert (पॉप-अप) आहे
	 Alert myAlert = driver.switchTo().alert();
     // ३. अलर्टवरील टेक्स्ट वाचून प्रिंट करा ("I am an alert box!")
     System.out.println("Alert text is: " + myAlert.getText());
     // ४. 'OK' बटणावर क्लिक करा (Accept करा)
     myAlert.accept();
 	Thread.sleep(2000);
 	  // १. "Confirmation Alert" बटणावर क्लिक करा
     WebElement ConfirmationAlert=	 driver.findElement(By.xpath("//button[@id='confirmBtn']"));
     ConfirmationAlert.click();

    
     
     // २. ड्रायव्हरला अलर्टवर स्विच करा
     Alert alertOk = driver.switchTo().alert();
     
     // ३. अलर्टवरील मेसेज प्रिंट करा
     System.out.println("Alert Message: " + alertOk.getText());
     
     // ४. 'OK' बटणावर क्लिक करा
    // alertOk.accept(); 
     alertOk.dismiss();
     Thread.sleep(2000);
     // १. "Prompt Alert" बटणावर क्लिक करा
     WebElement PromptAlert=	 driver.findElement(By.xpath("//button[@id='promptBtn']"));
     PromptAlert.click();
     
     // २. अलर्टवर स्विच करा
     Alert promptAlert = driver.switchTo().alert();
     // ३. Robot Class चा ऑब्जेक्ट तयार करा (कीबोर्ड ॲक्शन्ससाठी)
     Robot robot = new Robot();
     
     // ४. जुने टेक्स्ट पूर्ण सिलेक्ट करण्यासाठी 'Ctrl + A' दाबा
     robot.keyPress(KeyEvent.VK_CONTROL);
     robot.keyPress(KeyEvent.VK_A);
     robot.keyRelease(KeyEvent.VK_A);
     robot.keyRelease(KeyEvent.VK_CONTROL);
  // ५. सिलेक्ट केलेले टेक्स्ट डिलीट करण्यासाठी 'Backspace' दाबा
     robot.keyPress(KeyEvent.VK_BACK_SPACE);
     robot.keyRelease(KeyEvent.VK_BACK_SPACE);
     Thread.sleep(5000);
     // ३. अलर्टमध्ये टेक्स्ट (नाव) टाईप करा
     promptAlert.sendKeys("Satish");
     Thread.sleep(5000);
     // ४. 'OK' बटणावर क्लिक करा
     promptAlert.accept();
	//driver.close();
		 
		}
}
