package org.iit.healthcare.mmpVictor.patientmodules.pages;

import java.util.HashMap;

import org.iit.healthcare.mmpVictor.HelperClass;
import org.iit.healthcare1.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {
	
	WebDriver driver;
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public  HashMap<String,String> bookAnAppointment(String doctorname)
	{
		HashMap<String,String> expectedMap = new HashMap<String,String>();	
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
	
		expectedMap.put("doctor", doctorname);
		driver.findElement(By.xpath("//h4[normalize-space()='Dr."+doctorname+"']/ancestor::ul/following-sibling::button")).click();	
		driver.switchTo().frame("myframe");
		

		//Generate the Future Date
		String futureDate = Utility.selectFutureDate(10);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String appointmentMonth = futureDate.split("/")[0];
		String appointmentDate = futureDate.split("/")[1];
		String appointmentYear = futureDate.split("/")[2];
		

		HelperClass helper = new HelperClass(driver);
		helper.visibilityofElementLocated(By.xpath("//span[@class='ui-datepicker-month']"),30);
		
		String displayedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		String displayedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();	
		while(!appointmentYear.equals(displayedYear)) 
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			displayedYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		}
		while(!appointmentMonth.equals(displayedMonth))
		{
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			displayedMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		}
		driver.findElement(By.linkText(appointmentDate)).click();
		expectedMap.put("date", driver.findElement(By.xpath("//input[@id='datepicker']")).getAttribute("value"));
		
		Select timeSelect = new Select(driver.findElement(By.xpath("//select[@id='time']")));
		timeSelect.selectByValue("11Am");
		expectedMap.put("time", "11Am");
		
		driver.findElement(By.id("ChangeHeatName")).click();


		//Random Text
		driver.findElement(By.cssSelector("#sym")).sendKeys("Fever123");
		expectedMap.put("sym", "Fever123");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		return expectedMap;
		
	}


}
