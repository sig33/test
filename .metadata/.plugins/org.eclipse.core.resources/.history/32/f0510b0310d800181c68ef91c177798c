package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();
	
	//getBuyItemInfoメソッド
	public BuyItemDTO getBuyItemInfo(){
		
		String sql = "SELECT id, item_name, item_price FROM item_info_transaction";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			//SQL文を実行する
			ResultSet resultSet = preparedStatement.executeQuery();
			
			////select文でDBから取得した情報をDTOクラスに格納する
			if(resultSet.next()){
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		//ActionクラスにDTOクラスを返します
		return buyItemDTO;
	}
	public BuyItemDTO getBuyItemDTO(){
		return buyItemDTO;
	}
}
