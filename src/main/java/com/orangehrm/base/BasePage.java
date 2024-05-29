package com.orangehrm.base;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.orangehrm.reports.ExtentManager;

public class BasePage {
	
	 public static WebDriver driver;
	 protected ExtentReports extent;
	   protected ExtentTest test;
		
		@BeforeSuite
	    public void setUpSuite() {
	        extent = ExtentManager.getInstance();
	    }

	    @BeforeMethod
	    public void setUp(Method method) {
	    	System.out.println("Opening the browser");
			System.out.println("//Users//keerthibasvoju//eclipse-workspace//AIAApplication//AIAApplication24//src//main//java//com//aia//qa//config//config.properties");
			 
			 driver = new ChromeDriver();
			 
			 
			 driver.manage().window().maximize();

	        // Create a test node in Extent Reports
	        test = ExtentManager.createTest(method.getName(), method.getAnnotation(Test.class).description());
	        System.out.println("Method name is "+method.getName());
	    }

	    @AfterMethod
	    public void tearDown(ITestResult result) throws IOException {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            // Capture screenshot on test failure
	            String screenshotPath = captureScreenshot(result.getName());
	            System.out.println("Screenshot path is "+screenshotPath);
	            test.fail("Test Failed: " + result.getThrowable(),
				          MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
	        } else if (result.getStatus() == ITestResult.SUCCESS) {
	            test.pass("Test passed");
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            test.skip("Test skipped");
	        }
	        // Close the WebDriver
	        if (driver != null) {
	            driver.quit();
	        }

	        // Close the WebDriver
	        driver.quit();
	    }
	    public void navigatetoLoginPage() {

	   	 String loginUrl = "https://opensource-demo.orangehrmlive.com/";

	   	driver.get(loginUrl);}
	    @AfterSuite
	    public void tearDownSuite() {
	        // Flush the Extent Reports
	        extent.flush();
	    }

	    public String captureScreenshot(String screenshotName) {
	        try {
	            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String dest = "/Users/keerthibasvoju/eclipse/LiveProjects/DemoProj/screenshots" + screenshotName + ".png";
	            File destination = new File(dest);
	            FileUtils.copyFile(source, destination);
	            return dest;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }

	    }
		
	public static void initialization() throws InterruptedException {
			
			//configSettings.initializePropertiesFile();
			System.out.println("Opening the browser");
			System.out.println("//Users//keerthibasvoju//eclipse-workspace//AIAApplication//AIAApplication24//src//main//java//com//aia//qa//config//config.properties");
			 
			 driver = new ChromeDriver();
			 
			 
			 driver.manage().window().maximize();
			 
		       
	}
	
}