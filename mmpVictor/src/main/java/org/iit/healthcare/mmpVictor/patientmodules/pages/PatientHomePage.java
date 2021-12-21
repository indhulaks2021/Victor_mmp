package org.iit.healthcare.mmpVictor.patientmodules.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientHomePage {
	
	WebDriver driver;
	public PatientHomePage(WebDriver driver)
	{
		this.driver = driver;
	}

	
	//Validation- Read the values from Patient Portal WebTable
	
	public HashMap<String, String> fetchPatientDetails()
	{
		HashMap<String,String> actualMap = new HashMap<String,String>();
		List<WebElement> tdList = driver.findElements(By.xpath("//table[@class='table']/tbody/tr[1]/td"));
		actualMap.put("date",tdList.get(0).getText() );
		actualMap.put("time", tdList.get(1).getText());
		actualMap.put("sym", tdList.get(2).getText());
		actualMap.put("doctor",tdList.get(3).getText());
		return actualMap;
	
	}

}
