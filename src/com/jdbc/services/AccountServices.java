package com.jdbc.services;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.connection.balacechecker.CheckBalance;
import com.jdbc.connection.registration.UserRegistration;
import com.jdbc.connection.transactions.deposit.TransactionDeposit;
import com.jdbc.connection.transactions.withdraw.TransactionWithdraw;
import com.jdbc.connection.verification.LoginVerification;
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

		System.out.println("Enter the amount you want to deposit at the time of account cration: ");
		double amount = scanner.nextDouble();

		userRegistration.registrationUserInsert(firstName, surname, age, email, contactNumber, accountNumber, address,
				userId, branchName, amount);
		// save the data to the db
		System.out.println("User registration completed!!!");
	}

	public void deposit() throws SQLException {
		// objects used in deposit method
		Scanner scanner = new Scanner(System.in);
		LoginVerification loginVerification = new LoginVerification();
		CheckBalance checkBalance = new CheckBalance();
		TransactionDeposit transactionDeposit = new TransactionDeposit();

		// ask user details
		System.out.print("Enter the account Number: ");
		String accountNumber = scanner.next();
		System.out.print("Enter the user ID: ");
		String userId = scanner.next();
		System.out.print("Enter the amount you want to deposit: ");
		double amount = scanner.nextDouble();
		// check the details if it is register in database
		loginVerification.userDatabaseAvailabilityChecker(accountNumber, userId);
		// to deposit new amount into the balance
		transactionDeposit.amountDeposit(accountNumber, amount);
		// check user balance
		checkBalance.userBalance(accountNumber, userId);
	}

	public void withdraw() throws SQLException {
		// objects used in deposit method
		Scanner scanner = new Scanner(System.in);
		LoginVerification loginVerification = new LoginVerification();
		CheckBalance checkBalance = new CheckBalance();
		TransactionWithdraw transactionWithdraw = new TransactionWithdraw();

		// ask user details
		System.out.print("Enter the account Number: ");
		String accountNumber = scanner.next();
		System.out.print("Enter the user ID: ");
		String userId = scanner.next();
		System.out.print("Enter the amount you want to deposit: ");
		double amount = scanner.nextDouble();
		// check the details if it is register in database
		loginVerification.userDatabaseAvailabilityChecker(accountNumber, userId);
		// to deposit new amount into the balance
		transactionWithdraw.amountWithdraw(accountNumber, amount);
		// check user balance
		checkBalance.userBalance(accountNumber, userId);

	}

	public void checkBalance() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		CheckBalance checkBalance = new CheckBalance();
		// ask user details
		System.out.print("Enter the account Number: ");
		String accountNumber = scanner.next();
		System.out.print("Enter the user ID: ");
		String userId = scanner.next();

		// connect to db and check the
		checkBalance.userBalance(accountNumber, userId);

	}

}
