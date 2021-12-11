package com.konexPos.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author HIMANSHU MISHRA
 *
 */
public class MailinatorHomePage {

	@FindBy(xpath="//input[@id='addOverlay']") private WebElement inputEmailBoxEdt;
	@FindBy(xpath="//button[@id='go-to-public']") private WebElement goButton;
	@FindBy(xpath="//tr[contains(@id,'testemail')]/td[3]") private WebElement email;
	@FindBy(xpath="//table[@class='table-striped jambo_table']/tbody/tr[contains(@id,'testemail')]/td[3]") private WebElement openEmail;
	
	public WebElement getuNamePnameText() {
		return uNamePnameText;
	}
	@FindBy(xpath = "//b[contains(text(),' Username - ') and contains(text(),'Password')]") private WebElement uNamePnameText; 
	

	

	

	public WebElement getOpenEmail() {
		return openEmail;
	}

	public WebElement getEmail() {
		return email;
	}

	public MailinatorHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);	
	}
	
	public WebElement getinputEmailBoxEdt()
	{
		return inputEmailBoxEdt;
	}
	public WebElement getGoButton() {
		return goButton;
	}
	
	
	
	
}
