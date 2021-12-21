package org.iit.healthcare.mmpVictor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {

	WebDriver driver;
	public HelperClass(WebDriver driver)
	{
		this.driver = driver;
	}

	public void navigateToModule(String moduleName)
	{
		
		driver.findElement(By.xpath("//span[normalize-space()='"+moduleName+"']")).click();
		
	}
	
	public void launchApplication(String url) 
	{
		driver.get(url);
	}
	
	public void login(String username, String password) 
	{
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		driver.manage().window().maximize();
		
	}
	
	public WebElement visibilityofElementLocated(By locator,int timeinSecs)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeinSecs);
		WebElement e= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return e;
}
}
