package com.pojos;

import java.util.List;

/**
 * POJOs for API Response   http://<domain>/photos
 * http://jsonplaceholder.typicode.com/photos
 * 
 * POJOs required to have actual representations of our particular API's response
 * 
 * @author 
 */
public class AllUsers {

	List<SingleUser> listOfUsers;

	public List<SingleUser> getListOfUsers() {
		return listOfUsers;
	}

	public void setListOfUsers(List<SingleUser> listOfUsers) {
		this.listOfUsers = listOfUsers;
	}

	@Override
	public String toString() {
		return "AllUsers [listOfUsers=" + listOfUsers + "]";
	}

}
