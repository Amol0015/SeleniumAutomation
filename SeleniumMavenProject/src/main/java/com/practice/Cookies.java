package com.practice;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies {
	static WebDriver driver;
	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		 driver.get("https://www.amazon.in/");
		 
		 //capture all cookies
		Set <Cookie>  cookielist= driver.manage().getCookies();

		int no=cookielist.size();
				System.out.println("before:"+no);
				
				for(Cookie ck :cookielist) {
					System.out.println(ck.getName()+ ":" +ck.getValue());
				}
				
				//create cookie
				Cookie customCookie = new Cookie("testcooki", "valuecookies");
				//add cookie vto browser
				driver.manage().addCookie(customCookie);
				
				 //capture all cookies
				Set <Cookie>  cookielist1= driver.manage().getCookies();

				int no1=cookielist1.size();
						System.out.println("after:"+no1);
						
						for(Cookie ck1 :cookielist1) {
							System.out.println(ck1.getName()+ ":" +ck1.getValue());
						}
						//delete cookies
						 driver.manage().deleteAllCookies();
						 
						 //capture all cookies
							Set <Cookie>  cookielist2= driver.manage().getCookies();

							int no2=cookielist2.size();
									System.out.println("before:"+no2);
									
									for(Cookie ck :cookielist2) {
										System.out.println(ck.getName()+ ":" +ck.getValue());
									}
	}

}
