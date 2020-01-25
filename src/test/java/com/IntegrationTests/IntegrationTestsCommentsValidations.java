package com.IntegrationTests;

import com.Util.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.businesslayer.AllCommentssBusinessLogic;
import com.businesslayer.PostsBusinessLogic;
import com.businesslayer.SinglePhotoBusinessLogic;
import com.businesslayer.UserBusinessLogic;
import com.data.DataProviderClass;
import com.data.yaml.YamlTestDataForUsersAPI1;
import com.pojos.AllComments;
import com.pojos.AllPosts;
import com.pojos.SinglePhoto;
import com.pojos.SinglePost;
import com.pojos.SingleUser;

import java.util.Iterator;
import java.util.List;

import org.apache.http.client.params.AllClientPNames;
import org.apache.log4j.Logger;
import org.hamcrest.core.IsNull;

/**
 * This class contains all the test cases related to API1 i.e. SinglePhoto API
 * We are separating test cases so that they will be easy to manage
 * 
 * @author Sheetal Singh
 */
public class IntegrationTestsCommentsValidations {

	private static final Logger LOGGER = Logger.getLogger(IntegrationTestsCommentsValidations.class);

	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class)
	public void testValidateCommentsEmailByUserName(YamlTestDataForUsersAPI1 apitestdata) {

		String userName = apitestdata.getUser();		
		
		System.out.println("UserName : "+userName);
		SingleUser singleUser = UserBusinessLogic.getSingleuserDataFor(userName);
		
		//Process further if non-empty results - User Found
		if(singleUser!=null){			
			int userId=singleUser.getId();
			
			LOGGER.info(singleUser);
			LOGGER.info(userId);
			
			System.out.println("UserId - " + userId);
			
			List<Integer> postIds = PostsBusinessLogic.getListOfPostIdsFromUserId(userId);		
			System.out.println("postIds - " + postIds);
			
			if(postIds!=null){
				
				Iterator<Integer> postIdIterator = postIds.iterator();
				
				while (postIdIterator.hasNext()) {
					int tempPostId=postIdIterator.next();												
					
					List<String> emailIds = AllCommentssBusinessLogic.getListOfEmailIdsFromPostId(tempPostId);
					System.out.println("emailIds - " + emailIds);
					
					if(emailIds!=null){					
						Iterator<String> emailIterator = emailIds.iterator();
						while (emailIterator.hasNext()) {
							//Validate Email						
							CommonFunctions commonFun=new CommonFunctions();
							boolean isEmailValid = commonFun.validateEmailApache(emailIterator.next());
							if(isEmailValid){
								System.out.println("Email Address is Valid");
							}
							else
								System.out.println("Email Address is not Valid");
							//Logging for Validation
						}
					}
				}	
			}
		}
		final String dir = System.getProperty("user.dir");
        	System.out.println("current dir = " + dir);
	}	
}
