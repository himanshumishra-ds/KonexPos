package com.konexPos.customersTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.konex.commonUtils.BaseClass;
import com.konex.commonUtils.IConstant;
import com.konexPos.objectRepositoryLib.Home;
import com.konexPos.objectRepositoryLib.OrdersManagement_POSorders;
import com.konexPos.objectRepositoryLib.PosScreen;

public class OrderPlaceAtPosScreentest extends BaseClass {

	String sweetName = "Rasmalai" + jUtil.getRandomIntegerValue();
	String mobileNo = String.valueOf(jUtil.getNewMobileNo());
	String newCustomerName = jUtil.getNewName();
	
	@Test(groups= {"SmokeTest"})  
	public void addCustomer() throws InterruptedException, AWTException {

		Home home = new Home(driver);
		PosScreen pos = new PosScreen(driver);
		
		// Home home= new Home(driver);
		home.getPOSButton().click();
		// PosScreen pos = new PosScreen(driver);
		Thread.sleep(5000);
		pos.getAddCustomerButton().click();
		wUtil.waitForVisibilityOfElement(driver, pos.getAddNewCustomerModelBox());
		// System.out.println(pos.getAddNewCustomerModelBox().getText());
		Assert.assertTrue(pos.getAddNewCustomerModelBox().getText().equals("Add a new customer"),
				"Model Box Text does not match");
		pos.getMobileNoEdt().sendKeys(mobileNo);
		pos.getCustomerNameEdt().sendKeys(newCustomerName);
		pos.getEmailboxEdt().sendKeys(newCustomerName);
		pos.getAddCustomerSaveBtn().click();
		wUtil.waitForVisibilityOfElement(driver, pos.getCustomerAddedSuccessfullyText());
		pos.getCustomerAddedSuccessfullyOkBtn().click();

		// ================
//addding product 
		pos.getAddProductBtn().click();
		pos.getProductNameEdt().sendKeys(sweetName);

		pos.getCategoryDropDown().click();
		wUtil.selectByVisibleTextDropDown(pos.getCategoryDropDown(), "* Desert Items");

		pos.getProductTypeDropDown().click();
		wUtil.selectByVisibleTextDropDown(pos.getProductTypeDropDown(), "Veg");

		pos.getPriceEdt().sendKeys("100");
		pos.getProductDescriptionEdt().sendKeys(" Product Test Description ");

		pos.getVatEdt().sendKeys("10");
		pos.getSelectTaxDropdown().click();
		wUtil.selectByVisibleTextDropDown(pos.getSelectTaxDropdown(), "Test Tax-10%");

		pos.getFinalPriceEdt().click();
		pos.getStockEdt().sendKeys("10000");

		// uploading the image

		String workingDirectory = System.getProperty("user.dir");
		String imageFilePath = workingDirectory + IConstant.testImageFilePath;
		pos.getUploadImageFileBtn().click();
		StringSelection ss = new StringSelection(imageFilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(50);
		robot.keyRelease(KeyEvent.VK_ENTER);

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.)
//		wUtil.waitForElementXpath(driver, pos.getAddProductSaveBtn());
//		wUtil.waitForVisibilityOfElement(driver, pos.getAddProductSaveBtn());
		Thread.sleep(2000);
//		JavascriptExecutor jse =(JavascriptExecutor)driver ;
//		jse.executeScript("window.scrollBy(0,50)");
		int count = 40;
		int x = 0;
		while (x < count) {
			try {
				pos.getAddProductSaveBtn().click();
				//System.out.println("I have clicked on save button ");
				int y = 0;
				while (y < 40) {
					try {
						wUtil.waitForVisibilityOfElement(driver,
								driver.findElement(By.xpath("//div[text()='Product saved successfully']")));
						driver.findElement(By.xpath("//button[text()='OK']")).click();
						//System.out.println("Successfully clicked on OK Button POPUP");
						break;
					} catch (Exception e) {
						y++;
						Thread.sleep(100);

					}
				}

				break;

			} catch (ElementClickInterceptedException e) {
				x++;
				Thread.sleep(100);
			}

		}
		String productXpath = "//div[@class='products_listing'] //*[@class='product_list'] //p[text()=" + "'"
				+ sweetName + "'" + "]";

		Assert.assertEquals(wUtil.waitForElementXpath(driver, productXpath), true);
		driver.findElement(By.xpath(productXpath)).click();
		wUtil.waitForVisibilityOfElement(driver, pos.getIncreaseProductCount());
		pos.getIncreaseProductCount().click();
		// Selecting Customer

		// S
		
		// filling customer details in walking Customer

		
				
				pos.getWalkInCustomerEdt().sendKeys(mobileNo);
				Thread.sleep(4000);
				String walkinCustomerXpath = "//div[@id='__searchitWrapper1'] //option[contains(text()," + "'" + mobileNo + "'"
						+ ")]";
				//System.out.println(walkinCustomerXpath);
				WebElement walkinCustomer=driver.findElement(By.xpath(walkinCustomerXpath));
				wUtil.waitForElementXpath(driver, walkinCustomer);
			
			
				walkinCustomer.click();
				Thread.sleep(4000);

		// filling discount
		pos.getEditDiscountModalBtn().click();
		wUtil.waitForVisibilityOfElement(driver, pos.getDiscountTypeDropDown());
		wUtil.selectByVisibleTextDropDown(pos.getDiscountTypeDropDown(), "Percentage");
		pos.getDiscountPercentageEdt().sendKeys("10");
		pos.getDiscountUpdateBtn().click();

		
		//clicking on checkout butto 
		
//		JavascriptExecutor jse=(JavascriptExecutor)driver ;
//		jse.executeScript("window.scrollBy(0,250)");
		int x1=1;
		while(x1<100)
		{
		try
		{
			//System.out.println("Trying to click on checkout button");
			
			if(pos.getCheckOutBtn().isEnabled())
			{
				//System.out.println("checkout button is enabled now");
				pos.getCheckOutBtn().click();
				//System.out.println("clicked on checkout button ");
			}
			
			break;
		}
		catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			//System.out.println("intercepted exception occoured , I am handling this ");
			Thread.sleep(100);
			
			x1++;
		}
		}
		
