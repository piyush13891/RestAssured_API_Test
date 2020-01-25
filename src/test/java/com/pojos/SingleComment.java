package com.pojos;

import java.util.HashMap;
import java.util.Map;

/**
 * POJOs for API Response   http://<domain>/comments/<id>
 * e.g. http://jsonplaceholder.typicode.com/comments/10
 * 
 * POJOs required to have actual representations of our particular API's response
 * 
 * @author 
 */

public class SingleComment {
	
	private Integer postId;
	private Integer id;
	private String name;
	private String email;
	private String body;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public Integer getPostId() {
	return postId;
	}
	
	public void setPostId(Integer postId) {
	this.postId = postId;
	}
	
	public Integer getId() {
	return id;
	}
	
	public void setId(Integer id) {
	this.id = id;
	}
	
	public String getName() {
	return name;
	}
	
	public void setName(String name) {
	this.name = name;
	}
	
	public String getEmail() {
	return email;
	}
	
	public void setEmail(String email) {
	this.email = email;
	}
	
	public String getBody() {
	return body;
	}
	
	public void setBody(String body) {
	this.body = body;
	}
	
	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}
	
	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
	}

}