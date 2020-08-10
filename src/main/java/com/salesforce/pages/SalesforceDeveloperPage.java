package com.salesforce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class SalesforceDeveloperPage extends SeleniumBase{

	public SalesforceDeveloperPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(how = How.LINK_TEXT, using = "Log In") private WebElement loginLink;
	public LoginPage clickLoginButton() {
		click(loginLink);
		verifyTitle("Login | Salesforce");
		return new LoginPage();
	}
	
}
