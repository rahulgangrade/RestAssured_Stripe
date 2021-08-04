package com.api.testcases;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.api.apis.CreateCustomerAPI.*;

import com.api.apis.DeleteCustomerAPI;
import com.api.listeners.ExtentListeners;
import com.api.setUp.BaseTest;
import com.api.utilities.DataUtil;
import com.api.utilities.ExcelReader;
import com.api.utilities.TestUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class DeleteCustomerTest extends BaseTest

{
	
	@Test(dataProviderClass=DataUtil.class,dataProvider="getData")
	public void DeletecustomerPositive(Hashtable<String, String> data) throws JSONException
	{   	
		
         
		 Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerwithValidAuthKey(data);
		    	response.prettyPrint();
	//	  ExtentListeners.testReport.get().info(data.toString()); 	
		    	
			   assertEquals(200, response.getStatusCode());
			   
//			  String actual_id = response.jsonPath().get("id");
//			  System.out.println("Id from the Delete response is" +actual_id);
//			  assertEquals( actual_id, data.get("id"), " Id not matching");

		   assertTrue(TestUtil.jsonHasKey(response.asString(),"id"));
		   assertTrue(TestUtil.jsonHasKey(response.asString(),"object"));
		   assertTrue(TestUtil.jsonHasKey(response.asString(),"deleted"));
		   
		   
		   assertEquals( TestUtil.getJsonKeyValue(response.asString(), "id"), data.get("id"), " Id not matching");
		   System.out.println("Value of Object is ---->" +TestUtil.getJsonKeyValue(response.asString(), "object"));
		   System.out.println("Value of deleted is ---->" +TestUtil.getJsonKeyValue(response.asString(), "deleted"));
	}

	
	@Test(dataProviderClass=DataUtil.class,dataProvider="getData")
	public void DeletecustomerNegative(Hashtable<String, String> data)
	{
		
		 Response response = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerwithInValidAuthKey(data);
	//	ExtentListeners.testReport.get().info(data.toString()); 	
		response.prettyPrint();
		assertEquals(401, response.getStatusCode());
	}
	
	
	
}
