package com.salesforce.pages;

import org.openqa.selenium.WebElement;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaft.selenium.api.design.Locators;

public class UsersPage extends SeleniumBase {

	public UsersPage enterFirstName() {
		clearAndType(locateElement(Locators.ID, "name_firstName"), "Sam");
		return this;
	}
	
	public UsersPage enterLastName() {
		clearAndType(locateElement(Locators.ID, "name_lastName"), "Lazarus");
		return this;
	}
	
	public UsersPage enterAlias() {
		clearAndType(locateElement(Locators.ID, "Alias"), "Sam");
		return this;
	}
	
	public UsersPage enterEmail() {
		clearAndType(locateElement(Locators.ID, "Email"), "sam.david@testleaf.com");
		return this;
	}
	
	public UsersPage enterUsername() {
		clearAndType(locateElement(Locators.ID, "Username"), "samdavid_92");
		return this;
	}
	
	public UsersPage enterNickName() {
		clearAndType(locateElement(Locators.ID, "CommunityNickname"), "rockingRhino");
		return this;
	}
	
	public UsersPage selectRole() {
		selectDropDownUsingText(locateElement(Locators.ID, "role"), "CEO");
		return this;
	}
	
	public UsersPage selectUserLicense() {
		selectDropDownUsingIndex(locateElement(Locators.ID, "user_license_id"), 1);
		return this;
	}
	
	public UsersPage clickSave() {
		click(locateElement(Locators.XPATH, "(//input[@name='save'])[2]"));
		return this;
	}
	
	public void verifyErrorMsg() {
		WebElement errorMsg = locateElement(Locators.ID, "errorDiv_ep");
		boolean isErrorMsgAppeared = verifyPartialText(errorMsg, "Error: Invalid Data");
		if (isErrorMsgAppeared) {
			System.out.println("Create User Negative Flow Passed");
		} else {
			System.out.println("Create User Negative Flow Failed");
		}
		
	}
	
	
	
	
	
	
	
}
