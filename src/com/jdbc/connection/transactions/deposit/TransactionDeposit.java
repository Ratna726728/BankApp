package com.jdbc.connection.transactions.deposit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.connection.DatabaseConnection;

public class TransactionDeposit extends DatabaseConnection{

	public void amountDeposit(String accountNumber, double amount) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement("UPDATE user_registation SET balance = balance + ? WHERE accountNumber = ?");
			
			preparedStatement.setDouble(1, amount);
			preparedStatement.setString(2, accountNumber);
			
			int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Amount Deposited");
            }
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
			preparedStatement.close();
			
		}
		
	}

}
