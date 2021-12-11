package com.konex.commonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	public String[] getUserNamePassword(String key1 , String key2 ) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstant.propertyFilePath);
		Properties prop = new Properties();
		prop.load(fis);
		  String userName=prop.getProperty(key1);
		  String password =prop.getProperty(key2);		
		  return new String[] {userName,password};
		  
		
	}
	
	public String getPropertyKeyValue(String key) throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(IConstant.propertyFilePath);
		prop.load(fis);
		 String value=prop.getProperty(key);
		return  value;
		
	}
	
	
}
