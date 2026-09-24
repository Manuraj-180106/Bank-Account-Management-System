package model;

/**
 * Interface defining the core banking operations
 * that every type of account must support.
 */
public interface Transactable {

    void deposit(double amount);

    boolean withdraw(double amount);
}
