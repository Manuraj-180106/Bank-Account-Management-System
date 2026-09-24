package service;

import model.Account;
import model.AccountType;
import model.CurrentAccount;
import model.Customer;
import model.SavingsAccount;
import repository.AccountRepository;

/**
 * Service layer — contains all business rules and logic.
 * Talks only to the Repository. Never touches Scanner or System.in directly;
 * that is the Controller's job.
 */
public class BankService {

    private AccountRepository repository;

    public BankService(AccountRepository repository) {
        this.repository = repository;
    }

    // Creates a new account based on the given AccountType
    public Account createAccount(String accountNumber, double initialDeposit,
                                  Customer customer, AccountType type) {
        Account newAccount;

        // switch statement based on enum value
        switch (type) {
            case SAVINGS:
                newAccount = new SavingsAccount(accountNumber, initialDeposit, customer, 4.0);
                break;
            case CURRENT:
                newAccount = new CurrentAccount(accountNumber, initialDeposit, customer, 1000.0);
                break;
            default:
                return null;
        }

        repository.addAccount(newAccount);
        return newAccount;
    }

    // Method overloading: simple deposit
    public boolean deposit(String accountNumber, double amount) {
        Account account = repository.findByAccountNumber(accountNumber);
        if (account == null) {
            return false;
        }
        account.deposit(amount);
        return true;
    }

    // Method overloading: deposit with a remark (demonstrates overloading, requirement #10)
    public boolean deposit(String accountNumber, double amount, String remarks) {
        Account account = repository.findByAccountNumber(accountNumber);
        if (account == null) {
            return false;
        }
        System.out.println("Remark: " + remarks);
        account.deposit(amount);
        return true;
    }

    // Withdraw money — dynamic binding happens here automatically,
    // since account.withdraw() calls the correct overridden version
    // depending on whether account is a SavingsAccount or CurrentAccount.
    public boolean withdraw(String accountNumber, double amount) {
        Account account = repository.findByAccountNumber(accountNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return false;
        }
        return account.withdraw(amount);
    }

    // Transfer money between two accounts
    public boolean transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = repository.findByAccountNumber(fromAccountNumber);
        Account toAccount = repository.findByAccountNumber(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            System.out.println("One or both accounts not found.");
            return false;
        }

        boolean withdrawn = fromAccount.withdraw(amount);
        if (!withdrawn) {
            return false;
        }

        toAccount.deposit(amount);
        return true;
    }

    public Account getAccountDetails(String accountNumber) {
        return repository.findByAccountNumber(accountNumber);
    }

    public Account[] getAllAccounts() {
        return repository.getAllAccounts();
    }

    public int getTotalAccounts() {
        return Account.getTotalAccounts();
    }
}