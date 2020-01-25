package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.businesslayer.SinglePhotoBusinessLogic;
import com.businesslayer.UserBusinessLogic;
import com.data.DataProviderClass;
import com.data.yaml.YamlTestDataForCommentsAPI;
import com.data.yaml.YamlTestDataForUsersAPI1;
import com.data.yaml.YamlTestDataForUsersAPI2;
import com.pojos.SinglePhoto;
import com.pojos.SingleUser;

import org.apache.log4j.Logger;

/**
 * This class contains all the test cases related to API1 i.e. SinglePhoto API
 * We are separating test cases so that they will be easy to manage
 * 
 * @author 
 */
public class UserTestCases {

	private static final Logger LOGGER = Logger.getLogger(UserTestCases.class);
	
	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class)
	public void testValidateUserNotExist(YamlTestDataForUsersAPI2 apitestdata) {
		
		String userId = apitestdata.getUserId();
		SingleUser singleUser = UserBusinessLogic.getSingleuserDataFor(userId);
		LOGGER.info("UserID - " + userId);

		if(singleUser==null){
			LOGGER.info("No Users Found.");	
		}
	}
	
	
	
	
	/*
	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class)
	public void testSingleUserCase1(YamlTestDataForUsersAPI1 apitestdata) {
		String username = apitestdata.getUser();
		SingleUser singleUserActualData = SingleUserBusinessLogic.getSingleuserDataFor(username);
		LOGGER.info(username);

		Assert.assertEquals(singleUserActualData.getUsername(), username);
		
		System.out.println("Id for the user Samantha -" +singleUserActualData.getId());
	}
	*/
}
