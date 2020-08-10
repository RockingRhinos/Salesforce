package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class TC001_Login extends ProjectSpecificMethods{

	@BeforeTest
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Verify Login Button Navigation";
		author = "Sam";
		category = "Smoke";
	}
	 
	@Test
	public void salesforceDev() throws InterruptedException {
//		new SalesforceDeveloperPage()
//		.clickLoginButton()
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin();
	}
	
}
