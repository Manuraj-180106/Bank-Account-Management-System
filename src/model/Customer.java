package model;

/**
 * Represents a bank customer.
 * Composed inside Account (an Account "has-a" Customer).
 */
public class Customer {

    private String customerId;
    private String name;
    private String phone;

    // Default constructor
    public Customer() {
        this.customerId = "UNKNOWN";
        this.name = "UNKNOWN";
        this.phone = "UNKNOWN";
    }

    // Parameterized constructor (constructor overloading)
    public Customer(String customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name.trim();
        this.phone = phone.trim();
    }

    // Getters and setters (encapsulation)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone.trim();
    }

    // Simple validation using String methods: checks phone has only digits
    // and is a reasonable length. Demonstrates String.contains / basic checks.
    public boolean isValidPhone() {
        if (phone == null || phone.length() != 10) {
            return false;
        }
        // split() demonstration: break phone into individual characters
        String[] digits = phone.split("");
        for (String d : digits) {
            if (!d.matches("[0-9]")) {
                return false;
            }
        }
        return true;
    }

    // equals() override — two customers are considered equal
    // if they have the same customerId
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Customer other = (Customer) obj;
        return this.customerId.equals(other.customerId);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}