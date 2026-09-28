package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
//create object of webdriver
	
	WebDriver ldriver;
	
	public IndexPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify webelement
	@FindBy(name="username") WebElement username;
	//Identify action on webelement
	public void clickOnSingIn(String Admin) {
		username.sendKeys(Admin);
	}
	
	@FindBy(name="password") WebElement password;
	//Identify action on webelement
	public void clickOnPassword(String pass) {
		password.sendKeys(pass);
	}
	@FindBy(xpath="//button[@type='submit']") WebElement submit;
	//Identify action on webelement
	public void clickOnSubmit() {
		submit.click();
	}
	
}
