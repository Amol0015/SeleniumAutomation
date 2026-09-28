package com.mystore.testcases;

import org.testng.annotations.Test;

import com.mystore.pageobject.IndexPage;

public class LoginTC extends BaseClass {

	@Test()
	public void verifyLogin() {
		//open url 
		driver.get(url);
	
		logger.info("url open");
	
		IndexPage pg= new IndexPage(driver);
		
		pg.clickOnSingIn("Admin");
		pg.clickOnPassword("admin123");
		pg.clickOnSubmit();
		}
}
