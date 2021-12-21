package org.iit.healthcare.mmpVictor;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	protected WebDriver driver;
	protected Properties pro;

	@BeforeClass
	public void instantiateDriver() throws Exception
	{
		System.out.println("First line of the instantiate method");
		pro = loadProperties();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public Properties loadProperties() throws Exception
	{	
		Properties pro = new Properties();
		String filePath = System.getProperty("user.dir")+"/config/mmp.properties";
		System.out.println("Printing the file path from loadProperties method "+filePath);
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		pro.load(fis);
		return pro;
	}
	
	
}
