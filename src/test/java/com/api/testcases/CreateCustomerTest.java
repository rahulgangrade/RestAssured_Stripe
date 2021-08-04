package com.api.testcases;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.api.apis.CreateCustomerAPI.*;

import com.api.listeners.ExtentListeners;
import com.api.setUp.BaseTest;
import com.api.utilities.DataUtil;
import com.api.utilities.ExcelReader;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Unit test for simple App.
 */
public class CreateCustomerTest extends BaseTest

{
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="getData")
	public void validatecustomerPositive(Hashtable<String, String> data)
	{   	
		
         
		 Response response = sendPostRequestToCreateCustomerwithValidAuthKey(data);
		    	response.prettyPrint();
		 //  ExtentListeners.testReport.get().info(data.toString()); 	
		    	
			   assertEquals(200, response.getStatusCode());
	}

	@Test(dataProviderClass=DataUtil.class,dataProvider="getData")
	public void validatecustomerNegative(Hashtable<String, String> data)
	{
		
		Response response =	sendPostRequestToCreateCustomerwithInValidAuthKey(data);
	//	ExtentListeners.testReport.get().info(data.toString()); 	
		response.prettyPrint();
		assertEquals(401, response.getStatusCode());
	}
	
	
	
}
