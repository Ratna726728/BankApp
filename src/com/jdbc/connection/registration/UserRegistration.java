package com.jdbc.connection.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.connection.DatabaseConnection;

public class UserRegistration {
	Connection connection = null;
	PreparedStatement preparedStatement = null;

	public void registrationUserInsert(String firstName, String surname, int age, String email, String contactNumber,
			String accountNumber, String address, String userId, String branchName, double balance) throws SQLException {

		try {
			DatabaseConnection databaseConnection = new DatabaseConnection();
			connection = databaseConnection.getConnection();
			preparedStatement = connection.prepareStatement(
					"insert into user_registation(firstName, surname, age, email, contactNumber, accountNumber, address, userId, branchName, balance)values(?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, surname);
			preparedStatement.setInt(3, age);
			preparedStatement.setString(4, email);
			preparedStatement.setString(5, contactNumber);
			preparedStatement.setString(6, accountNumber);
			preparedStatement.setString(7, address);
			preparedStatement.setString(8, userId);
			preparedStatement.setString(9, branchName);
			preparedStatement.setDouble(10, balance);
			
			int a = preparedStatement.executeUpdate();
			System.out.println("Record is updated");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
			preparedStatement.close();

		}
	}

}
