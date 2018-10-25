package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

//<result name="success">userCreate.jsp
//<result name="back">login.jsp
public class UserCreateAction extends ActionSupport{
	
	public String execute(){
		return SUCCESS;
	}
}
