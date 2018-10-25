package com.internousdev.template3.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/ecsite";
	private static String user = "root";
	private static String password = "mysql";
	
	//getConnectionメソッド
	public Connection getConnection(){
		
		//Connection型のconに初期値を設定
		Connection con = null;
		
		try{
			Class.forName(driverName);
			con = (Connection) DriverManager.getConnection(url,user,password);
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		//MySQLに接続できたか情報を渡す
		return con;
	}
}
