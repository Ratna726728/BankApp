package com.jdbc.connection.balacechecker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.connection.DatabaseConnection;

public class CheckBalance extends DatabaseConnection{
	
	public void userBalance(String accountNumber, String userId) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement("select balance from user_registation where accountNumber=? and userId=?");
			preparedStatement.setString(1, accountNumber);
			preparedStatement.setString(2, userId);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				System.out.println("Your balance is : "+resultSet.getDouble(1));
				
			}else {
				System.out.println("incorrect userId and accountNumber!!!");
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
