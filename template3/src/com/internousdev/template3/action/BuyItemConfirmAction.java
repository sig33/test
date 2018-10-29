package com.internousdev.template3.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template3.dao.BuyItemCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

//→buyItemConfirm.jsp
public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	
	//executeメソッド
	//throws→例外が発生した場合、呼ばれる側に例外を投げる
	public String execute() throws SQLException{
		
		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
		buyItemCompleteDAO.buyItemInfo(
				session.get("id").toString(),
				session.get("login_user_id").toString(),
				session.get("buyItem_price").toString(),
				session.get("stock").toString(),
				session.get("pay").toString());
		
		String result = SUCCESS;
		
		return result;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}