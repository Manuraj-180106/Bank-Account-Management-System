package controller;

import model.Account;
import model.AccountType;
import model.Customer;
import service.BankService;

import java.util.Scanner;

/**
 * Controller layer — handles all console input/output.
 * Contains no business logic; simply collects input and
 * displays results by calling the Service layer.
 */
public class BankController {

    private Scanner scanner;
    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
        this.scanner = new Scanner(System.in);
    }

    // Main menu loop
    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = -1;

            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue; // jump statement — skip to next loop iteration
            }

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAccountDetails();
                    break;
                case 6:
                    transferMoney();
                    break;
                case 7:
                    displayAllAccounts();
                    break;
                case 8:
                    System.out.println("Thank you for banking with us!");
                    running = false;
                    return; // jump statement — exits the method immediately
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println("\n===== SecureTrust Bank =====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check Balance");
        System.out.println("5. Display Account Details");
        System.out.println("6. Transfer Money");
        System.out.println("7. Display All Accounts");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private void createAccount() {
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine().trim();

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter customer ID: ");
        String custId = scanner.nextLine().trim();

        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter initial deposit: ");
        double initialDeposit = Double.parseDouble(scanner.nextLine().trim());

        System.out.print("Enter account type (SAVINGS/CURRENT): ");
        String typeInput = scanner.nextLine().trim().toUpperCase();

        AccountType type;
        if (typeInput.equals("SAVINGS")) {
            type = AccountType.SAVINGS;
        } else if (typeInput.equals("CURRENT")) {
            type = AccountType.CURRENT;
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        Customer customer = new Customer(custId, name, phone);
        Account account = bankService.createAccount(accNo, initialDeposit, customer, type);

        if (account != null) {
            System.out.println("Account created successfully!");
            System.out.printf("Account Number: %s | Balance: %.2f%n",
                    account.getAccountNumber(), account.getBalance());
        } else {
            System.out.println("Account creation failed.");
        }
    }

    private void depositMoney() {
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine().trim();

        System.out.print("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());

        boolean success = bankService.deposit(accNo, amount);

        if (success) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit failed. Account not found.");
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine().trim();

        System.out.print("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());

        boolean success = bankService.withdraw(accNo, amount);

        if (success) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed.");
        }
    }

    private void checkBalance() {
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine().trim();

        Account account = bankService.getAccountDetails(accNo);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.printf("Current Balance: %.2f%n", account.getBalance());
    }

    private void displayAccountDetails() {
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine().trim();

        Account account = bankService.getAccountDetails(accNo);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.displayBankName();
        System.out.println(account.toString());
        System.out.printf("Interest/Return: %.2f%n", account.calculateInterest());
    }

    private void transferMoney() {
        System.out.print("Enter sender account number: ");
        String fromAcc = scanner.nextLine().trim();

        System.out.print("Enter receiver account number: ");
        String toAcc = scanner.nextLine().trim();

        System.out.print("Enter amount to transfer: ");
        double amount = Double.parseDouble(scanner.nextLine().trim());

        boolean success = bankService.transfer(fromAcc, toAcc, amount);

        if (success) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed.");
        }
    }

    private void displayAllAccounts() {
        Account[] accounts = bankService.getAllAccounts();

        if (accounts.length == 0) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\n--- All Accounts ---");
        for (Account acc : accounts) {
            System.out.println(acc.toString());
        }

        System.out.println("Total accounts created: " + bankService.getTotalAccounts());
    }
}