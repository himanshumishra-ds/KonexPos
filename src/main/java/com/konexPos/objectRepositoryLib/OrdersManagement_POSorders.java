package com.konexPos.objectRepositoryLib;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersManagement_POSorders {

		
	public OrdersManagement_POSorders(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
	
  public List<WebElement> getCustomerNameList() {
		return customerNameList;
	}



@FindBy(xpath="//table[@id='dataTable']/tbody/tr/td[last()-1]") private List<WebElement> customerNameList; 
  
  
	
	
	
	
	
	
}
