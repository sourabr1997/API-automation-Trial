/**
 * 
 */
package com.API_Automation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author ravindrs
 *
 */
public class TC001_GET_Request {
	
	@Test
	public void getUserDetails() {
		//specify base URI
		RestAssured.baseURI="https://reqres.in/api";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response object
		Response response = httpRequest.request(Method.GET, "/users");
		
		//Printing response
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :"+responseBody);
		System.out.println("Actual Response Body :"+responseBody);
		
		//Getting status code
		int responseStatus = response.getStatusCode();
		System.out.println("Status Code :"+responseStatus);
		Assert.assertEquals(responseStatus, 200);
		
		//Status line verification
		
		String statusLine = response.getStatusLine();
		System.out.println("Status line : "+statusLine); 
		
	}

}
