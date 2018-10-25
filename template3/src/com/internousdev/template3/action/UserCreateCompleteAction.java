package com.internousdev.template3.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template3.dao.UserCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

//→userCreateComplete.jsp
public class UserCreateCompleteAction extends ActionSupport implements SessionAware{
	
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String, Object> session;
	
	//executeメソッド
	//throws→例外が発生した場合、呼ばれる側に例外を投げる
	public String execute() throws SQLException{
		
		//DAOを経由して入力された内容をDBに登録する
		UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();
		userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),
				session.get("loginPassword").toString(),
				session.get("userName").toString());
		
		String result = SUCCESS;
		
		return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
