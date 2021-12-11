package com.konexPos.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	public Home (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@class='img-profile rounded-circle']") private WebElement profileImage;
	@FindBy(xpath="(//i[contains(@class,'sign-out')])[2]") private WebElement logOut;
	@FindBy(xpath="//a[text()='Logout']") private WebElement verifyLogoutButton;
	@FindBy(xpath="//span[text()='Customers Management']") private WebElement customersModule;
	@FindBy(xpath="//a[text()='AddCustomer']") private WebElement addCustomer;
	@FindBy(xpath="//button[@id='sidebarToggleTop']/following-sibling:: ul/li/form/div/a")private WebElement POSButton;
	@FindBy(xpath = "//a //span[text()='Orders Management']") private WebElement orderManagementModule;
	@FindBy(xpath = "//a[text()='POS Orders']") private WebElement POS_Orders;
	
	

	public WebElement getOrderManagementModule() {
		return orderManagementModule;
	}

	public WebElement getPOS_Orders() {
		return POS_Orders;
	}

	
	//=======================================
	
	
	public WebElement getPOSButton() {
		return POSButton;
	}
	
	public WebElement getAddCustomer()
	{
		
		return addCustomer;
	}
	
	
	
	public WebElement getCustomersModule()
	{
		return customersModule;
	}
	
	public WebElement getProfileImage()
	{
		return profileImage;
	}
	
	public WebElement getLogOutButton()
	{
		return logOut;
	}
	public WebElement getVerifyLogOutButton()
	{
		return verifyLogoutButton;
	}
	
	
	
	

}
