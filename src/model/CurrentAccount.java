package model;

/**
 * Concrete subclass of Account representing a Current Account.
 * Does not earn interest, but allows withdrawals beyond the balance
 * up to a fixed overdraft limit.
 */
public class CurrentAccount extends Account {

    private double overdraftLimit;

    // Default constructor
    public CurrentAccount() {
        super();
        this.overdraftLimit = 1000.0; // default overdraft limit
    }

    // Parameterized constructor — calls parent constructor using super()
    public CurrentAccount(String accountNumber, double balance, Customer customer, double overdraftLimit) {
        super(accountNumber, balance, customer);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    // Overriding calculateInterest() from abstract Account class.
    // Current accounts do not earn interest, so this always returns 0.
    @Override
    public double calculateInterest() {
        return 0.0;
    }

    // Overriding withdraw() to allow overdraft up to a limit.
    // Demonstrates method overriding + dynamic binding when called
    // through a parent (Account) reference.
    @Override
    public boolean withdraw(double amount) {
        double balanceAfterWithdrawal = getBalance() - amount;

        // type conversion example: casting double to int for a quick display value
        int roundedShortfall = (int) balanceAfterWithdrawal;

        if (balanceAfterWithdrawal < -overdraftLimit) {
            System.out.println("Withdrawal denied: exceeds overdraft limit of " + overdraftLimit
                    + " (would result in approx. " + roundedShortfall + ")");
            return false;
        }

        setBalance(balanceAfterWithdrawal);
        return true;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "accountNumber='" + getAccountNumber() + '\'' +
                ", balance=" + getBalance() +
                ", overdraftLimit=" + overdraftLimit +
                '}';
    }
}