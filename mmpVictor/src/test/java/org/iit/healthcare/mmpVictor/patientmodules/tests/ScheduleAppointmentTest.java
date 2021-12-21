package org.iit.healthcare.mmpVictor.patientmodules.tests;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.iit.healthcare.mmpVictor.HelperClass;
import org.iit.healthcare.mmpVictor.TestBaseClass;
import org.iit.healthcare.mmpVictor.patientmodules.pages.PatientHomePage;
import org.iit.healthcare.mmpVictor.patientmodules.pages.ScheduleAppointmentPage;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ScheduleAppointmentTest extends TestBaseClass {
	
	@Test
	public void validateScheduleAppointment() 
	{
		
		
	HelperClass help = new HelperClass(driver);
	help.launchApplication(pro.getProperty("URL"));
	help.login(pro.getProperty("patientUser"), pro.getProperty("patientPassword"));
	help.navigateToModule("ScheduleAppointments");
	ScheduleAppointmentPage spage = new ScheduleAppointmentPage(driver);
	HashMap<String, String> expectedHmap = spage.bookAnAppointment(pro.getProperty("doctorName"));
	PatientHomePage homePage = new PatientHomePage(driver);
	HashMap<String, String> actualHmap = homePage.fetchPatientDetails();
	AssertJUnit.assertEquals(actualHmap, expectedHmap);
	
	}
	
	

}
