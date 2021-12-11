package com.konexPos.objectRepositoryLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Customers_AddCustomer {

	@FindBy(id="custName") private WebElement customerNameEdt;
	@FindBy(id="mobNo") private WebElement mobileNoEdt;
	@FindBy(id="email") private WebElement emailEdt;
	@FindBy(id="change") private WebElement addButton;
	@FindBy(xpath="//span[@class='requiredFeild validation-message']/ancestor::label[contains(text(),'Mobile')]") private WebElement mobileText;
	@FindBy(xpath="//div[text()='Customer Added Successfully!']")	private WebElement customerAddedSuccessfullyText;
	@FindBy(xpath="//div[@class='swal-button-container']/button[text()='OK']")
	private WebElement customerAddedSuccessfullyOkBtn;
	
	public Customers_AddCustomer(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public WebElement getCustomerAddedSuccessfullyText() {
		return customerAddedSuccessfullyText;
	}
	
	public WebElement getCustomerAddedSuccessfullyOkBtn() {
		return customerAddedSuccessfullyOkBtn;
	}

	public WebElement getMobileText()
	{
	
	
		return mobileText;
	}
	
	public WebElement getCustomerName()
	{
		return customerNameEdt;
	}
	
	public WebElement getMobileNoEdt()
	{
		return mobileNoEdt;
	}
	
	public WebElement getEmailEdt()
	{
		return emailEdt;
		
	}
	
	public WebElement getAddButton()
	{
		return addButton;
	}
	
}
