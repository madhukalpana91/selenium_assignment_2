package com.AppUtilities;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;
	private File file;
	private FileInputStream fis;
	
	public ConfigReader()
	{
		try{
			file=new File("./src/myFiles/login.properties");
			fis=new FileInputStream(file);
			prop=new Properties();
			prop.load(fis);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally{
			System.out.println("properties file loaded successfully");
		}
		
	}
	public String getBrowserDriver()
	{
		return prop.getProperty("browserdriver");
	}
	public String getBrowserDriverPath()
	{
		return prop.getProperty("browserdriverpath");
	}
	public String getLoginPropertyFilePath()
	{
		return prop.getProperty("loginpropfilepath");
	}
	public String getBrowserUrl()
	{
		return prop.getProperty("browserurl");
	}
	public String getinputdatafilepath()
	{
		return prop.getProperty("inputdatapath");
	}
	public String geterrorurlafterformsubmit()
	{
		return prop.getProperty("error_url_after_form_submission");
	}
	//creating repositories for web elements
	public String getcustomernameelement()
	{
		return prop.getProperty("customername");
	}
	public String getlinkbacktositeelement()
	{
		return prop.getProperty("linkbacktosite");
	}
	public String getcustomeremailelement()
	{
		return prop.getProperty("customeremail");
	}
	public String getsitetitleelement()
	{
		return prop.getProperty("sitetitle");
	}
	public String getwebadresselement()
	{
		return prop.getProperty("customerwebadress");
	}
	public String getsitedescriptionelement()
	{
		return prop.getProperty("sitedescription");
	}
	public String getsubmitelement()
	{
		return prop.getProperty("submitbutton");
	}
}
