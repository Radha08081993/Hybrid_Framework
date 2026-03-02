package com.hybrid.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import com.hybrid.qa.base.TestBase;

public class Contactspage extends TestBase	 {
	
	/*@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement createcontacticon;*/
	
	@FindBy(xpath="//span[text()='Create New Contact']")
	WebElement verifycontactpagetitle;
	
	@FindBy(xpath="//input[@name=\"first_name\"]")
	WebElement firstname;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(xpath="//i[@class=\"save icon\"]")
	WebElement savebtn;
	
	public Contactspage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String verifycontactpage()
	{
		//System.out.println(createcontacticon.getText());
		//createcontacticon.click();
		
		return verifycontactpagetitle.getText();
	}
	
	public void CreateNewContact(String fname,String lname)
	{
		
		 firstname.sendKeys(fname);
		 lastname.sendKeys(lname);
		 savebtn.click();
		
	}
	
}
