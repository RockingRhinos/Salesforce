package com.salesforce.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.salesforce.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class TC005_CreateUsersNegativeFlow extends ProjectSpecificMethods{

	@BeforeTest
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Create a New User Negative Flow";
		author = "Sam";
		category = "Smoke";
	}
	 
	@Test
	public void createUserNegative() throws InterruptedException {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.clickCreateButton()
		.clickUsers()
//		.enterUsername()
		.enterFirstName()
		.enterLastName()
		.enterAlias()
		.enterEmail()
		.enterUsername()
		.enterNickName()
		.selectRole()
		.selectUserLicense()
		.clickSave()
		.verifyErrorMsg();
	}
	
}
