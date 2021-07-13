package com.java.bankingapplication;

import java.util.Scanner;

public class Account {
	
	int balance;
	int previousTransaction;
	String customerName;
	String customerID;
	
	//class constructor
	Account(String cname, String cid){
		customerName = cname;
		customerID = cid;
	}
	
	//Function of deposit money
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	//function showing previous Transaction
	
	void getpreviousTransaction() {
		if(previousTransaction>0) {
			System.out.println("Deposit: "+previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdraw: "+Math.abs(previousTransaction));
		}
		else {
			System.out.println("There is no transaction occured");
		}
	}
	
	void calculateInterest(int years) {
		double interestRate  = .0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("Current interset: "+(100*interestRate)+"%");
		System.out.println("After "+years+" years, I balance wii be :"+newBalance);
	}
	
	//function show main menu
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, "+customerName+"!");
		System.out.println("Your ID is: "+customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawal");
		System.out.println("D. View previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scanner.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			
			case 'A':
				System.out.println("======================================");
				System.out.println("Balance = $"+balance);
				System.out.println("======================================");
				System.out.println();
				break;
				
			case 'B':
				System.out.println("Enter the amount to deposit:");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
				
			case 'C':
				System.out.println("Enter an amount to withdraw:");
				int amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
				
			case 'D':
				System.out.println("======================================");
				getpreviousTransaction();
				System.out.println("======================================");
				System.out.println();
				break;
				
			case 'E':
				System.out.println("Enter how many years of accured interest:");
				int years = scanner.nextInt();
				calculateInterest(years);
				break;
				
			case 'F':
				System.out.println("======================================");
				break;
				
			default:
				System.out.println("Error: invalid option. Please enter A, B , C, D, E, F");
				break;
				
			}
		}while(option != 'F');
		System.out.println("Thank you for banking with us!");
		
	}


}
