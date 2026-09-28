package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataPicker {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		//DatePicker (कॅलेंडर) हँडल करणे 
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,2500)");
		 
		 // Direct Input
		 WebElement dateBox = driver.findElement(By.id("datepicker"));
		 dateBox.sendKeys("12/25/2026"); // थेट sendKeys() वापरून तारीख टाईप करणे (वेबसाईटच्या फॉरमॅटनुसार, उदा. MM/DD/YYYY)
	//Calendar Widget (लूप वापरून तारीख निवडणे)
		  String expectedYear = "2026";
	        String expectedMonth = "December";
	        String expectedDay = "25";
	        
	        // १. इनपुट बॉक्सवर क्लिक करून कॅलेंडर ओपन करा
	        driver.findElement(By.id("start-date")).click();

	        // २. जोपर्यंत अपेक्षित महिना आणि वर्ष सापडत नाही, तोपर्यंत 'Next' बटणावर क्लिक करत राहणे
	        while (true) {
	            // कॅलेंडरवरील सध्याचा महिना आणि वर्ष वाचणे
	            String currentMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
	            String currentYear = driver.findElement(By.className("ui-datepicker-year")).getText();

	            // जर महिना आणि वर्ष मॅच झाले, तर लूप थांबवा
	            if (currentMonth.equalsIgnoreCase(expectedMonth) && currentYear.equals(expectedYear)) {
	                break;
	            }
	        }
	        
	      //  WebElement dateBox1 = driver.findElement(By.id("start-date")); // योग्य लोकेटर टाका

	        // JavaScript चा ऑब्जेक्ट तयार करा
	      // JavascriptExecutor js1 = (JavascriptExecutor) driver;

	        // HTML5 डेट इनपुट नेहमी "YYYY-MM-DD" हाच फॉरमॅट स्वीकारतात (बॅकग्राउंडमध्ये)
	        // उदा. २५ डिसेंबर २०२६ सेट करायची आहे:
	   //     js1.executeScript("arguments[0].setAttribute('value', '2026-12-25');", dateBox);
	        WebElement fromDateBox = driver.findElement(By.id("start-date"));
	        WebElement toDateBox = driver.findElement(By.id("end-date"));
	        js.executeScript("arguments[0].setAttribute('value', '2026-10-05');", fromDateBox);
	        js.executeScript("arguments[0].setAttribute('value', '2026-10-15');", toDateBox);

	        // बदल पाहण्यासाठी ४ सेकंद थांबूया
	        Thread.sleep(4000); 
	        System.out.println("pass");
	}

}
