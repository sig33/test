package com.internousdev.template3.action;

import com.opensymphony.xwork2.ActionSupport;

//→login.jsp
public class HomeAction extends ActionSupport{
	
	//executeメソッド
	//実行するとSUCCESSが返される
	public String execute(){
		return SUCCESS;
	}
}
