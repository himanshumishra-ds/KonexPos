package com.konexPos.objectRepositoryLib;

import java.util.List;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Customers_CustomerList {

	@FindBy(xpath="//table[@id='dataTable']/tbody/tr/td[4]") private List<WebElement> mobileNosList; 
	
	public Customers_CustomerList(WebDriver driver) {
		PageFactory.initElements(driver, this);
	
	}
	
	public List<WebElement> getMobileNosList()
	{
		return mobileNosList;
	}
	
	
	
	
}
