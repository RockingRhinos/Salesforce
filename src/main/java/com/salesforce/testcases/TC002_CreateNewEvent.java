package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class TC002_CreateNewEvent extends ProjectSpecificMethods{
	
	@BeforeTest
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Create a New Event";
		author = "Sam";
		category = "Smoke";
	}
	 
	@Test
	public void salesforceDev() throws InterruptedException {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickActionsIcon()
		.newEvent()
		.maximizeIt()
		.clickSaveButton();
	}

}
