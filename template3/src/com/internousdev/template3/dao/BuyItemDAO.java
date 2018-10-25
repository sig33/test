package com.internousdev.template3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template3.dto.BuyItemDTO;
import com.internousdev.template3.util.DBConnector;

public class BuyItemDAO {
	
	//BuyItemDTO型のgetBuyItemInfoメソッド(BuyItemDTOの結果を返す必要がある)
	public BuyItemDTO getBuyItemInfo(){
		
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		BuyItemDTO buyItemDTO = new BuyItemDTO();
		
		//item_info_transactinoテーブルからid, item_name, item_priceのデータを取り出している
		String sql = "SELECT id, item_name, item_price FROM item_info_transaction";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				//id,item_name,item_priceはsqlのカラム名
				buyItemDTO.setId(resultSet.getInt("id"));
				buyItemDTO.setItemName(resultSet.getString("item_name"));
				buyItemDTO.setItemPrice(resultSet.getString("item_price"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//buyItemDTOの値を呼び出し元に返す
		return buyItemDTO;
		
	}
}
