package com.data.yaml;

public class YamlTestDataForAPI5 extends TestData{
	String albumId;

	public String getalbumId() {
		return albumId;
	}

	public void setalbumId(String albumId) {
		this.albumId = albumId;
	}

	@Override
	public String toString() {
		return "YamlTestDataForAPI2 [albumId=" + albumId + "]";
	}
}
