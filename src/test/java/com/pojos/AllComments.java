package com.pojos;

import java.util.List;

/**
 * POJOs for API Response   http://<domain>/comment
 * http://jsonplaceholder.typicode.com/comment
 * 
 * POJOs required to have actual representations of our particular API's response
 * 
 * @author 
 */
public class AllComments {

	List<SingleComment> listOfComments;

	public List<SingleComment> getListOfcomments() {
		return listOfComments;
	}

	public void setListOfcomments(List<SingleComment> listOfComments) {
		this.listOfComments = listOfComments;
	}

	@Override
	public String toString() {
		return "AllComments [listOfComments=" + listOfComments + "]";
	}

}
