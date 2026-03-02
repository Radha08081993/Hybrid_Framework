package com.hybrid.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.qa.base.TestBase;

public class LoginPage extends TestBase	
{

	//Page Factory or Object Repository
	
	@FindBy(name="email")
	WebElement username;
	
	//Password
	@FindBy(name="password")
	WebElement pass;
	
	
	//LoginButton
	@FindBy(xpath="//div[contains(text(),\"Login\")]")
	WebElement loginBtn;
	
	//Signup
	
	@FindBy(xpath="//a[contains(text(),\"Sign Up\")]")
	WebElement SignupBtn;
	
	
	
public LoginPage()
{
	PageFactory.initElements(driver, this); //this means pointing to current class object
}

public String Validatelogintitle()
{
	return driver.getTitle();   // return string //isDisplayed method return true or false
}


public HomePage login(String user,String password)
{
	username.sendKeys(user);
	pass.sendKeys(password);
	loginBtn.click();
	
	return new HomePage();
}
	
}
