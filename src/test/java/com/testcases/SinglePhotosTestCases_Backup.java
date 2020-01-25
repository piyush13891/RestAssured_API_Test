package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.businesslayer.SinglePhotoBusinessLogic;
import com.data.DataProviderClass;
import com.data.yaml.YamlTestDataForCommentsAPI;
import com.pojos.SinglePhoto;
import org.apache.log4j.Logger;

/**
 * This class contains all the test cases related to API1 i.e. SinglePhoto API
 * We are separating test cases so that they will be easy to manage
 * 
 * @author Sheetal Singh
 */
public class SinglePhotosTestCases_Backup {

	private static final Logger LOGGER = Logger.getLogger(SinglePhotosTestCases_Backup.class);

	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class)
	public void testSinglePhotoCase1(YamlTestDataForCommentsAPI apitestdata) {
		String id = apitestdata.getPhotoId();
		SinglePhoto singlePhotoActualData = SinglePhotoBusinessLogic.getSinglePhotoDataFor(id);
		LOGGER.info(singlePhotoActualData);

		Assert.assertEquals(singlePhotoActualData.getId(), id);
		Assert.assertEquals(singlePhotoActualData.getAlbumId(), "1");
		Assert.assertTrue(singlePhotoActualData.getUrl().startsWith("https://via.placeholder.com/600/"));
		Assert.assertTrue(singlePhotoActualData.getThumbnailUrl().startsWith("https://via.placeholder.com/150/"));
	}

	
	
	
	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class)
	public void testSinglePhotoCase2(YamlTestDataForCommentsAPI apitestdata) {
		String id = apitestdata.getPhotoId();
		SinglePhoto singlePhotoActualData = SinglePhotoBusinessLogic.getSinglePhotoDataFor(id);
		LOGGER.info(singlePhotoActualData);

		Assert.assertEquals(singlePhotoActualData.getId(), id);
		Assert.assertEquals(singlePhotoActualData.getAlbumId(), "7");
		Assert.assertTrue(singlePhotoActualData.getUrl().startsWith("https://via.placeholder.com/600/"));
		Assert.assertTrue(singlePhotoActualData.getThumbnailUrl().startsWith("https://via.placeholder.com/150/"));
	}

}
