package com.assignment2.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AppTestScripts.WebLinkInformation;
import com.AppUtilities.ConfigReader;

public class weblinksassignment2 {
	
	public static WebDriver driver;
	public ConfigReader config;
	
	
  @BeforeTest ()
  public void launchBrowser() {
	  
	  driver=new ChromeDriver();
	  config=new ConfigReader();  
	  driver.manage().window().maximize();
	  driver.get(config.getBrowserUrl());
  }
  @Test
  public void checklinks() throws Exception
  {
	  WebLinkInformation.verifylinks(driver);
  }
  
  @AfterTest
  public void closeBrowser()
  {
	  driver.close();
  }
  
}
