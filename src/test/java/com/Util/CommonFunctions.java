package com.Util;

import org.apache.commons.validator.routines.EmailValidator;

public class CommonFunctions {
	
	public boolean validateEmailApache(String email){
		email = email.trim();
		EmailValidator v= EmailValidator.getInstance();
			
		EmailValidator eValidator = EmailValidator.getInstance();
		if(eValidator.isValid(email)){
			return true;
		}else{
			return false;
		}
	}
	
	/*
	public static void main(String[] args){
		CommonFunctions cm=new CommonFunctions();
		
		System.out.println(cm.validateEmailApache("Piyus@hgma.com"));
	
	}
	*/
}
