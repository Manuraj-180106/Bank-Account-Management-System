package main;

import controller.BankController;
import service.BankService;
import repository.AccountRepository;

/**
 * Entry point of the Bank Account Management System.
 * Wires together the Repository, Service, and Controller layers,
 * then starts the console application.
 */
public class Main {

    public static void main(String[] args) {
        AccountRepository repository = new AccountRepository();
        BankService bankService = new BankService(repository);
        BankController controller = new BankController(bankService);

        controller.start();
    }
}