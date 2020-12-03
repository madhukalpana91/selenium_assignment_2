package com.assignment1.testng;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AppTestScripts.FormTest;
import com.AppUtilities.ConfigReader;
import com.AppUtilities.ExcelDataProvider;

public class Assignment1 {
	
	public static WebDriver driver;
	public List<FormTest> formtestlist;
	public ConfigReader config;
	
	@BeforeTest
	public void launchBrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "./myDrivers/chromedriver.exe")
		driver=new ChromeDriver();
		config=new ConfigReader();
		
		formtestlist = new ArrayList<>();
	}
	
	
	
	 
  @Test(dataProvider="getlogindata" ,dataProviderClass=ExcelDataProvider.class, priority=1 )
  public void forminputdata(String username,String email,String linkbacktosite,String sitetitle,String webadress,String decription) 
  {
	  FormTest formtest = new FormTest(username, email, linkbacktosite, sitetitle, webadress, decription);
	  formtestlist.add(formtest);
	  System.out.println("getlogindata " + formtestlist.size() );

  }
  
  @Test(priority=2)
  public void action() throws Exception
  {
	  System.out.println("hello " + formtestlist.size() );
	  for(int i=0; i <formtestlist.size();i++)
	  {
		  driver.get("https://www.mycontactform.com/samples/linkrequest.php");
		  
		   /*driver.findElement(By.name(config.getcustomernameelement())).sendKeys(formtestlist.get(i).getName());
		  Thread.sleep(500);
		  driver.findElement(By.name(config.getcustomeremailelement())).sendKeys(formtestlist.get(i).getemail());
		  Thread.sleep(500);
		  driver.findElement(By.name(config.getlinkbacktositeelement())).sendKeys(formtestlist.get(i).getlinkbacktosite());
		  Thread.sleep(500);
		  driver.findElement(By.name(config.getsitetitleelement())).sendKeys(formtestlist.get(i).getwebsitetittle());
		  Thread.sleep(500);
		  driver.findElement(By.name(config.getwebadresselement())).sendKeys(formtestlist.get(i).getwebaddress());
		  Thread.sleep(500);
		  driver.findElement(By.name(config.getsitedescriptionelement())).sendKeys(formtestlist.get(i).getwebdescription());
		  Thread.sleep(500);
		  driver.findElement(By.name(config.getsubmitelement())).click();
		  */
		  WebElement cname=driver.findElement(By.name(config.getcustomernameelement()));
		  cname.sendKeys(formtestlist.get(i).getName());
		  ExcelDataProvider.ExpectedActualValidation(i, 0, formtestlist.get(i).getName(), cname.getAttribute("value"));
		  
		  WebElement cemail=driver.findElement(By.name(config.getcustomeremailelement()));
		  cemail.sendKeys(formtestlist.get(i).getemail());
		  ExcelDataProvider.ExpectedActualValidation(i, 1, formtestlist.get(i).getemail(), cemail.getAttribute("value"));
		  
		  WebElement clinkback=driver.findElement(By.name(config.getlinkbacktositeelement()));
		  clinkback.sendKeys(formtestlist.get(i).getlinkbacktosite());
		  ExcelDataProvider.ExpectedActualValidation(i, 2, formtestlist.get(i).getlinkbacktosite(),clinkback.getAttribute("value"));
		  
		  WebElement cwebtitle=driver.findElement(By.name(config.getsitetitleelement()));
		  cwebtitle.sendKeys(formtestlist.get(i).getwebsitetittle());
		  ExcelDataProvider.ExpectedActualValidation(i, 3, formtestlist.get(i).getwebsitetittle(),cwebtitle.getAttribute("value"));
		  
		  WebElement cwebaddress=driver.findElement(By.name(config.getwebadresselement()));
		  cwebaddress.sendKeys(formtestlist.get(i).getwebaddress());
		  ExcelDataProvider.ExpectedActualValidation(i, 4, formtestlist.get(i).getwebaddress(), cwebaddress.getAttribute("value"));
		  
		  WebElement cdescription=driver.findElement(By.name(config.getsitedescriptionelement()));
		  cdescription.sendKeys(formtestlist.get(i).getwebdescription());
		  ExcelDataProvider.ExpectedActualValidation(i, 5, formtestlist.get(i).getwebdescription(), cdescription.getAttribute("value"));
		  
		  Thread.sleep(500);
		  driver.findElement(By.name(config.getsubmitelement())).click();
		  
		  
		  System.out.println("current url :"+driver.getCurrentUrl());
		  String currenturl=driver.getCurrentUrl();
		  System.out.println("error url :"+config.geterrorurlafterformsubmit());
		  if(currenturl.equalsIgnoreCase(config.geterrorurlafterformsubmit()))
		  {
		  WebElement errormsg=driver.findElement(By.id("content"));
		  String errortext=errormsg.getText();
		  System.out.println("error message :"+errortext);
		  ExcelDataProvider.Updateformsubmissionstatus(i, errortext);
		  }
		  else
		  {
			  ExcelDataProvider.Updateformsubmissionstatus(i, "form submitted successfully");
		  }
		  
	  }		  
	  
  }
  ///html/body/div[2]/ul/li
  
  
  
  @AfterTest
  public void closeBrowser()
  {
	  driver.close();
  }
  
}
