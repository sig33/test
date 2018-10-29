package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemListDeleteCompleteAction extends ActionSupport {
	
	private ItemListDeleteCompleteDAO itemListDeleteCompleteDAO = new ItemListDeleteCompleteDAO();
	private String message;
	
	public String execute() throws SQLException{
		
		delete();
		
		return SUCCESS;
	}
	
	//アイテムの削除を行うためのメソッド
	public void delete() throws SQLException{
		
		//DBから削除したアイテム情報の件数をresに格納している
		int res = itemListDeleteCompleteDAO.itemListDelete();
		
		//1件以上削除されたか否かで正常に削除処理がされたか判別している
		if(res > 0){
			setMessage("商品情報を正しく削除しました。");
			
		}else if(res == 0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
}
