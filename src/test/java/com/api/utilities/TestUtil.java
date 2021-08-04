package com.api.utilities;

import static org.testng.Assert.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;

import io.restassured.response.Response;

public class TestUtil {

	
	
	
	public static Boolean jsonHasKey(String  response, String key) throws JSONException {
		
		   JSONObject jsonObj= new JSONObject(response);
		   Boolean jsonValue= jsonObj.has(key);
		    return jsonValue;
	}
	
	
	
	public static String getJsonKeyValue(String response, String key) throws JSONException {
		   JSONObject jsonObj= new JSONObject(response);
		   String jsonValue= jsonObj.getString(key).toString();
		return jsonValue;
		   
	}
}
