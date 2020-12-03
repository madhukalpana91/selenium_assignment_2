package com.AppTestScripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.AppUtilities.ExcelDataProvider;

public class WebLinkInformation {
	
	public static WebDriver driver;
	
	
	public  static WebDriver verifylinks(WebDriver driver) throws Exception
	{
		List<String> arrdata=new ArrayList<String>();
		List<String> weburllist=new ArrayList<String>();
		List<String> listtitle=new ArrayList<String>();
		List<WebElement> browserlinks=driver.findElements(By.tagName("a"));
		for (WebElement weburl : browserlinks)
		{
			arrdata.add(weburl.getText());
			String btext=weburl.getText();
			
			weburllist.add(weburl.getAttribute("href"));
			String burl=weburl.getAttribute("href");
		}
		
		System.out.println("total no of linknames :"+arrdata.size());
		System.out.println("total no of weburls  :"+weburllist.size());
		
		for(String linkdata : arrdata)
		{
			driver.findElement(By.linkText(linkdata)).click();
			String webtitle=driver.getTitle();
			listtitle.add(webtitle);
			System.out.println("title is:"+webtitle);
			Thread.sleep(1000);
			driver.navigate().back();
		}
		
		System.out.println("total no of webtitles :"+listtitle.size());
		
		int columns=3;
		String[][] arraydata;
		arraydata=new String[22][3];
		
		for(int i=0;i<listtitle.size();i++)
		{
			arraydata[i][0]=listtitle.get(i);
			arraydata[i][1]=weburllist.get(i);
			arraydata[i][2]=arrdata.get(i);
			
		}
		ExcelDataProvider.updateweburlinformation(arraydata, listtitle.size(), 3);
		return driver;
		
	}
	

}