		wUtil.waitForVisibilityOfElement(driver, pos.getCheckoutPaymentPopupBox());
		
		pos.getCheckoutPaymentAmountEdt().sendKeys(pos.getTotalPaybleAmount().getText());
		if(pos.getCheckOutFinalizePaymentBtn().isEnabled() &&  new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(pos.getCheckOutFinalizePaymentBtn())).isEnabled())
		{
			//System.out.println("finalizing payment button is enabled now  ");
			pos.getCheckOutFinalizePaymentBtn().click();		
		
			//System.out.println("finalizing payment button is clicked NOW   ");
			
		}
		
		
		wUtil.waitForVisibilityOfElement(driver, pos.getCheckoutOrderPlacedSuccessfullyPopupBox());
		
		pos.getCheckoutOrderPlacedSuccessfullyPopupBoxOkBtn().click();
		
		//System.out.println("order Placed Successfully");
		
	}
	
	@Test(dependsOnMethods = {"addCustomer"})
	public void verifyOrderPlaced()
	{
		
		Home home = new Home(driver);
		home.getOrderManagementModule().click();
		home.getPOS_Orders().click();
		OrdersManagement_POSorders posOrders = new OrdersManagement_POSorders(driver);
		List<WebElement> customersNameList = posOrders.getCustomerNameList();
		for(WebElement e : customersNameList)
		{
			//System.out.println(e.getText());
			if(e.getText().equals(newCustomerName))
				Reporter.log(newCustomerName+"'s"+ " Order Created Successfully & Verified",true);
				break;
		}
	}

}
