package org.iit.healthcare.mmpVictor.adminmodules.tests;

import org.iit.healthcare.mmpVictor.HelperClass;
import org.iit.healthcare.mmpVictor.TestBaseClass;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends TestBaseClass {
	

	@Test
	public void validateScheduleAppointment() 
	{
		
		
	HelperClass help = new HelperClass(driver);
	help.launchApplication(pro.getProperty("urlAdmin"));
	help.login(pro.getProperty("adminUser"), pro.getProperty("adminPassword"));
	help.navigateToModule("Schedule Appointment");
	
}

}
