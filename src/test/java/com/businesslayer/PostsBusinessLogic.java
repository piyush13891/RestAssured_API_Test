package com.businesslayer;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.data.PropertyFileReader;
import com.pojos.AllPosts;
import com.pojos.SinglePost;
import com.pojos.SingleUser;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author
 */
public class PostsBusinessLogic {

	private static final Logger LOGGER = Logger.getLogger(PostsBusinessLogic.class);

	/**
	 * Fetch list of all single element nodes (like id, albumID, title, thumbnailUrl
	 * etc) from response
	 */
	
	public static List<Integer> getListOfPostIdsFromUserId(int userId) {
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("homeurl");
		String postsPath = PropertyFileReader.getPropertyData().getApis().get("posts");
		String url = baseURL + userId + "=" + userId;
		LOGGER.info("URL to be hit: " );

		
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri(baseURL);
		builder.setBasePath(postsPath);
		builder.addQueryParam("userId", userId);
		
		Response response = RestAssured.given().spec(builder.build()).get();
				
		assertEquals(response.statusCode(), 200, "Posts - Status code validation");
		//assertEquals(200, response.getStatusCode(), "Single User - Status code validation");		
		
		if(from(response.getBody().asString()).getList("$").size()==0){
			System.out.println("No Posts Found. Please validate the End Point and data."); 
		   return null;
		}
				
		//String postsResponseString = get(url).asString();
		List<Integer> listOfElements = from(response.getBody().asString()).getList("id");
		return listOfElements;
	}

	public static SinglePost getSinglePostDataFor(int postId) {
		
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("homeurl");
		String postsPath = PropertyFileReader.getPropertyData().getApis().get("posts");
		String url = baseURL + postsPath;
		LOGGER.info("URL to be hit:");
		
		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri(baseURL);
		builder.setBasePath(postsPath);
		builder.addQueryParam("id", postId);
		
		RequestSpecification spec=builder.build();
		
		spec.log().all();
		Response response=null;
		try{
			 response = RestAssured.given().spec(builder.build()).get();
		}		
		catch (Exception e) {			
			if(e instanceof java.net.UnknownHostException){
		      System.out.println("Not able to reach Host.  Please chech the URL again.");
		      fail();
		      //throw e;
			}
		}
		
		assertEquals(response.statusCode(), 200, "Single Post - Status code validation");
				
		if(from(response.getBody().asString()).getList("$").size()==0){
			System.out.println("No Post Found. Please validate the End Point and data."); 
		   return null;
		}		
			System.out.println(response.getBody().asString());
			SinglePost[] singlePost = response.getBody().as(SinglePost[].class);
			LOGGER.info("Single Post :" + singlePost);
			
		return singlePost[0];		
	}
		
	public static AllPosts getAllPostsForUserId(int userId) {
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("homeurl");
		String userIdPath = PropertyFileReader.getPropertyData().getApis().get("userId");
		String url = baseURL + userIdPath + userId;
		System.out.println("URL to be hit: " + url);

		Response response = when().get(url);
		List<SinglePost> allSinglePosts = Arrays.asList(response.getBody().as(SinglePost[].class));

		AllPosts allPosts = new AllPosts();
		allPosts.setListOfPosts(allSinglePosts);
		return allPosts;
	}

	/**
	 * Fetch list of all small json present inside main json irrespective of 
	 */
	public static AllPosts getAllPosts() {
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("homeurl");
		String posts = PropertyFileReader.getPropertyData().getApis().get("posts");
		String url = baseURL + posts;
		LOGGER.info("URL to be hit: " + url);
		Response response = when().get(url);
		List<SinglePost> allSinglePosts = Arrays.asList(response.getBody().as(SinglePost[].class));

		AllPosts allPosts = new AllPosts();
		allPosts.setListOfPosts(allSinglePosts);
		return allPosts;
	}

}
