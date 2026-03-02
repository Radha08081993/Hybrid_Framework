package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hybrid.qa.base.TestBase;
import com.hybrid.qa.pages.Contactspage;
import com.hybrid.qa.pages.HomePage;
import com.hybrid.qa.pages.LoginPage;
import com.hybrid.qa.util.TestUtil;

public class HomePageTest extends TestBase{
LoginPage loginpage;
HomePage homePage;
Contactspage Contactspagetest;
TestUtil testutil;
public HomePageTest()
{
	super();
	
}

//test cases should be independent
//before each test launch browser and login
//Test for test execution
//After each test case close the browser

@BeforeMethod
public void setup()
{
	initialization();
	
	 loginpage=new LoginPage();
	 //Contactspagetest=new Contactspage();
	 
	 homePage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
}


@Test(priority=1)
public void verifyHomePagelogoTest()
{
	String str=homePage.verifypagetitle();
	System.out.println(str);
	Assert.assertEquals(str, "Free CRM","Home page title not matched");
	
}
//@Test(priority=2)
/*public void verifyusernameTest()
{
	String user=homePage.verifyuser();
	Assert.assertEquals(user,"Radha Gade","User does not matched");
	
	
}*/

@Test(priority=2)
public void verifyusernameTest()
{
	Assert.assertTrue(homePage.verifyuser());
	
	
	
}

@Test(priority=3)
public void verifycontactlist()
{
	
	Contactspagetest=homePage.contactlink();
	
	
}



@AfterMethod

public void teardown()
{
	driver.quit();
}
}
