package com.orangehrm.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BasePage;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage;
import com.orangehrm.utils.Utility;




public class LoginPageTest extends BasePage
{
	LoginPage loginPage;
	DashboardPage dbPage;
	PIMPage pimPage;

    @BeforeMethod
	public void setUp() throws InterruptedException
	{
		navigatetoLoginPage();
		loginPage = new LoginPage();
		dbPage = new DashboardPage();
		pimPage = new PIMPage();
	}
    
    @Test(priority=1, description="Verifying loginpage test", groups = {"uitests"}, enabled = false)
	public void ValidateLogin() throws InterruptedException, IOException
	{
		loginPage.login("Admin", "admin123");
	}
	
	@Test(priority=2, description="Adding Single employee details", groups = {"uitests"}, enabled = false)
	public void AddEmployee() throws InterruptedException, IOException
	{
		loginPage.login("Admin", "admin123");
		dbPage.ClickOnPimModule();
		pimPage.AddEmployee();
		pimPage.DeleteEmployee();
	}

	@Test(priority=3, description="Adding Employees details from excel sheet using java", groups = {"uitests"}, enabled = false)
	public void AddEmployeesExcel() throws InterruptedException, IOException
	{
		loginPage.login("Admin", "admin123");
		dbPage.ClickOnPimModule();
		pimPage.enterEmployeeDetailsExcel();
		pimPage.DeleteEmployeeExcel();
	}
	

	@Test(priority=4, description="Adding Employees details from Database sql server", groups = {"uitests"}, enabled = false)
	public void AddEmployeesSql() throws InterruptedException, IOException
	{
		loginPage.login("Admin", "admin123");
		dbPage.ClickOnPimModule();
		pimPage.AddEmployeesFromDatabase();
		pimPage.DeleteEmployeeExcel();
	}
	
	@Test(priority=5, description="Adding Employees details from excel sheet using Testng DataProvider", groups = {"uitests"}, enabled = true ,
	dataProvider = "ExcelData", dataProviderClass = Utility.class)
	public void AddEmployeesDataProvider(List<ArrayList<String>> data) throws InterruptedException, IOException
	{
		loginPage.login("Admin", "admin123");
		dbPage.ClickOnPimModule();
		pimPage.addEmployeesDataProvider(data);
		pimPage.DeleteEmployeeExcel();
	}
	

	
	@AfterMethod
	public void teardown()
	{if (driver != null) {
        driver.quit();
    }
	}
    
}
