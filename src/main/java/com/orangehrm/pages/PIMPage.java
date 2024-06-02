package com.orangehrm.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BasePage;
import com.orangehrm.utils.Utility;

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
    empId.sendKeys("54657");
	createLoginDetails.click();
	Utility.waitUntilElement(driver, empUserName);
	Thread.sleep(2000);
	empUserName.sendKeys("rdesai");
	empPassword.sendKeys("Reenu123");
	empConfirmPassword.sendKeys("Reenu123");
	empSave.click();
	Thread.sleep(3000);
}

public void DeleteEmployee() throws InterruptedException, IOException {
	
	Utility.waitUntilElement(driver, employeeList);
	employeeList.click();
	Thread.sleep(2000);
	empName.sendKeys("reenu");
	empSearch.click();
	Utility.waitUntilElement(driver, empRow);
	empRow.click();
	deletedSelected.click();
	confirmDelete.click();
	Thread.sleep(3000);
	
}
public void DeleteEmployeeExcel() throws InterruptedException, IOException {
	for(int r=1; r<7;r++) {
	ArrayList<String> arr = util.getEmployeeDetailsExcel(0, r);
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


public void enterEmployeeDetailsExcel() throws InterruptedException, IOException {
	
	
	for(int r=1; r<7;r++) {
	ArrayList<String> arr = util.getEmployeeDetailsExcel(0, r);
	System.out.println("Sheetname is "+ util.getSheetName(0));
	Utility.waitUntilElement(driver, addEmployeeBtn);
	addEmployeeBtn.click();
	Utility.waitUntilElement(driver, empFirstName);
	empFirstName.sendKeys(arr.get(0));
	empLastName.sendKeys(arr.get(1));
	empId.sendKeys(arr.get(2));
	createLoginDetails.click();
	Utility.waitUntilElement(driver, empUserName);
	Thread.sleep(2000);
	empUserName.sendKeys(arr.get(3));
	empPassword.sendKeys(arr.get(4));
	empConfirmPassword.sendKeys(arr.get(4));
	empSave.click();
	Thread.sleep(2000);
	System.out.println("Entered details of "+ arr.get(0)+ " Successfully");
	}
}


public void AddEmployeesFromDatabase() throws InterruptedException, IOException {
    // Fetch employee details from the database
    Map<Integer, Map<String, String>> employeeDetails = util.fetchEmployeeDetailsDatabase(6);

    // Iterate over each employee entry
    for (Map.Entry<Integer, Map<String, String>> entry : employeeDetails.entrySet()) {
        Map<String, String> employeeData = entry.getValue();

        // Add employee using the retrieved data
        Utility.waitUntilElement(driver, addEmployeeBtn);
        addEmployeeBtn.click();
        Utility.waitUntilElement(driver, empFirstName);

        // Fill form fields with employee details
        empFirstName.sendKeys(employeeData.get("FirstName"));
        empLastName.sendKeys(employeeData.get("LastName"));
        empId.sendKeys(employeeData.get("EmployeeId"));
        createLoginDetails.click();
        Utility.waitUntilElement(driver, empUserName);
        Thread.sleep(2000);
        empUserName.sendKeys(employeeData.get("UserName"));
        empPassword.sendKeys(employeeData.get("Pwd"));
        empConfirmPassword.sendKeys(employeeData.get("Pwd")); // Assuming password confirmation is same as password
        empSave.click();
        Thread.sleep(3000);
    }

}

public void addEmployeesDataProvider(List<ArrayList<String>> data) throws InterruptedException {
	
		int count = data.size();
		for(int r=0; r<count; r++) {
			ArrayList<String> onerowdata = data.get(r);
//			System.out.println("One row size is "+ onerowdata.size());
//			for(int i=0; i<onerowdata.size(); i++) {
//			System.out.println(onerowdata.get(i));
//			
//			}
			addEmployeeBtn.click();
			Utility.waitUntilElement(driver, addEmployeeBtn);
			addEmployeeBtn.click();
			Utility.waitUntilElement(driver, empFirstName);
			empFirstName.sendKeys(onerowdata.get(0));
			empLastName.sendKeys(onerowdata.get(1));
	        empId.sendKeys(onerowdata.get(2));
			createLoginDetails.click();
			Utility.waitUntilElement(driver, empUserName);
			Thread.sleep(2000);
			empUserName.sendKeys(onerowdata.get(3));
			empPassword.sendKeys(onerowdata.get(4));
			empConfirmPassword.sendKeys(onerowdata.get(4));
			empSave.click();
			Thread.sleep(3000);
			
		
	
	}
}
}
