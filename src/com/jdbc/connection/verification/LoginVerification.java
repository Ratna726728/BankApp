package com.jdbc.connection.verification;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.connection.DatabaseConnection;

public class LoginVerification extends DatabaseConnection{
	
	public void userDatabaseAvailabilityChecker(String accountNumber, String userId) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection=super.getConnection();
			preparedStatement = connection.prepareStatement("select accountNumber, userId from user_registation where accountNumber=? and userId=?");
			preparedStatement.setString(1, accountNumber);
			preparedStatement.setString(2, userId);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
                System.out.println("Verification successful!!!!");
            } else {
                System.out.println("Invalid accountNumber or userId");
            }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			preparedStatement.close();
			resultSet.close();
		}
	}

}
