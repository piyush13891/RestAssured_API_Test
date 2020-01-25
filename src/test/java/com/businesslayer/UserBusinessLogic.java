package com.businesslayer;

import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import com.data.PropertyFileReader;
import com.pojos.SingleUser;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

/**
 * Business Layer : Sole purpose is to accept data and populate POJOs and
 * further perform some task related to particular domain
 * 
 * This class will contains all logic related to API http://<domain>/photos/<id>
 * 
 * @author 
 */
public class UserBusinessLogic {
	private static final Logger LOGGER = Logger.getLogger(UserBusinessLogic.class);

	/*
	 * Extract data as Response object
	 * Populate respective Response POJOs
	 */
	public static SingleUser getSingleuserDataFor(String username) {
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("homeurl");
		String users = PropertyFileReader.getPropertyData().getApis().get("users");
		String url = baseURL + users;
		LOGGER.info("URL to be hit:" + url);
		
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri(baseURL);
		builder.setBasePath(users);
		builder.addQueryParam("username", username);
		
		Response response = RestAssured.given().spec(builder.build()).get();
				
		assertEquals(response.statusCode(), 200, "Single User - Status code validation");
		//assertEquals(200, response.getStatusCode(), "Single User - Status code validation");		
				
		if(from(response.getBody().asString()).getList("$").size()==0){
			System.out.println("No Users Found. Please validate the End Point and data."); 
		   return null;
		}		
			System.out.println(response.getBody().asString());
			SingleUser[] singleUser = response.getBody().as(SingleUser[].class);
			LOGGER.info("Single User :" + singleUser);
			
		return singleUser[0];		
	}	
	
	public static SingleUser getSingleuserDataFor(int userId) {
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("homeurl");
		String users = PropertyFileReader.getPropertyData().getApis().get("users");
		String url = baseURL + users;
		LOGGER.info("URL to be hit:" + url);
		
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri(baseURL);
		builder.setBasePath(users);
		builder.addQueryParam("id", userId);
		
		Response response = RestAssured.given().spec(builder.build()).get();
				
		assertEquals(response.statusCode(), 200, "Single User - Status code validation");
		//assertEquals(200, response.getStatusCode(), "Single User - Status code validation");		
				
		if(from(response.getBody().asString()).getList("$").size()==0){
			System.out.println("No Users Found. Please validate the End Point and data."); 
		   return null;
		}		
			System.out.println(response.getBody().asString());
			SingleUser[] singleUser = response.getBody().as(SingleUser[].class);
			LOGGER.info("Single User :" + singleUser);
			
		return singleUser[0];		
	}	
}
