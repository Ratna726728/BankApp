package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

	Connection connection = null;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_account_user_details", "root",
					"Password@123");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

}
