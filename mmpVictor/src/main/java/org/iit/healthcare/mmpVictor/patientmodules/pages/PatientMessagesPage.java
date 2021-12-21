package org.iit.healthcare.mmpVictor.patientmodules.pages;

import java.util.HashMap;
import java.util.Properties;

import org.iit.healthcare1.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientMessagesPage {
	WebDriver driver;
	public PatientMessagesPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public HashMap<String, String> fillMessageDetails(Properties pro) {
		
		
		HashMap<String,String> msgData= new HashMap<String,String>();
		String reason = "PAT_REASON_" + Utility.randomString(4);
		msgData.put("reason", reason);
		String subject = "PAT_SUBJECT_" + Utility.randomString(4);
		msgData.put("subject", subject);
		msgData.put("date", Utility.getFutureDate(0, "dd-MM-YYYY"));
		msgData.put("name",pro.getProperty("patientName") );	
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys(reason);
		driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		return msgData;
	}
	public boolean validateMessages(String expMessage)
	{
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		alert.accept();
		return actualMessage.equals(expMessage);

	}
}
