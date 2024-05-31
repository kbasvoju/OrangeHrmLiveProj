package com.orangehrm.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.base.BasePage;
import com.orangehrm.pages.DashboardPage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.PIMPage;




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
	
	@Test(priority=1, description="Verifying loginpage test", groups = {"uitests"})
	public void ValidateLogin() throws InterruptedException, IOException
	{
		loginPage.login("Admin", "admin123");
		dbPage.ClickOnPimModule();
		//pimPage.AddEmployee();
		pimPage.AddEmployeesFromDatabase();
		//pimPage.enterEmployeeDetails();
		pimPage.DeleteEmployee();
	}
	

	
	@AfterMethod
	public void teardown()
	{if (driver != null) {
        driver.quit();
    }
	}
    
}
