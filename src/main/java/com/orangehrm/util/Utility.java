package com.orangehrm.util;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.base.BasePage;

public class Utility extends BasePage{
	
	XLSReader reader;
	
	public Utility()  {
		reader	 = new XLSReader("/Users/keerthibasvoju/eclipse/SeleniumWorkbook/SeleniumSpreadsheet.xlsx");	
	}
	
	public static void waitUntilElement(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public  ArrayList<String>  getEmployeeDetails(int sheetNum, int rowNum) throws IOException {
		
	ArrayList<String> arr = new ArrayList<String>();
	
	System.out.println("ColumnCount is"+reader.columnCount(sheetNum));
	
	
	String empFirstName = reader.getCellData(sheetNum, rowNum, 1);
	arr.add(empFirstName); System.out.println("FirstNameis"+empFirstName);
	
	String empLastName = reader.getCellData(sheetNum, rowNum, 3);
	arr.add(empLastName);
	
	String empId = reader.getCellData(sheetNum, rowNum, 4);
	arr.add(empId);
		
	String empUserName = reader.getCellData(sheetNum, rowNum, 5);
	arr.add(empUserName);
	
	String empPassword = reader.getCellData(sheetNum, rowNum, 6);
	arr.add(empPassword); System.out.println("FirstNameis"+empPassword);

	return arr;

	}
	
	public int getRowCount(int sheetNum) {
		
		int rowCount = reader.rowCount(sheetNum);
		
		return rowCount;
	}
	
	public String getSheetName(int sheetNum) {
		
		String sname = reader.sheetName(sheetNum);
		
		return sname;
	}
	
}
