/**
 * 
 */
package com.API_Automation.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author ravindrs
 *
 */
public class TC002_POST_Request {
	
	@Test
	public void postUserDetails() {
		//specify base URI
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
		//requestParam.put("username", "xyz");
		requestParam.put("email", "eve.holt@reqres.in");
		requestParam.put("password", "pistol");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		
		//Response object
		Response response = httpRequest.request(Method.POST, "/register");
		
		//Printing response body
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :"+responseBody);
		
		//Capturing specific header
		String headerContentType = response.header("Content-type");
		System.out.println("Extracted header content type : "+headerContentType);
		
		//Capturing all Headers
		Headers allHeader=response.headers();
		
		for(Header header:allHeader) {
			System.out.println(header.getName()+"    "+header.getValue());
			//System.out.println(header.getValue());
			
		}
		
		//Data from body
		String responseToken =response.jsonPath().get("token");
		System.out.println("Extracted body value token: "+responseToken);
		
		//Extracting all data from body
		
		JsonPath jsonData = response.jsonPath();
		System.out.println("ID extracted : "+ jsonData.get("id")); 
		
		//Getting status code
		int responseStatus = response.getStatusCode();
		System.out.println("Status Code :"+responseStatus);
		Assert.assertEquals(responseStatus, 200);
		
		//Status line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status line : "+statusLine); 
		
	}

}
