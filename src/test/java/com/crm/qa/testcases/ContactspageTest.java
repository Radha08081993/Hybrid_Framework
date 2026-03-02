package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybrid.qa.base.TestBase;
import com.hybrid.qa.pages.Contactspage;
import com.hybrid.qa.pages.HomePage;
import com.hybrid.qa.pages.LoginPage;
import com.hybrid.qa.util.TestUtil;

public class ContactspageTest extends TestBase 
{
	LoginPage loginpage;
	HomePage homePage;
	Contactspage contactpage;
	TestUtil testUtil;
	String sheetName="contacts";
	public ContactspageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		
		initialization();
		loginpage=new LoginPage();
		homePage=new HomePage();
		contactpage=new Contactspage();
		testUtil=new TestUtil();
		homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage=homePage.contactlink();
		
	}
	
	
	
	
	@Test(priority=1)
	public void verifycontactpageTest()
	{
		
		homePage.clickonNewcontactlink();
		String str =contactpage.verifycontactpage();
		System.out.println("Contact page title"+str);
		Assert.assertEquals(str, "Create New Contact");
		System.out.println("Contacts page open");
		
		
		
	}
	
	
	@DataProvider
	public Object[][] gettestdata()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2,dataProvider="gettestdata")
	public void validateCreateNewContact(String firstname,String lastname)
	{
		homePage.clickonNewcontactlink();
		
		contactpage.CreateNewContact(firstname, lastname);
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}

