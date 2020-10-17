package com.am.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
Connection con;
public Connection getcon() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scheme:","root","Annapoorna@1998");
		return con;
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return con;
}
}
