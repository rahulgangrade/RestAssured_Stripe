package rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import io.restassured.RestAssured;

public class TestProperties {

	
	public static void main(String[] args) throws IOException {
		
		Properties config = new Properties();
		File file = new File(".\\src\\test\\java\\config.properties");
		FileInputStream fis = new FileInputStream(file); 
		config.load(fis);
		System.out.println(config.getProperty("RestAssured.baseURI"));
	}
}
