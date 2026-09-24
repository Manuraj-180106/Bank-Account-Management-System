package repository;

import model.Account;

/**
 * Repository layer — responsible only for storing and retrieving
 * Account objects. Contains no business logic (that belongs in the
 * Service layer) and no user interaction (that belongs in Controller).
 */
public class AccountRepository {

    // Array of objects — fixed-size in-memory storage for accounts
    private Account[] accounts;
    private int count;

    private static final int MAX_ACCOUNTS = 100;

    public AccountRepository() {
        this.accounts = new Account[MAX_ACCOUNTS];
        this.count = 0;
    }

    // Adds a new account to the array
    public boolean addAccount(Account account) {
        if (count >= MAX_ACCOUNTS) {
            System.out.println("Cannot add more accounts. Storage full.");
            return false;
        }
        accounts[count] = account;
        count++;
        return true;
    }

    // Searches for an account by account number using a loop
    public Account findByAccountNumber(String accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null; // not found
    }

    // Returns all accounts currently stored (only the filled portion of the array)
    public Account[] getAllAccounts() {
        Account[] result = new Account[count];
        for (int i = 0; i < count; i++) {
            result[i] = accounts[i];
        }
        return result;
    }

    public int getCount() {
        return count;
    }
}