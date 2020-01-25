package com.testcases;

import org.testng.annotations.Test;

import com.businesslayer.PostsBusinessLogic;
import com.data.DataProviderClass;
import com.data.yaml.YamlTestDataForPostsAPI1;
import com.pojos.SinglePost;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;

/**
 * This class contains all the test cases related to API1 i.e. SinglePhoto API
 * We are separating test cases so that they will be easy to manage
 * 
 * @author 
 */
public class PostsTestCases {

	private static final Logger LOGGER = Logger.getLogger(PostsTestCases.class);
	
	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class)
	public void testValidatePostNotExist(YamlTestDataForPostsAPI1 apitestdata) {
		
		int postId = apitestdata.getPostId();
		SinglePost singlePost = PostsBusinessLogic.getSinglePostDataFor(postId);
		LOGGER.info("postId - " + postId);

		assertEquals(singlePost, null, "Assertion Failed");		
		
		//if(singlePost==null){
		//	LOGGER.info("No Posts Found.");	
		//}
		//
	    //LOGGER.error("Posts not expected");
	}
}
