package com.konexPos.objectRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	@FindBy(xpath="//input[@id='user_name']") 
	private WebElement userName;
	
	@FindBy(id="password") 
	private WebElement password ;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginButton;
	
	
	
	
	
	
	
  public Login(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
  
  public WebElement getUserNameEdt()
  {
	return userName;	 	 
  }
  
  public WebElement getPasswordEdt()
  {
	  return password;
  }
  
  public WebElement loginButton()
  {
	  return loginButton;
  }
  
  public void loginToApp(String username , String password)
  {
	  getUserNameEdt().sendKeys(username);
	  getPasswordEdt().sendKeys(password);
	  loginButton().click();
	  
  }
	
	
}
