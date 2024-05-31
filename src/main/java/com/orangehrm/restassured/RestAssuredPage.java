package com.orangehrm.restassured;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredPage {

	
	
	
	public void GetApi() {
		
		String URI = "https://reqres.in/api/users/2";
		
		//String token = "13779f35d3cc4108a0cf41ef417d183f";
		Response response =  RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).when().get(URI).then().extract().response();
        String responseBody = response.getBody().asString();
        System.out.println("Get Response Body is "+ responseBody);
		 
		int statuscode = response.statusCode();
		 
		 JsonPath js = new JsonPath(responseBody);
		 
		 Assert.assertEquals(statuscode, 200);;

	}
	
	public void PostApi() {
		
		String URI = "https://reqres.in/api/users/";
		String body = "{\n"
				+ "    \"name\":\"morpheus\",\n"
				+ "    \"job\":\"leader\"\n"
				+ "}";
		Response response = RestAssured.given().headers("Content-Type", ContentType.JSON).body(body).when().post(URI).then().extract().response();
		
		String responsebody = response.getBody().asString();
		System.out.println("Post Response Body is "+ responsebody);
		int statuscode = response.getStatusCode();
		
		JsonPath js = new JsonPath(responsebody);
		Assert.assertEquals(statuscode, 201);
		
		JSONObject inputbody = new JSONObject();
		inputbody.put("name", "morpheus");
		inputbody.put("job", "leader");
		
		
		
		
	}
	
public void PutApi() {
		
		String URI = "https://reqres.in/api/users/3";
		String body = "{\n"
				+ "    \"name\":\"Jane\",\n"
				+ "    \"job\":\"Janitor\"\n"
				+ "}";
		Response response = RestAssured.given().headers("Content-Type", ContentType.JSON).when().body(body).put(URI).then().extract().response();
		
		String responsebody = response.getBody().asString();
		System.out.println("Put Response Body is "+ responsebody);
		int statuscode = response.getStatusCode();
		
		JsonPath js = new JsonPath(responsebody);
		Assert.assertEquals(statuscode, 200);
		
	}
	
}
