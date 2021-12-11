package com.konexPos.customersTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Reporter;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.konex.commonUtils.BaseClass;
import com.konexPos.objectRepositoryLib.Customers_AddCustomer;
import com.konexPos.objectRepositoryLib.Customers_CustomerList;
import com.konexPos.objectRepositoryLib.Home;
import com.konexPos.objectRepositoryLib.MailinatorHomePage;

public class AddCustomertest extends BaseClass {
	private String customerName;
	private String mobileNo;
	private String emailId;

	@Test(groups= {"SmokeTest"})  
	public void createCustomer() throws Throwable {
		String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
		Home hm = new Home(driver);
		hm.getCustomersModule().click();
		hm.getAddCustomer().click();
		Customers_AddCustomer addCustomer = new Customers_AddCustomer(driver);
		customerName = eUtil.getExcelData("VendorPortalTCD", "tc_01", "Customer Name") + jUtil.getRandomIntegerValue();
		mobileNo = Long.toString(jUtil.getNewMobileNo());
		emailId = jUtil.getNewEmailId();
		addCustomer.getCustomerName().sendKeys(customerName);
		addCustomer.getMobileNoEdt().sendKeys(mobileNo);
		addCustomer.getEmailEdt().sendKeys(emailId);
		addCustomer.getAddButton().click();

//		new FluentWait<WebDriver>(driver)
//	    .withTimeout(Duration.ofSeconds(30))
//	    .pollingEvery(Duration.ofMillis(500))
//	    .ignoring(NoSuchElementException.class)
//	    .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='OK']"))));
//       // boolean isoverlayPresent=wUtil.waitForElementXpath(driver, "//div[@class='swal-overlay swal-overlay--show-modal']/div");
//		WebElement u =driver.findElement(By.xpath("//button[text()='OK']"));
//		if(u.isDisplayed())
//		{
//			System.out.println("overlay present ");
//			addCustomer.getCustomerAddedSuccessfullyOkBtn().click();
//			System.out.println("overlay Ok button clicked ");
//			
//		}
//		
		// verifying mobile no of newly created customer
		Customers_CustomerList custList = new Customers_CustomerList(driver);
		wUtil.waitForElementXpath(driver, custList.getMobileNosList());
		List<WebElement> mobileNosList = custList.getMobileNosList();
		int counter = 1;
		for (int i = 0; i < mobileNosList.size(); i++) {
			String lMobileNo = mobileNosList.get(i).getText();
			if (lMobileNo.equals(mobileNo)) {
				Reporter.log("Newly Customer Mobile No is Verified in Customer List "+ "in Class " + getClass().getName() + " at Method "+ nameofCurrMethod, true);
				break;
			}
			counter++;
			if (counter == mobileNosList.size()) {
				Assert.assertTrue(false, "Newly Customer Mobile No is NOT Verified in Customer List");
			}

		}

		// opening new tab

		((JavascriptExecutor) driver).executeScript("window.open()");
//		Robot r = new Robot();
//		r.keyPress(KeyEvent.VK_CONTROL);
//		r.keyPress(KeyEvent.VK_T);
//		r.keyRelease(KeyEvent.VK_CONTROL);
//		r.keyRelease(KeyEvent.VK_T);
//		Thread.sleep(2000);

		// Verify email username password
		WebDriverWait w = new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.numberOfWindowsToBe(2));
		ArrayList<String> al = new ArrayList<String>(driver.getWindowHandles());
		// System.out.println(al.size());
//		for (String x : al) {
//			System.out.println(x);
//		}

		driver.switchTo().window(al.get(1)); // switches to new tab
		driver.get("https://www.mailinator.com");
		MailinatorHomePage mailinatorWebSite = new MailinatorHomePage(driver);
		mailinatorWebSite.getinputEmailBoxEdt().sendKeys(emailId);
		mailinatorWebSite.getGoButton().click();
		mailinatorWebSite.getOpenEmail().click();
		int count = 0;
		while (count < 100) {
			try {
				driver.switchTo().frame("html_msg_body");
				Assert.assertTrue(mailinatorWebSite.getuNamePnameText().getText().contains("Username"),
						" Username is not There in mail ");
				Assert.assertTrue(mailinatorWebSite.getuNamePnameText().getText().contains(mobileNo),
						" Username is not There in mail ");
				Assert.assertTrue(mailinatorWebSite.getuNamePnameText().getText().contains("Password"),
						" password is not There in mail ");
				Reporter.log("All Fields Checked in Email  " + "in Class " + getClass().getName() + " at Method "+ nameofCurrMethod, true);
				driver.switchTo().defaultContent();
				break;

			} catch (Exception e) {
				//System.out.println(count);
				count++;
				Thread.sleep(2000);
				e.printStackTrace();
			}
		}

		// switch back to main screen
		driver.switchTo().window(al.get(0));

	}

}
