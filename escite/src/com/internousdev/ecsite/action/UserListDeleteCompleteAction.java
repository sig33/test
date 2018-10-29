package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class UserListDeleteCompleteAction extends ActionSupport {
	
	private UserListDeleteCompleteDAO userListDeleteCompleteDAO = new UserListDeleteCompleteDAO();
	private String message;
	
	public String execute() throws SQLException{
		
		delete();
		
		return SUCCESS;
	}
	
	//ユーザーの削除を行うためのメソッド
	public void delete() throws SQLException{
		
		//DBから削除したユーザー情報の件数をresに格納している
		int res = userListDeleteCompleteDAO.userListDelete();
		
		//1件以上削除されたか否かで正常に削除処理がされたか判別している
		if(res > 0){
			setMessage("ユーザー情報を正しく削除しました。");
			
		}else if(res == 0){
			setMessage("ユーザー情報の削除に失敗しました。");
		}
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
}
