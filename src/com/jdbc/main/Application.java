package com.jdbc.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.services.AccountServices;

public class Application {
	
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		AccountServices accountServices = new AccountServices();
		while(true) {
			System.out.println("\n===== BANK MENU =====");

            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();
            
            switch(choice) {
            case 1:
            	scanner.nextLine();
            	accountServices.createAccount();
            	break;
            case 2:
            	scanner.nextLine();
            	accountServices.deposit();
            	break;
            case 3:
            	scanner.nextLine();
            	accountServices.withdraw();
            	break;
            case 4:
            	scanner.nextLine();
            	accountServices.checkBalance();
            	break;
            	
            case 5:
            	System.out.println("Thank You");
            	System.exit(0);

            default:
            	System.out.println("Invalid Choice");
            }
		}
	}
}
