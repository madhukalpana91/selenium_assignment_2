package com.AppUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.AppTestScripts.FormTest;

public class ExcelDataProvider {
	public static int Column_total;
	public static int row_total;
	private static ConfigReader config;
	
	@DataProvider(name="getlogindata")
	public Object[][] logindata()
	{
		config=new ConfigReader();
		Object[][] arrayObject=getExcelData(config.getinputdatafilepath(),"Sheet1");
		return arrayObject;
	}
	
	public String[][] getExcelData(String fileName,String sheetName)
	{
		String[][] arraydataExcel =null;
		try{
			FileInputStream fis=new FileInputStream(fileName);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh=wb.getSheet(sheetName);
			XSSFRow row=null;
			
			row=sh.getRow(0);
			int total_no_of_columns=row.getLastCellNum();
			Column_total=total_no_of_columns;
			System.out.println("total no of colums :"+total_no_of_columns);
			int total_no_of_rows=sh.getLastRowNum()+1;
			System.out.println("total no of rows :"+total_no_of_rows);
			row_total=total_no_of_rows;
			
			arraydataExcel=new String[total_no_of_rows-1][total_no_of_columns];
			
			for (int i=1; i <total_no_of_rows;i++)
			{
				
				for(int j=0;j<total_no_of_columns;j++)
				{
					arraydataExcel[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
				}
			}	
			
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		finally{
			
		}
		return arraydataExcel;
	}

	
	public static void ExpectedActualValidation(int rowno, int column,String Expectedvalue,String Actualvalue) throws Exception
	{	
		config=new ConfigReader();
		File file=new File(config.getinputdatafilepath());
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheetAt(0);
		XSSFRow row=null;
		
		/*row=sh.getRow(rowno);
		int total_no_of_columns=row.getLastCellNum();*/
		int column_to_update_value=Column_total+column;
		int row_to_update=rowno+1;
		
		if (Expectedvalue.equals(Actualvalue))
		{
			if(column==0)
			{ 	
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue("Both actual value & expected value of name is same");
			}
			else if(column==1)
			{
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue("Both actual value & expected value of email is same");
			}
			else if(column==2)
			{
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue("Both actual value & expected value of link back to website is same");
			}
			else if(column==3)
			{
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue("Both actual value & expected value of website title is same");
			}
			else if(column==4)
			{
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue("Both actual value & expected value of weburl is same");
			}
			else
			{
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue("Both actual value & expected value of webdescription is same");
			}
		}
		else
		{
			
			if(column==0)
			{ 	
				String info="Both actual value & expected value of name is not same. Actual value is :"+Actualvalue +" and Expected value is :"+Expectedvalue;
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue(info);
			}
			else if(column==1)
			{
				String info="Both actual value & expected value of email is not same. Actual value is :"+Actualvalue +" and Expected value is :"+Expectedvalue;
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue(info);
			}
			else if(column==2)
			{	String info="Both actual value & expected value of link back to website is not same. Actual value is :"+Actualvalue +" and Expected value is :"+Expectedvalue;
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue(info);
			}
			else if(column==3)
			{	String info="Both actual value & expected value of website title is not same. Actual value is :"+Actualvalue +" and Expected value is :"+Expectedvalue;
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue(info);
			}
			else if(column==4)
			{	String info="Both actual value & expected value of webaddress is not same. Actual value is :"+Actualvalue +" and Expected value is :"+Expectedvalue;
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue(info);
			}
			else
			{String info="Both actual value & expected value of webdrescription is not same. Actual value is :"+Actualvalue +" and Expected value is :"+Expectedvalue;
				sh.getRow(row_to_update).createCell(column_to_update_value).setCellValue(info);
			}
			System.out.println("Actual value is :"+Actualvalue);
			System.out.println("Expected value is :"+Expectedvalue);
		}
		
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		wb.close();
		fis.close();	
		
	}
	public static void Updateformsubmissionstatus(int rowno,String errormessage) throws Exception
	{	
		config=new ConfigReader();
		File file=new File(config.getinputdatafilepath());
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheetAt(0);
		XSSFRow row=null;
		int row_to_update=rowno+1;
		int column_to_update=(2*Column_total)-1;
		sh.getRow(rowno+1).createCell(column_to_update).setCellValue(errormessage);
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		wb.close();
		fis.close();
	}
	public static void updateweburlinformation(String[][] weblinks ,int totalrows,int totalcolumns) throws Exception
	{	
		config=new ConfigReader();
		File file=new File(config.getinputdatafilepath());
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheetAt(1);
		XSSFRow row=sh.createRow(0);
		String colnames[]={"PAGE_TITLE","WEB_URL","LINK_NAME"};
      //  Row row = sheet.createRow(rowNum++);

			System.out.println("creating cell in excel header");
			sh.getRow(0).createCell(0).setCellValue(colnames[0]);
			sh.getRow(0).createCell(1).setCellValue(colnames[1]);
			sh.getRow(0).createCell(2).setCellValue(colnames[2]);
			System.out.println("created column name");
		
		
		for (int i=1;i<totalrows;i++)
		{
			XSSFRow rows = sh.createRow(i);
			for(int j=0;j<totalcolumns;j++)
			{
			
				rows.createCell(j).setCellValue(weblinks[i-1][j]);
			}
		}
		System.out.println("updating excel");
		FileOutputStream fos=new FileOutputStream(file);
		wb.write(fos);
		wb.close();
		
		
	}
}
