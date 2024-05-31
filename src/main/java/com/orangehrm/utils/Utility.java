package com.orangehrm.utils;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	public Map<Integer, Map<String, String>> fetchEmployeeDetails(int count) {
	    Map<Integer, Map<String, String>> employeeDetails = new HashMap<>();
	    
	    // Execute database query to fetch all employee details
	    String query = "SELECT * FROM EmployeeDetails"; // Query to fetch all rows
	    ResultSet resultSet = DatabaseUtils.executeQuery(query);
	    
	    try {
	        int slNo = 1;
	        while (resultSet.next() && (count == 0 || slNo <= count)) { // Fetch all rows or up to the count limit
	            Map<String, String> employeeData = new HashMap<>();
	            
	            // Retrieve employee details
	            String firstName = resultSet.getString("FirstName");
	            String lastName = resultSet.getString("LastName");
	            String employeeId = resultSet.getString("EmployeeId");
	            String username = resultSet.getString("UserName");
	            String password = resultSet.getString("Pwd");
	            
	            // Store remaining columns in a map
	            employeeData.put("FirstName", firstName);
	            employeeData.put("LastName", lastName);
	            employeeData.put("EmployeeId", employeeId);
	            employeeData.put("UserName", username);
	            employeeData.put("Pwd", password);
	            
	            // Store SlNo and remaining columns in a map
	            employeeDetails.put(slNo, employeeData);
	            slNo++;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return employeeDetails;
	}
	
}
