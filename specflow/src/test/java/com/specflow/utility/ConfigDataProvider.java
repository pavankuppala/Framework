package com.specflow.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider
{
	public Properties p;
	public ConfigDataProvider()throws Exception
	{
		FileInputStream fis=new FileInputStream(new File("./config/config.properties"));
	    p=new Properties();
		p.load(fis);
		
	}
	
	
	public String getBrowser()throws Exception
	{
		return p.getProperty("browser");
	}

	public String getURL()throws Exception
	{
		return p.getProperty("url");
	}
}
