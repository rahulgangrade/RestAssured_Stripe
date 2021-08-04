package com.api.apis;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.api.setUp.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest{
	
	
	
	public static Response sendPostRequestToCreateCustomerwithValidAuthKey(Hashtable<String, String> data) {
	 
	 Response response = given().auth().basic(config.getProperty("validSecretKey"), "").
			formParam("name", data.get("name")).
			formParam("description", data.get("description")).
			formParam("email", data.get("email")).
			log().all().
			post(config.getProperty("customerAPIEndPoint"));

  return response;
	
	}
	
	
	public static Response sendPostRequestToCreateCustomerwithInValidAuthKey(Hashtable<String, String> data)
	{
	Response response =	given().auth().basic("JUNK"+ config.getProperty("secretKey"), "").
			formParam("name", data.get("name")).
			formParam("description", data.get("description")).
			formParam("email", data.get("email")).
			log().all().
			post(config.getProperty("customerAPIEndPoint"));
	return response;
}
}