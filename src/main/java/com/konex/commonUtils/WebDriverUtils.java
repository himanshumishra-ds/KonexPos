package com.konex.commonUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtils {
	
	public void waitForElementXpath(WebDriver driver , List<WebElement> list) throws InterruptedException {
		int count =0 ; 
		 while(count<40) {
			 try {
				 if(list.listIterator().hasNext());
				 break;
			 }catch (Exception e) {
				Thread.sleep(500);
				count ++;
			}
		 }
	}	
	
	public void waitForElementXpath(WebDriver driver , WebElement webElement) throws InterruptedException {
		int count =0 ; 
		 while(count<40) {
			 try {
				 webElement.isEnabled();
				 break;
			 }catch (Exception e) {
				Thread.sleep(500);
				count ++;
			}
		 }
	}	
	
	
	public boolean waitForElementXpath(WebDriver driver , String xpath) throws InterruptedException {
		int count =0 ; 
		boolean flag =false;
		 while(count<10000000) {
			 try {
				 System.out.println(xpath);
				 driver.findElement(By.xpath(xpath));
				 flag=true;
				 break;
			 }catch (Exception e) {
				//Thread.sleep(100);
				count ++;
			}
		 }
		 return flag;
	}
	public void waitForPageTitle(WebDriver driver,String pageTitle)
	{
		WebDriverWait wait = new WebDriverWait(driver , 20);
		wait.until(ExpectedConditions.titleContains(pageTitle));
	}
	
	
	public void waitForInvisibilityOfElementLocated(WebDriver driver,WebElement webElement)
	{
		WebDriverWait wait = new WebDriverWait(driver , 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By) webElement));
	}
	
	public void waitForVisibilityOfElement(WebDriver driver,WebElement webElement)
	{
		WebDriverWait wait = new WebDriverWait(driver , 40);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	
	
	
	

	public void moveToElement(WebDriver driver ,WebElement target )
	{
		Actions a = new Actions(driver);
		a.moveToElement(target).build().perform();
	}
	
	public void _click(WebDriver driver ,WebElement element) throws IOException{
	    boolean flag = false;
	    while(true) {
	        try{
	            element.click();
	            flag=true;
	        }
	        catch (Exception e){
	        	File filedest = new File("./ScreenShot/"+"clickMethodExceptionHandlink"+".jpg");
				EventFiringWebDriver eFiringWD = new EventFiringWebDriver(driver);
				File fileSrc =eFiringWD.getScreenshotAs(OutputType.FILE);
				Files.copy(fileSrc, filedest);
				
	            flag = false;
	        }
	        if(flag)
	        {
	            try{
	                element.click();
	            }
	            catch (Exception e){
	                System.out.printf("Element: " +element+ " has beed clicked, Selenium exception triggered: " + e.getMessage());
	            }
	            break;
	        }
	    }
	}
	
	public void selectByVisibleTextDropDown(WebElement webElement , String string)
	{
		Select s = new Select(webElement);
		s.selectByVisibleText(string);		
				
	}
	
}
