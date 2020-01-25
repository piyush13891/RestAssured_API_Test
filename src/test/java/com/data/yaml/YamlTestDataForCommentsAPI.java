package com.data.yaml;

public class YamlTestDataForCommentsAPI{

	String name;

	public String getPhotoId() {
		return name;
	}

	public void setPhotoId(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "YamlTestDataForAPI1 [photoId=" + name + "]";
	}
}
