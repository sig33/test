package com.internousdev.template3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template3.util.DBConnector;
import com.internousdev.template3.util.DateUtil;

public class UserCreateCompleteDAO {
	
	private DateUtil dateUtil = new DateUtil();
	
	//sqlにログインユーザーを登録する
	//ID、パスワード、名前、登録日時
	private String sql = "INSERT INTO login_user_transaction (login_id, login_pass, user_name, insert_date) VALUES(?,?,?,?)";
	
	//createUserメソッド
	//throws→例外が発生した場合、呼ばれる側に例外を投げる
	public void createUser(String loginUserId, String loginUserPassword, String userName)
			throws SQLException{
		
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());
			preparedStatement.execute();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			connection.close();
		}
	}
	
	

}
