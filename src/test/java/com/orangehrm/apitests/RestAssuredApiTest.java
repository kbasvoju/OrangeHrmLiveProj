package com.orangehrm.apitests;

import org.testng.annotations.Test;

import com.orangehrm.restassured.RestAssuredPage;

public class RestAssuredApiTest {
	
	RestAssuredPage restPage = new RestAssuredPage() {};
	
	
	@Test(groups = {"apitests"})
	public void VerifyGetApi() {
		
		
		restPage.GetApi();
		
	}
	
	@Test(groups = {"apitests"})
	public void VerifyPostApi() {
		
		
		restPage.PostApi();
		
	}
	
	

	@Test(groups = {"apitests"})
	public void VerifyPutApi() {
		
		
		restPage.PutApi();
		
	}
}
