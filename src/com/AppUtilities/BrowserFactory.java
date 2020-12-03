package com.AppUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	public WebDriver driver;
	private ConfigReader config;
	public void getbrowsertype(String browsertype,String AppUrl)
	{
		if(browsertype.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "./myDrivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsertype.equals("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", "./myDrivers/geckodriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsertype.equals("edge"))
		{
			//System.setProperty("webdriver.msedge.driver", "./myDrivers/msedgedriver.exe");
			driver=new ChromeDriver();
		}
		driver.get(AppUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public void setcustomername(String cname)
	{
		driver.findElement(By.name(config.getcustomernameelement())).sendKeys(cname);
	}
	public void setcustomeremail(String cemail)
	{
		driver.findElement(By.name(config.getcustomeremailelement())).sendKeys(cemail);
	}
	public void setlinkback(String clink)
	{
		driver.findElement(By.name(config.getlinkbacktositeelement())).sendKeys(clink);
	}
	public void setcustomersitetitle(String ctitle)
	{
		driver.findElement(By.name(config.getsitetitleelement())).sendKeys(ctitle);
	}
	public void setcustomerwebsite(String cwebsite)
	{
		driver.findElement(By.name(config.getwebadresselement())).sendKeys(cwebsite);
	}
	public void setwebsitedescription(String description)
	{
		driver.findElement(By.name(config.getsitedescriptionelement())).sendKeys(description);
	}
	public void submitform()
	{
		driver.findElement(By.name(config.getsubmitelement())).click();
	}
	public String getcustomername()
	{
		return driver.findElement(By.name(config.getcustomernameelement())).getAttribute("value");
	}
	public String getcustomeremail()
	{
		return driver.findElement(By.name(config.getcustomeremailelement())).getAttribute("value");
	}
	public String getlinkback()
	{
		return driver.findElement(By.name(config.getlinkbacktositeelement())).getAttribute("value");
	}
	public String getcustomersitetitle()
	{
		return driver.findElement(By.name(config.getsitetitleelement())).getAttribute("value");
	}
	public String getcustomerwebsite()
	{
		return driver.findElement(By.name(config.getwebadresselement())).getAttribute("value");
	}
	public String getwebsitedescription()
	{
		return driver.findElement(By.name(config.getsitedescriptionelement())).getAttribute("value");
	}
	public void closeBrowser()
	{
		driver.close();
	}

}
