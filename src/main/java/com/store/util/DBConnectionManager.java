package com.store.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

	private Connection connection;
	
	public DBConnectionManager(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException{//, String user, String pwd
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(dbURL,user, pwd);//,user, pwd
	}
	
	public Connection getConnection(){
		return this.connection;
	}
}
