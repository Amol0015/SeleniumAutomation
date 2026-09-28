package com.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.get("https://demoqa.com/broken");
		 driver.manage().window().maximize();
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//NoSuchElementException
		 
		// WebElement el=driver.findElement(By.xpath("//a[text()='Click Here for Broken Link']"));
		 // २. पेजवरील सर्व लिंक्स गोळा करणे (ज्यांचा HTML टॅग 'a' असतो)
	        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	        System.out.println("पेजवरील एकूण लिंक्सची संख्या: " + allLinks.size());
	        
	        int brokenLinksCount = 0;
	        // ३. लूप फिरवून प्रत्येक लिंक तपासणे
	        for (WebElement linkElement : allLinks) {
	            
	            // लिंकचा प्रत्यक्ष पत्ता (URL) href ॲट्रिब्युटमधून काढणे
	            String url = linkElement.getAttribute("href");

	            // जर लिंक रिकामी असेल किंवा त्यात काही नसेल तर ती सोडून देणे
	            if (url == null || url.isEmpty()) {
	                System.out.println("URL रिकामी आहे, स्किप करत आहे.");
	                continue;
	            }

	            try {
	                // ४. Java च्या URL क्लासचा ऑब्जेक्ट तयार करणे
	                URL link = new URL(url);

	                // ५. HttpURLConnection च्या मदतीने कनेक्शन तयार करणे आणि रिक्वेस्ट पाठवणे
	                HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
	                httpConn.setConnectTimeout(3000); // जास्तीत जास्त ३ सेकंद वाट पाहणार
	                httpConn.connect(); // कनेक्शन जोडणे
	                // ६. सर्व्हरकडून आलेला रिस्पॉन्स कोड (Response Code) मिळवणे
	                int responseCode = httpConn.getResponseCode();

	                // जर रिस्पॉन्स कोड ४०० किंवा त्यापेक्षा जास्त असेल, तर ती ब्रोकन लिंक आहे
	                if (responseCode >= 400) {
	                    System.out.println("❌ BROKEN LINK: " + url + " ---> Response Code: " + responseCode);
	                    brokenLinksCount++;
	                } else {
	                    System.out.println("✅ VALID LINK: " + url + " ---> Response Code: " + responseCode);
	                }

	                httpConn.disconnect(); // कनेक्शन बंद करणे

	            } catch (IOException e) {
	                System.out.println("या URL ला कनेक्ट करताना एरर आली: " + url + " -> " + e.getMessage());
	            }
	        }

	        System.out.println("\n--- चाचणी समाप्त ---");
	        System.out.println("एकूण सापडलेल्या ब्रोकन लिंक्स: " + brokenLinksCount);
	        
	        driver.quit();

		 
	}

}
