package model;

/**
 * Represents a single transaction (deposit, withdrawal, or transfer)
 * performed on an account. Used to keep a simple history log.
 */
public class Transaction {

    private String type;      // e.g. "DEPOSIT", "WITHDRAW", "TRANSFER"
    private double amount;
    private String date;
    private String remarks;

    // Default constructor
    public Transaction() {
        this.type = "UNKNOWN";
        this.amount = 0.0;
        this.date = "N/A";
        this.remarks = "";
    }

    // Parameterized constructor (constructor overloading)
    public Transaction(String type, double amount, String date, String remarks) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.remarks = remarks;
    }

    // Method overloading: a simpler constructor-like helper without remarks.
    // (Shown here as an overloaded constructor as well)
    public Transaction(String type, double amount, String date) {
        this(type, amount, date, "N/A");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s of %.2f on %s (%s)",
                type, type, amount, date, remarks);
    }
}
