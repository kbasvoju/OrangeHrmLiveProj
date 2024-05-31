package com.orangehrm.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.base.BasePage;
import com.orangehrm.utils.Utility;

/**
 * Hello world!
 *
 */
public class LoginPage extends BasePage
{
    
public Utility util;
	
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement userName;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement loginBtn;

	@FindBy(xpath="//p[text()='Forgot your password? ']")
	public WebElement forgotPwd;
	
	@FindBy(xpath="//a[contains(@href,'viewPimModule')]")
	public WebElement pimModule;

	
	
	
	public LoginPage()
	{		
		PageFactory.initElements(driver, this);
	} 
	
	
	public void login(String uname,String pwd) throws InterruptedException
	{
		Utility.waitUntilElement(driver, userName);
		userName.sendKeys(uname);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(5000);
		
	}
	
	public void acceptAlert () 
	{
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();		
		
	}
	
	
	
	
	
	
}
