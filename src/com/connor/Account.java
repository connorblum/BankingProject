package com.connor;

import java.util.Scanner;

public class Account {

    private final String customerName;
    private final String accountNumber;
    private double lastTransaction;
    private double balance;

    public Account (String name, String accountNumber) {
        this.customerName = name;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.lastTransaction = 0;
    }

    private double getBalance (){
        return balance;
    }

    private void deposit (double amount) {
        if (amount >0) {
            balance = balance + amount;
            lastTransaction = amount;
            System.out.println("£" + amount + " was deposited into " + customerName + "'s account");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    private boolean withdraw (double amount) {
        if (amount <= this.balance && amount > 0) {
            balance = balance - amount;
            lastTransaction = -amount;
            System.out.println("£" + amount + " was withdrawn from " + customerName + "'s account");
            return true;
        } else {
            System.out.println("Invalid funds");
            System.out.println("Current balance is £" + balance);
            return false;
        }
    }

    private void getLastTransaction() {
        if (lastTransaction > 0) {
            System.out.println("Deposited: £" + lastTransaction);
        } else if (lastTransaction < 0) {
            System.out.println("Withdrawn: £" + Math.abs(lastTransaction));
        } else {
            System.out.println("No previous transactions to show");
        }
    }

    public void runApplication(){

        int choice = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Account number: " + accountNumber);
        System.out.print("\n");
        System.out.println("Press 1 to check your current balance");
        System.out.println("Press 2 to deposit in money");
        System.out.println("Press 3 to withdraw funds");
        System.out.println("Press 4 to see your previous transaction");
        System.out.println("Press 5 to Exit");

        boolean quit = false;
        do {
            System.out.print("\n");
            System.out.println("Enter an Option or to print the menu press 0");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {

                    case 0:
                        System.out.println("Press 1 to check your current balance");
                        System.out.println("Press 2 to deposit in money");
                        System.out.println("Press 3 to withdraw funds");
                        System.out.println("Press 4 to see your previous transaction");
                        System.out.println("Press 5 to Exit");
                        break;

                    case 1:
                        System.out.println("Your balance is £" + getBalance());
                        break;

                    case 2:
                        System.out.println("Enter amount you wish to deposit");
                        double amount2 = scanner.nextDouble();
                        deposit(amount2);
                        break;

                    case 3:
                        System.out.println("Enter the amount you wish to withdraw");
                        double amount3 = scanner.nextDouble();
                        withdraw(amount3);
                        break;

                    case 4:
                        getLastTransaction();
                        break;

                    case 5:
                        System.out.println("***************************************");
                        break;

                    default:
                        System.out.println("Invalid option please try again");
                        break;
                }

                } else {
                System.out.println("Invalid input, please enter a number");
                scanner.nextLine();

            }


        } while (choice != 5) ;
            System.out.println("Thank you for banking with us");
    }
}
