package com.internousdev.template3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template3.dto.LoginDTO;
import com.internousdev.template3.util.DBConnector;

public class LoginDAO {
	
	//LoginDTO型のgetLoginUserInfoメソッド(LoginDTOの結果を返す必要がある)
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword){
		
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		LoginDTO loginDTO = new LoginDTO();
		
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				//login_id,login_pass,user_nameはsqlのカラム名
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				
				//login_idがnullではない場合
				if(!(resultSet.getString("login_id").equals(null))){
					
					//loginFlgにtrueを代入する
					loginDTO.setLoginFlg(true);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//loginDTOの値を呼び出し元に返す
		return loginDTO;
		
	}
}
