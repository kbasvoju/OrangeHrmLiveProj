package com.orangehrm.pages;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BasePage;
import com.orangehrm.utils.DatabaseUtils;
import com.orangehrm.utils.Utility;

public class DashboardPage extends BasePage {

	Utility util = new Utility();
	
	@FindBy(xpath="//a[contains(@href,'viewPimModule')]")
	public WebElement pimModule;
	
	public DashboardPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnPimModule() throws InterruptedException {
		Utility.waitUntilElement(driver, pimModule);
		pimModule.click();
		Thread.sleep(5000);
		
	}
	

	
}
