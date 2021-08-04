package com.api.setUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.api.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {
	 

	 public static Properties config= new Properties();
	 private static FileInputStream fis ;
	 public static  ExcelReader excel= new ExcelReader(".\\src\\test\\java\\com\\api\\resources\\testdata.xlsx");
	 @BeforeSuite
	public void setup(){
		 RestAssured.basePath="/v1";
	     RestAssured.baseURI="https://api.stripe.com";
		   try {
			fis= new FileInputStream(".\\src\\test\\java\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		   try {
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		     RestAssured.basePath= config.getProperty("basePath");
	         RestAssured.baseURI=config.getProperty("baseURI");
	}
	
	
	public void tearDown(){
		
	   
}

}
