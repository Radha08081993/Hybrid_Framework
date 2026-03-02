package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hybrid.qa.base.TestBase;
import com.hybrid.qa.pages.HomePage;
import com.hybrid.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();   //This constructor will call TestBase(parent) class constrcutor
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		 loginpage=new LoginPage();
		
	}
	
	/*@Test(priority=1)
	public void loginPageTitle()
	{
		loginpage.Validatelogintitle();
		//Assert.assertEquals(title, "");
		
	}*/
	
	@Test(priority=1)	
	public void loginfun()
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teaDown()
	{
		driver.quit();
	}
	
	

}
