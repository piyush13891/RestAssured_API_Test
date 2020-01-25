package com.pojos;

import java.util.List;

/**
 * POJOs for API Response   http://<domain>/posts
 * http://jsonplaceholder.typicode.com/posts
 * 
 * POJOs required to have actual representations of our particular API's response
 * 
 * @author 
 */
public class AllPosts {

	List<SinglePost> listOfPosts;

	public List<SinglePost> getListOfPosts() {
		return listOfPosts;
	}

	public void setListOfPosts(List<SinglePost> listOfPosts) {
		this.listOfPosts = listOfPosts;
	}

	@Override
	public String toString() {
		return "AllPosts [listOfPosts=" + listOfPosts + "]";
	}

}
