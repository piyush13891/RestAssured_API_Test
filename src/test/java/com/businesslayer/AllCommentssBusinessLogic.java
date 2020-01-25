package com.businesslayer;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.path.json.JsonPath.from;
import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.data.PropertyFileReader;
import com.pojos.AllComments;
import com.pojos.SingleComment;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

/**
 * Business Layer : Sole purpose is to accept data and populate POJOs and
 * further perform some task related to particular domain
 * 
 * This class will contains all logic related to API http://<domain>/photos
 * 
 * @author Sheetal Singh
 * https://www.youtube.com/user/MrQwerty8080/playlists?view_as=subscriber
 */
public class AllCommentssBusinessLogic {

	private static final Logger LOGGER = Logger.getLogger(AllCommentssBusinessLogic.class);

	/**
	 * Fetch list of all single element nodes (like id, albumID, title, thumbnailUrl
	 * etc) from response
	 */
	public static List<String> getListOfEmailIdsFromPostId(int postId) {
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("homeurl");
		String commentsPath = PropertyFileReader.getPropertyData().getApis().get("comments");
		String url = baseURL + commentsPath + "=" + postId;
		LOGGER.info("URL to be hit: " + url);


		RequestSpecBuilder builder=new RequestSpecBuilder();
		builder.setBaseUri(baseURL);
		builder.setBasePath(commentsPath);
		builder.addQueryParam("postId", postId);
		
		Response response = RestAssured.given().spec(builder.build()).get();
				
		assertEquals(response.statusCode(), 200, "Comments - Status code validation");
		//assertEquals(200, response.getStatusCode(), "Single User - Status code validation");		
		
		if(from(response.getBody().asString()).getList("$").size()==0){
			System.out.println("No Comments Found. Please validate the End Point and data."); 
		   return null;
		}
				
		//String postResponseString = get(url).asString();
		List<String> listOfElements = from(response.getBody().asString()).getList("email");
		return listOfElements;
	}

	/**
	 * Fetch list of all small json set respective to particular albumID
	 */
	public static AllComments getAllPhotosForAlbumId(String postId) {
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("homeurl");
		String postIdPath = PropertyFileReader.getPropertyData().getApis().get("postId");
		String url = baseURL + postIdPath + postId;
		System.out.println("URL to be hit: " + url);

		Response response = when().get(url);
		List<SingleComment> allSingleComments = Arrays.asList(response.getBody().as(SingleComment[].class));

		AllComments allComments = new AllComments();
		allComments.setListOfcomments(allSingleComments);
		return allComments;
	}

	/**
	 * Fetch list of all small json present inside main json
	 */
	public static AllComments getAllComments() {
		String baseURL = PropertyFileReader.getPropertyData().getApis().get("homeurl");
		String comments = PropertyFileReader.getPropertyData().getApis().get("comments");
		String url = baseURL + comments;
		LOGGER.info("URL to be hit: " + url);
		Response response = when().get(url);
		List<SingleComment> allSingleComments = Arrays.asList(response.getBody().as(SingleComment[].class));

		AllComments allComments = new AllComments();
		allComments.setListOfcomments(allSingleComments);
		return allComments;
	}

}
