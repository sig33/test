package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {
	
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	
	//DBからユーザー情報を削除するためのメソッド
	public int userListDelete() throws SQLException{
		
		String sql = "DELETE FROM login_user_transaction WHERE id >= ?";
		
		PreparedStatement preparedStatement;
		
		int result = 0;
		
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			
			result = preparedStatement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			connection.close();
		}
		//Actionクラスに削除した件数を返す
		return result;
	}
}
