package com.internousdev.template3.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

//success→userCreateConfirm.jsp error→userCreate.jsp
public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	
	private String loginUserId;
	private String loginPassword;
	private String userName;
	public Map<String, Object> session;
	private String errorMessage;
	
	//executeメソッド
	public String execute(){
		
		String result = SUCCESS;
		
		//未入力項目の有無を確認している
		//if→それぞれの値がnullでない場合(全部記入されている場合)
		//確認場面で表示したい値をセッションに格納する
		if(!(loginUserId.equals(""))
			&& !(loginPassword.equals(""))
			&& !(userName.equals(""))){
			
			//(    " key "    ,    value    );
			//valueはhtmlのvalueと一緒
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
			
		}else{
			//未入力があった場合エラーメッセージ表示
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		
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
	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
}
