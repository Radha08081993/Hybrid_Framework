package com.hybrid.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hybrid.qa.util.TestUtil;

public class TestBase 
{

	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream up=new FileInputStream("C:\\Users\\Radha.Gade\\eclipse-workspace\\HybriFramwork\\src\\main\\java\\com\\hybrid\\crm\\"
					+"config\\config.properties");
			prop.load(up);
			
					
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

public static void initialization()
{
	String browserName=prop.getProperty("browser"); //browser taking from base class
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Radha.Gade\\eclipse-workspace\\HybriFramwork\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "D:\\POM_Practice\\geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEPUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
}
}

