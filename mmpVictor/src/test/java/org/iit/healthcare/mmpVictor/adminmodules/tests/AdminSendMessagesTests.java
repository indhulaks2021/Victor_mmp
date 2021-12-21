package org.iit.healthcare.mmpVictor.adminmodules.tests;

import java.util.HashMap;

import org.iit.healthcare.mmpVictor.HelperClass;
import org.iit.healthcare.mmpVictor.TestBaseClass;
import org.iit.healthcare.mmpVictor.adminmodule.pages.AdminMessagesPage;
import org.iit.healthcare.mmpVictor.patientmodules.pages.PatientMessagesPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminSendMessagesTests extends TestBaseClass {
	

	@Test
	public void validatePatientMessage() 
	{
		
	HelperClass help = new HelperClass(driver);
	help.launchApplication(pro.getProperty("URL"));
	help.login(pro.getProperty("patientUser"), pro.getProperty("patientPassword"));
	help.navigateToModule("Messages");
	PatientMessagesPage msgPage = new PatientMessagesPage(driver);
	HashMap<String, String> expectedHMap = msgPage.fillMessageDetails(pro);
	boolean result = msgPage.validateMessages(pro.getProperty("sendMessagesSuccessfulText"));
	SoftAssert sa = new SoftAssert();
	sa.assertTrue(result);
		
		
	help.launchApplication(pro.getProperty("urlAdmin"));
	help.login(pro.getProperty("adminUser"), pro.getProperty("adminPassword"));
	help.navigateToModule("Messages");
	AdminMessagesPage adminMsgPage = new AdminMessagesPage(driver);
	HashMap<String,String> actualHMap = adminMsgPage.fetchLatestMessage();
	sa.assertEquals(expectedHMap, actualHMap);
}

}
