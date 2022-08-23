/**
 * 
 */
package com.API_Automation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author ravindrs
 *
 */

@Test
public class TC003_GET_Authentication {
	
	public void autherizationTest() {
		
		RestAssured.baseURI="https://reqres.in/api"; 
		
		//Basic authentication
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName("eve.holt@reqres.in");
		authScheme.setPassword("cityslicka");
		
		RestAssured.authentication=authScheme;
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/login");
		
		//httpRequest.auth()
		 
		
		int responseStatus = response.getStatusCode();
		System.out.println("Status Code :"+responseStatus);
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body :"+responseBody);
	}

}
