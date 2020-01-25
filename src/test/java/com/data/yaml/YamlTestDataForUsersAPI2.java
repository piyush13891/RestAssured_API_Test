package com.data.yaml;

public class YamlTestDataForUsersAPI2 extends TestData{

	String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "YamlTestDataForUsersAPI2 [userId=" + userId + "]";
	}
}
