package model;

/**
 * Concrete subclass of Account representing a Savings Account.
 * Earns interest and enforces a minimum balance rule on withdrawal.
 */
public class SavingsAccount extends Account {

    private double interestRate;
    private static final double MIN_BALANCE = 500.0;

    // Default constructor
    public SavingsAccount() {
        super();
        this.interestRate = 4.0; // default interest rate in %
    }

    // Parameterized constructor — calls parent constructor using super()
    public SavingsAccount(String accountNumber, double balance, Customer customer, double interestRate) {
        super(accountNumber, balance, customer);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Overriding calculateInterest() from abstract Account class
    @Override
    public double calculateInterest() {
        // Operator precedence example: multiplication happens before division
        return getBalance() * interestRate / 100;
    }

    // Overriding withdraw() to enforce minimum balance rule.
    // Demonstrates method overriding + dynamic binding when called
    // through a parent (Account) reference.
    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount < MIN_BALANCE) {
            System.out.println("Withdrawal denied: Savings account must maintain minimum balance of "
                    + MIN_BALANCE);
            return false;
        }
        // Reuse parent's withdraw logic via super
        return super.withdraw(amount);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", interestRate=" + interestRate +
                '}';
    }
}