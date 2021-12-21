package org.iit.healthcare.mmpVictor.adminmodule.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminMessagesPage {
	WebDriver driver;
	public AdminMessagesPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public HashMap<String, String> fetchLatestMessage()
	{
		HashMap<String, String> msgData = new HashMap<String,String>();
		
		msgData.put("name", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[1]")).getText());
		msgData.put("subject", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[2]")).getText());	
		msgData.put("reason", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]/td[2]")).getText());
		msgData.put("date", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]")).getText());
		return msgData;
	
	}


}
