package com.konexPos.objectRepositoryLib;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.xmlbeans.impl.jam.JamUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.konex.commonUtils.ExcelUtility;

public class TestClass {

	private static final Random Random = null;


	
	public static void main(String[] args) throws Throwable
	{
		//TestClass.excelData();
		//System.out.println(TestClass.getRndNumber());
		//TestClass.createRandomInteger(0,9,new Random())  ;
		//===================
//		int x=0;
//		while(x<10)
//		{
//			System.out.println(TestClass.generateID());
//			x++;
//		}
				
		//		======================
		
		
		//System.out.println(TestClass.getSysteDate());
		
		//=====================================
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://google.com");
		driver.manage().window().maximize();
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,"t");
		//driver.findElement(By.linkText("urlLink")).sendKeys(selectLinkOpeninNewTab);
		
	}
	
	public static String getSysteDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		Date date = new Date();
		 String sysDate = dateFormat.format(date);
		 return sysDate;
	}
	public static long generateID() { 
	    Random rnd = new Random();
	    char [] digits = new char[10];
	    digits[0] = '9';
	    for(int i=1; i<digits.length; i++) {
	        digits[i] = (char) (rnd.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
	
	   private static void createRandomInteger(int aStart, long aEnd, Random aRandom){
		    if ( aStart > aEnd ) {
		      throw new IllegalArgumentException("Start cannot exceed End.");
		    }
		    //get the range, casting to long to avoid overflow problems
		    long range = aEnd - (long)aStart + 1;
		    System.out.println("range>>>>>>>>>>>"+range);
		    // compute a fraction of the range, 0 <= frac < range
		    long fraction = (long)(range * aRandom.nextDouble());
		    System.out.println("fraction>>>>>>>>>>>>>>>>>>>>"+fraction);
		    long randomNumber =  fraction + (long)aStart;    
		    System.out.println("Generated : " + randomNumber);

		  }
	protected static int getRndNumber() {
	    Random random=new Random();
	    int randomNumber=0;
	    boolean loop=true;
	    while(loop) {
	        randomNumber=random.nextInt();
	        if(Integer.toString(randomNumber).length()==10 && !Integer.toString(randomNumber).startsWith("-") && Pattern.matches("^[489][0-9]{10}$",Integer.toString(randomNumber) )) 
	        {
	            loop=false;
	        }
	        }
	    return randomNumber;
	}
	
	
	
	public static void excelData() throws Throwable
	{
		
		String data=new ExcelUtility().getExcelData("test" , "tc_01" , "OrgName");
		
	    String data1=new ExcelUtility().getExcelData("test", 1, 1);		
		System.out.println(data1);
		System.out.println(data);
		
	}
	
}
