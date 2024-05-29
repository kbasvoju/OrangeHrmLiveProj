package com.orangehrm.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BasePage;
import com.orangehrm.util.Utility;
import com.orangehrm.util.XLSReader;

public class PIMPage extends BasePage{
	
Utility util = new Utility();
	
	@FindBy(xpath="//button[text()=' Add ']")
	public WebElement addBtn;
	
	@FindBy(xpath="//a[text()='Add Employee']")
	public WebElement addEmployeeBtn;
	
	@FindBy(xpath="//input[@name='firstName']")
	public WebElement empFirstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	public WebElement empLastName;
	
	@FindBy(xpath="//label[text()='Employee Id']/parent::div/following-sibling::div/input")
	public WebElement empId;
	
	@FindBy(xpath="//button[contains(@class,'employee-image-action')]]")
	public WebElement addImage;
	
	@FindBy(xpath="//p[text()='Create Login Details']/following-sibling::div/label")
	public WebElement createLoginDetails;
	
	@FindBy(xpath="//label[text()='Username']/parent::div/following-sibling::div/input")
	public WebElement empUserName;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement empPassword;
	
	@FindBy(xpath="//label[text()='Confirm Password']/parent::div/following-sibling::div/input")
	public WebElement empConfirmPassword;
	
	@FindBy(xpath="//button[text()=' Save ']")
	public WebElement empSave;
	
	@FindBy(xpath="//a[text()='Employee List']/parent::li")
	public WebElement employeeList;
	
	@FindBy(xpath="//label[text()='Employee Name']/parent::div/following-sibling::div//input")
	public WebElement empName;
	 
	@FindBy(xpath="//div[@role='rowgroup']/following-sibling::div//span")
	public WebElement empRow;
	
	@FindBy(xpath="//button[text()=' Delete Selected ']")
	public WebElement deletedSelected;
	
	@FindBy(xpath="//button[text()=' Yes, Delete ']")
	public WebElement confirmDelete;
	
	@FindBy(xpath="//button[text()=' Search ']")
	public WebElement empSearch;
	
	
public PIMPage() {
		
		PageFactory.initElements(driver, this);
	}


public void AddEmployee() throws InterruptedException, IOException {
	addEmployeeBtn.click();
	Utility.waitUntilElement(driver, addEmployeeBtn);
	addEmployeeBtn.click();
	Utility.waitUntilElement(driver, empFirstName);
	empFirstName.sendKeys("reenu");
	empLastName.sendKeys("Desai");
	createLoginDetails.click();
	Utility.waitUntilElement(driver, empUserName);
	Thread.sleep(5000);
	empUserName.sendKeys("rdesai");
	empPassword.sendKeys("Reenu123");
	empConfirmPassword.sendKeys("Reenu123");
	empSave.click();
	Thread.sleep(7000);
}

public void DeleteEmployee() throws InterruptedException, IOException {
	for(int r=1; r<7;r++) {
	ArrayList<String> arr = util.getEmployeeDetails(0, r);
	Utility.waitUntilElement(driver, employeeList);
	employeeList.click();
	Thread.sleep(2000);
	empName.sendKeys(arr.get(0));
	empSearch.click();
	Utility.waitUntilElement(driver, empRow);
	empRow.click();
	deletedSelected.click();
	confirmDelete.click();
	Thread.sleep(3000);
	}
}


public void enterEmployeeDetails() throws InterruptedException, IOException {
	
	
	for(int r=1; r<7;r++) {
	ArrayList<String> arr = util.getEmployeeDetails(0, r);
	System.out.println("Sheetname is "+ util.getSheetName(0));
	Utility.waitUntilElement(driver, addEmployeeBtn);
	addEmployeeBtn.click();
	Utility.waitUntilElement(driver, empFirstName);
	empFirstName.sendKeys(arr.get(0));
	empLastName.sendKeys(arr.get(1));
	createLoginDetails.click();
	Utility.waitUntilElement(driver, empUserName);
	Thread.sleep(5000);
	empUserName.sendKeys(arr.get(3));
	empPassword.sendKeys(arr.get(4));
	empConfirmPassword.sendKeys(arr.get(4));
	empSave.click();
	Thread.sleep(5000);
	System.out.println("Entered details of "+ arr.get(0)+ "Successfully");
	}
}



}
