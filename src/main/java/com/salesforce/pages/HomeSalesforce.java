package com.salesforce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaft.selenium.api.design.Locators;

public class HomeSalesforce extends SeleniumBase {
	
	public HomeSalesforce() {
		PageFactory.initElements(getDriver(), this);
	}
	
//	click Actions (SVG) Icon
	public HomeSalesforce clickActionsIcon() {
		WebElement svgIcon = locateElement(Locators.XPATH, "//div[@class='slds-global-header__item']//li[4]//a");
		svgIcon.sendKeys(Keys.ENTER);
		return this;
	}
	
//	Click on New Event
	public HomeSalesforce newEvent() throws InterruptedException {
		WebElement newEvent = locateElement(Locators.XPATH, "(//span[text()='New Event'])[1]");
		hoverAndClick(newEvent);
		return this.maximizeIt();
	}
	
//	Click New Task
	public HomeSalesforce newTask() throws InterruptedException {
		WebElement newTask = locateElement(Locators.XPATH, "(//span[text()='New Task'])[1]");
		hoverAndClick(newTask);
		return this.maximizeIt();
	}
	
//	Click New Contact
	public HomeSalesforce newContact() throws InterruptedException {
		WebElement newContact = locateElement(Locators.XPATH, "(//span[text()='New Contact'])[1]");
		hoverAndClick(newContact);
		return this.maximizeIt();
	}
	
//	Click Log Call
	public HomeSalesforce logCall() throws InterruptedException {
		WebElement logCall = locateElement(Locators.XPATH, "(//span[text()='Log a Call'])[1]");
		hoverAndClick(logCall);
		return this.maximizeIt();
	}
	
//	To maximize the prompt
	public HomeSalesforce maximizeIt() throws InterruptedException {
		Thread.sleep(3000);
		WebElement maximizeButton = locateElement(Locators.XPATH, "//button[@title='Maximize']");
		hoverAndClick(maximizeButton);
		return this;
	}
	
	public HomeSalesforce selectSalutation() {
		WebElement salutation = locateElement(Locators.XPATH, "//a[text()='--None--']");
		salutation.click();
		salutation.sendKeys(Keys.DOWN, Keys.ENTER);
		return this;
	}
	
//	To click the save button
	public HomeSalesforce clickSaveButton() {
		click(locateElement(Locators.XPATH, "(//span[text()='Save']/..)[2]"));
		return this;
	}
	
//	To click Create button
	public HomeSalesforce clickCreateButton() {
		click(locateElement(Locators.XPATH, "//span[@class='label']"));
		return this;
	}
	
//	To click Create
	public HomeSalesforce clickCreate() {
		click(locateElement(Locators.CLASS_NAME, "label"));
		return this;
	}
	
//	To click Users
	public UsersPage clickUsers() {
		click(locateElement(Locators.XPATH, "//div[@class='slds-col slds-size_10-of-12']"));
		return new UsersPage();
	}
	
	
	
	
	
	
	
	
	
}
