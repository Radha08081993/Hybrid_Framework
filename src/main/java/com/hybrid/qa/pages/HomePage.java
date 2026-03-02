package com.hybrid.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hybrid.qa.base.TestBase;

public class HomePage extends TestBase	
{
	@FindBy(xpath="//span[@class=\"user-display\"]")
	WebElement logo;
	
	@FindBy(xpath="//span[contains(text(),\"Contacts\")]")
	WebElement contacts;
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement createcontacticon;
	
	@FindBy(xpath="//span[contains(text(),\"Deals\")]")
	WebElement Deals;
	
	
	@FindBy(xpath="//span[contains(text(),\"Tasks\")]")
	WebElement tasks;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifypagetitle()
	{
		
		return driver.getTitle();
	}
	
	/*public String verifyuser()
	{
		return logo.getText();
	}*/
	
	//or
	public boolean verifyuser()
	{
		return logo.isDisplayed();
	}
	
	public Contactspage contactlink()
	{
		contacts.click();
		return new Contactspage();
	}
	
	
	
	
	
	public DealsPage Dealslinks()
	{
		Deals.click();
		return new DealsPage();
	}
	
	public TasksPage Tasklink()
	{
		tasks.click();
		return new TasksPage();
	}
	
	public void clickonNewcontactlink()
	{
		Actions act=new Actions(driver);
		act.moveToElement(contacts).build().perform();
		createcontacticon.click();
		
		
	}

}
