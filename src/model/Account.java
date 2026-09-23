package model;

/**
 * Abstract base class representing a generic bank account.
 * Cannot be instantiated directly — only through its subclasses
 * SavingsAccount and CurrentAccount.
 */
public abstract class Account implements Transactable {

    // Final constant: shared by all accounts, value never changes
    public static final double MIN_TRANSACTION_AMOUNT = 1.0;

    // Static field: shared across ALL Account objects (tracks total accounts created)
    private static int totalAccounts = 0;

    // Instance fields: each Account object has its own copy
    private String accountNumber;
    private double balance;
    private Customer customer;

    // Default constructor
    public Account() {
        this.accountNumber = "UNSET";
        this.balance = 0.0;
        totalAccounts++;
    }

    // Parameterized constructor (constructor overloading)
    public Account(String accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        totalAccounts++;
    }

    // Getters and setters (encapsulation)
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Deposit implementation (from Transactable interface)
    @Override
    public void deposit(double amount) {
        if (amount >= MIN_TRANSACTION_AMOUNT) {
            this.balance = this.balance + amount;
        }
    }

    // Withdraw implementation (from Transactable interface)
    @Override
    public boolean withdraw(double amount) {
        if (amount >= MIN_TRANSACTION_AMOUNT && amount <= this.balance) {
            this.balance = this.balance - amount;
            return true;
        }
        return false;
    }

    // Abstract method — every subclass MUST provide its own version
    public abstract double calculateInterest();

    // Final method — cannot be overridden by any subclass.
    // This is final because the bank's identity/name must stay
    // consistent across every account type; changing it per subclass
    // would break the shared brand identity.
    public final void displayBankName() {
        System.out.println("=== SecureTrust Bank ===");
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}