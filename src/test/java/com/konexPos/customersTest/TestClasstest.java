package com.konexPos.customersTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.konex.commonUtils.BaseClass;
import com.konex.commonUtils.ExcelUtility;
import com.konex.commonUtils.FileUtility;
import com.konex.commonUtils.JavaUtils;
import com.konex.commonUtils.WebDriverUtils;
import com.konexPos.objectRepositoryLib.Home;
import com.konexPos.objectRepositoryLib.Login;
import com.konexPos.objectRepositoryLib.MailinatorHomePage;
import com.konexPos.objectRepositoryLib.PosScreen;

public class TestClasstest extends BaseClass {
	
	
	public static WebDriverUtils wUtil = new WebDriverUtils();
    public static FileUtility fUtil = new FileUtility();
    public static JavaUtils jUtil = new JavaUtils();
    public static ExcelUtility eUtil = new ExcelUtility();
	public static void main(String[] args) throws AWTException, IOException, InterruptedException {
		// TODO Auto-generated method stub
	//.getRuntime().exec("taskkill /F /IM chrome.exe");
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
		
		driver = new ChromeDriver(options);
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://172.104.160.243:8080/konexposvendor/login");
		
		System.out.println("=============Login=================");			
		String [] vendorCredentials=fUtil.getUserNamePassword("vendorUserName",  "vendorPassword");
		Login login = new Login(driver)	;
		login.loginToApp(vendorCredentials[0], vendorCredentials[1]);	
		
		Home home = new Home(driver);
		PosScreen pos = new PosScreen(driver);
		
		// Home home= new Home(driver);
		home.getPOSButton().click();
		// PosScreen pos = new PosScreen(driver);
		Thread.sleep(5000);
		pos.getWalkInCustomerEdt().sendKeys("9772205005");
		Thread.sleep(4000);
		String walkinCustomerXpath = "//div[@id='__searchitWrapper1'] //option[contains(text()," + "'" + "9772205005" + "'"
				+ ")]";
		System.out.println(walkinCustomerXpath);
		WebElement walkinCustomer=driver.findElement(By.xpath(walkinCustomerXpath));
		wUtil.waitForElementXpath(driver, walkinCustomer);
		
		ArrayList l = new ArrayList();
		
		walkinCustomer.click();
		System.out.println("clicked on walkin customer ");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//img)[2]")).click();
		Thread.sleep(4000);
//clicking on checkout butto 
		
//		JavascriptExecutor jse=(JavascriptExecutor)driver ;
//		jse.executeScript("window.scrollBy(0,250)");
		int x1=1;
		while(x1<100)
		{
		try
		{
			System.out.println("Trying to click on checkout button");
			
			if(pos.getCheckOutBtn().isEnabled())
			{
				System.out.println("checkout button is enabled now");
				pos.getCheckOutBtn().click();
				System.out.println("clicked on checkout button ");
			}
			
			break;
		}
		catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			System.out.println("intercepted exception occoured , I am handling this ");
			Thread.sleep(100);
			
			x1++;
		}
		}
		
		wUtil.waitForVisibilityOfElement(driver, pos.getCheckoutPaymentPopupBox());
		
		pos.getCheckoutPaymentAmountEdt().sendKeys(pos.getTotalPaybleAmount().getText());
		if(pos.getCheckOutFinalizePaymentBtn().isEnabled() &&  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(pos.getCheckOutFinalizePaymentBtn())).isEnabled())
		{
			System.out.println("finalizing payment button is enabled now  ");
			pos.getCheckOutFinalizePaymentBtn().click();		
		
			System.out.println("finalizing payment button is clicked NOW   ");
			
		}
		
		
		wUtil.waitForVisibilityOfElement(driver, pos.getCheckoutOrderPlacedSuccessfullyPopupBox());
		
		pos.getCheckoutOrderPlacedSuccessfullyPopupBoxOkBtn().click();
		
		System.out.println("order Placed Successfully");
		
	
		   
		
		
		
		
	}

}
