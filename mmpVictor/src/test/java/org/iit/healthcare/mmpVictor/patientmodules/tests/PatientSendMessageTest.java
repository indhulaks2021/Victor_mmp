package org.iit.healthcare.mmpVictor.patientmodules.tests;

import org.iit.healthcare.mmpVictor.HelperClass;
import org.iit.healthcare.mmpVictor.TestBaseClass;
import org.iit.healthcare.mmpVictor.patientmodules.pages.PatientMessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientSendMessageTest extends TestBaseClass {
	
	
	@Test
	public void validatePatientMessage() 
	{
		
	HelperClass help = new HelperClass(driver);
	help.launchApplication(pro.getProperty("URL"));
	help.login(pro.getProperty("patientUser"), pro.getProperty("patientPassword"));
	help.navigateToModule("Messages");
	PatientMessagesPage msgPage = new PatientMessagesPage(driver);
	msgPage.fillMessageDetails(pro);
	boolean result = msgPage.validateMessages(pro.getProperty("sendMessagesSuccessfulText"));
	Assert.assertTrue(result);
}
}


