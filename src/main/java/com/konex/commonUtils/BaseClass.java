package com.konex.commonUtils;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;
import com.konexPos.objectRepositoryLib.Customers_AddCustomer;
import com.konexPos.objectRepositoryLib.Home;
import com.konexPos.objectRepositoryLib.Login;

public class BaseClass {
	
	
	public WebDriverUtils wUtil = new WebDriverUtils();
    public FileUtility fUtil = new FileUtility();
    public JavaUtils jUtil = new JavaUtils();
    public ExcelUtility eUtil = new ExcelUtility();
    public   WebDriver driver;
    
    
	
	
	//Konex POS Vendor Login
	String BROWSER= "chrome";
	String URL ="http://172.104.160.243:8080/konexposvendor/login";
	String LoginPageTitle = "Konex POS Vendor Login";
	
	@BeforeSuite
	public void configureBeforeSuite()
	{	
				System.out.println("========= connect to db ===========");			
	}
	
	@BeforeClass
	public void configureBeforeClass()
	{
		System.out.print("==============Launching Browser===================");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
//		 ChromeOptions options = new ChromeOptions();
//	        options.addArguments("headless");
//	        options.addArguments("window-size=1400,800");       
//	        options.addArguments("disable-gpu");
	        //options.addArguments("--headless", "--disable-gpu", "--window-size=1400,800","--ignore-certificate-errors");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		Assert.assertTrue(driver.getTitle().equals(LoginPageTitle), "Login Page Title not verified");
	    		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
			driver.get(URL);	
			
		}
	}
	//@Parameters("browser")
	//@BeforeClass
	public void configureBeforeClass(String BROWSER)
	{
		System.out.print("==============Launching Browser===================");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
//		 ChromeOptions options = new ChromeOptions();
//	        options.addArguments("headless");
//	        options.addArguments("window-size=1400,800");       
//	        options.addArguments("disable-gpu");
	        //options.addArguments("--headless", "--disable-gpu", "--window-size=1400,800","--ignore-certificate-errors");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
		Assert.assertTrue(driver.getTitle().equals(LoginPageTitle), "Login Page Title not verified");
	    		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
			driver.get(URL);	
			
		}
	}
		
		
		@BeforeMethod
		public void configureBeforeMethod() throws IOException
		{
			System.out.println("=============Login=================");			
			String [] vendorCredentials=fUtil.getUserNamePassword("vendorUserName",  "vendorPassword");
			Login login = new Login(driver)	;
			login.loginToApp(vendorCredentials[0], vendorCredentials[1]);	
		}
		
		@AfterMethod
		public void ConfigureAfterMethod() throws InterruptedException, IOException, NoSuchMethodException, SecurityException
		{
			System.out.println("================Loging Out The Application==================");
			Home h = new Home(driver)	;
			
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement webElement=h.getProfileImage();
			// j = (JavascriptExecutor) driver;
		      //j.executeScript("arguments[0].click();",webElement );
			//System.out.println(webElement.isDisplayed());
			//System.out.println(webElement.isEnabled());
			try 
			{
				
				wait.until(ExpectedConditions.elementToBeClickable(h.getProfileImage()));
				//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='requiredFeild validation-message']/ancestor::label[contains(text(),'Mobile')]")));
				wUtil.moveToElement(driver, webElement);		
				webElement.click();				
				h.getLogOutButton().click();
				h.getVerifyLogOutButton().click();	
				
			}
			catch(Exception e )
			{
				
				//taking screenshot for cause of exception *(OverLay proplem)
				String className = new Object() {}.getClass().getName();
				String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
				String name = className+" "+methodName+" "+jUtil.getSysteDate();
				File filedest = new File("./ScreenShot/"+name+".jpg");
				EventFiringWebDriver eFiringWD = new EventFiringWebDriver(driver);
				File fileSrc =eFiringWD.getScreenshotAs(OutputType.FILE);
				Files.copy(fileSrc, filedest);
				
				//trying for invisibilityOfElementLocated and logging out
				Customers_AddCustomer addCustomer = new Customers_AddCustomer(driver);				
				wUtil.waitForInvisibilityOfElementLocated(driver, addCustomer.getMobileText());
				wUtil.moveToElement(driver, webElement);		
				webElement.click();				
				h.getLogOutButton().click();
				h.getVerifyLogOutButton().click();	
				
			
			}
			
		
				//element not clickable exception 
			    //element not interectable excepotion 
			//<div class="justify-content-center loader_img d-flex-remove d-flex"
		}
		
		@AfterClass
		public void configAfterClass()
		{
			System.out.println("============Closing the Browser=================");
			driver.quit();
			
			
		}
		
		@AfterSuite
		public void configAfterSuite()
		{
			System.out.println("==================closing the DB connection========================");
		}
		
		
		
		//@AfterMethod(alwaysRun=true)
		public void cleanup(){
		driver.quit();
		}
		


	
	
	
	}
	
	


