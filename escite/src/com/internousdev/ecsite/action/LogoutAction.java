package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//<result name="success">home.jsp
public class LogoutAction extends ActionSupport implements SessionAware{
	
	public Map<String, Object> session;
	
	public String execute(){
		session.clear();
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
