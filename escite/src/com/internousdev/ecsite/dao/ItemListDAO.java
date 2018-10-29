package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	
	//DBから商品情報を取得するためのメソッド
	public ArrayList<ItemListDTO> getItemListInfo() throws SQLException{
		
		ArrayList<ItemListDTO> itemListDTO = new ArrayList<ItemListDTO>();
		
		String sql = "SELECT id, item_name, item_price, item_stock, insert_date FROM item_info_transaction WHERE item_stock >= ?";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 0);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//取得した結果を1件ずつDTOに格納し、更にDTOをArrayListに格納している。
			while(resultSet.next()){
				
				ItemListDTO dto = new ItemListDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));                         
				dto.setInsert_date(resultSet.getString("insert_date"));
				itemListDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			connection.close();
		}
		return itemListDTO;
	}
}
