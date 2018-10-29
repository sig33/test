package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemListDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemListAction extends ActionSupport{
	
	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemListDTO> itemListList = new ArrayList<ItemListDTO>();
	
	public String execute() throws SQLException{
		
		//DBから取得したアイテム情報をitemListListに格納している
		itemListList = itemListDAO.getItemListInfo();
			
		String result = SUCCESS;
		
		return result;
	}
	public ArrayList<ItemListDTO> getItemListList(){
		return this.itemListList;
	}
}
