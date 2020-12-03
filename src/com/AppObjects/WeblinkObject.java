package com.AppObjects;

public class WeblinkObject {
	private String pagetitle;
	private String weburl;
	private String linkname;
	
	public WeblinkObject(String ptitle,String url,String lname)
	{
		pagetitle=ptitle;
		weburl=url;
		linkname=lname;
	}
	public String getPageTitle()
	{
		return pagetitle;
	}
	public String getWebUrl()
	{
		return weburl;
	}
	public String getLinkName()
	{
		return linkname;
	}
	public void setPageTitle(String tle)
	{
		pagetitle=tle;
	}
	public void setWebUrl(String url)
	{
		weburl=url;
	}
	public void setLinkName(String lname)
	{
		linkname=lname;
	}
}
