package com.konex.commonUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
	
	
	public String getSysteDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyy-HH-mm-ss");
		Date date = new Date();
		 String sysDate = dateFormat.format(date);
		 return sysDate;
	}

	public int getRandomIntegerValue()
	{
		Random random = new Random();
		int randomData =random.nextInt(100000);
		return randomData;
	}
	
	public String getNewEmailId()
	{		
		String email= "testemail"+getNewMobileNo()+"@mailinator.com";		
		return email;
	}
	
	public long getNewMobileNo() { 
	    Random rnd = new Random();
	    char [] digits = new char[10];
	    digits[0] = '9';
	    for(int i=1; i<digits.length; i++) {
	        digits[i] = (char) (rnd.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
	
	public String getNewName()
	{
		String name = "Testname"+getRandomIntegerValue();
		return name;		
	}
	
	
	public void verifyEmailCredentials()
	{
		
	}
	
}
