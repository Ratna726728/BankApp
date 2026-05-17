package com.jdbc.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.connection.datainsertion.UserRegistration;
import com.jdbc.model.Account;

public class AccountServices extends Account {

	public void createAccount() throws SQLException {
		// object creations
		Scanner scanner = new Scanner(System.in);
		UserRegistration userRegistration = new UserRegistration();

		System.out.print("Enter the firstName: ");
		String firstName = scanner.next();
		super.setFirstName(firstName);

		System.out.print("Enter the surname: ");
		String surname = scanner.next();
		super.setSurname(surname);

		System.out.print("Please enter your age: ");
		int age = scanner.nextInt();
		super.setAge(age);

		System.out.print("Enter your email: ");
		String email = scanner.next();
		super.setEmail(email);

		System.out.print("Enter your contact Number: ");
		String contactNumber = scanner.next();
		super.setContactNumber(contactNumber);

		System.out.print("Enter your address details: ");
		String address = scanner.next();
		super.setAddress(address);

		System.out.print("Enter the Branch Name(use underscore if branch code is of two words): ");
		String branchName = scanner.next();
		super.setBranchName(branchName);

		System.out.print(
				"Create user ID(use first four letters of your firstname and \n3 letters of your surname follwed with birthyear) : ");
		String userId = scanner.next();
		super.setUserId(userId);

		System.out.println("create account number(bank employee): ");
		String accountNumber = scanner.next();
		super.setAccountNumber(accountNumber);

		userRegistration.registrationUserInsert(firstName, surname, age, email, contactNumber, accountNumber, address,
				userId, branchName);
		// save the data to the db
		System.out.println("User registration completed!!!");
	}

	public void deposit() {
		// TODO Auto-generated method stub

	}

	public void withdraw() {
		// TODO Auto-generated method stub

	}

	public void checkBalance() {
		// TODO Auto-generated method stub

	}

}
