package com.AppTestScripts;

import java.io.File;

public class FormTest {
	
	String customername;
	String customeremail;
	String linkback;
	String websitetitle;
	String weburl;
	String webdescription;
	
	public FormTest(String username, String email, String linkbacktosite, String sitetitle, String webadress,
			String description) {
		this.customername = username;
		this.customeremail=email;
		this.linkback=linkbacktosite;
		this.websitetitle=sitetitle;
		this.weburl=webadress;
		this.webdescription=description;
		
	}
	
	public String getName()
	{
		return customername;
	}
	public String getemail()
	{
		return customeremail;
	}
	public String getlinkbacktosite()
	{
		return linkback;
	}
	public String getwebsitetittle()
	{
		return websitetitle;
	}
	public String getwebaddress()
	{
		return weburl;
	}
	public String getwebdescription()
	{
		return webdescription;
	}	
	
}
