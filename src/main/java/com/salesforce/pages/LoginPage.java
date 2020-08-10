package com.salesforce.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class LoginPage extends SeleniumBase{

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(how = How.ID, using="username") WebElement eleUsername;
	public LoginPage enterUsername() {
		clearAndType(eleUsername, "samdavid@testleaf.com");
		return this;
	}
	
	@FindBy(how = How.ID, using="password") WebElement elePassword;
	public LoginPage enterPassword() {
		clearAndType(elePassword, "samchennai92");
		return this;
	}
	
	@FindBy(how = How.CSS, using="input#Login") WebElement eleLoginButton;
	public HomeSalesforce clickLogin() throws InterruptedException {
		click(eleLoginButton);
		Thread.sleep(5000);
		return new HomeSalesforce();
	}
	
/*	@FindBy(how = How.CSS, using="input#Login") WebElement eleLoginButton;
	public Custom clickLogin() throws InterruptedException {
		click(eleLoginButton);
		Thread.sleep(5000);
		return new Custom();
	}	*/
	
}
