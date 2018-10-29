package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	
	//DBからユーザー情報を取得するためのメソッド
	public ArrayList<UserListDTO> getUserListInfo() throws SQLException{
		
		ArrayList<UserListDTO> userListDTO = new ArrayList<UserListDTO>();
		
		String sql = "SELECT id, login_id, login_pass, user_name, insert_date FROM login_user_transaction WHERE id >= ?";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			//取得した結果を1件ずつDTOに格納し、更にDTOをArrayListに格納している。
			while(resultSet.next()){
				
				UserListDTO dto = new UserListDTO();
				dto.setId(resultSet.getString("id"));
				dto.setLoginId(resultSet.getString("login_id"));
				dto.setLoginPass(resultSet.getString("login_pass"));
				dto.setUserName(resultSet.getString("user_name"));                         
				dto.setInsert_date(resultSet.getString("insert_date"));
				userListDTO.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			connection.close();
		}
		return userListDTO;
	}
}
