package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static DbConnection instance;
	private static Connection connection ;
	private DbConnection(){}
	public static DbConnection getInstance(){
		if(instance ==null){
			instance = new DbConnection();
		}
		return instance;
		
	}
	public  Connection sqliteConnection() throws SQLException{
		try {
			Class.forName("org.sqlite.JDBC");
			//TODO: change the path according to company.db file
			 connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\usril\\Desktop\\springmvcgh\\src\\main\\java\\com\\dbutil\\nextgear.db");
			return connection;
			
		} catch (Exception e) {
			System.out.println("Exception :"+e);
			throw new SQLException(e);
		}
		
		
	}

}
