# Requirements Compliance Table

This document maps all 21 mandatory Java OOP requirements to their exact 
location in the codebase.

| # | Requirement | File | Location / Evidence |
|---|---|---|---|
| 1 | Encapsulation | Account.java, Customer.java, Transaction.java | All fields private, accessed via public getters/setters |
| 2 | Data types, final, variable scope | Account.java | MIN_TRANSACTION_AMOUNT (static final), totalAccounts (static), local vars in service/controller methods |
| 3 | Operators, precedence | SavingsAccount.calculateInterest() | getBalance() * interestRate / 100 |
| 4 | Type casting | CurrentAccount.withdraw() | int roundedShortfall = (int) balanceAfterWithdrawal; |
| 5 | Enum | AccountType.java | SAVINGS, CURRENT |
| 6 | if-else, switch, loops, break/continue/return | BankController.start(), BankService.createAccount() | while loop, switch on choice/type, break, continue on bad input, return on Exit |
| 7 | Arrays of objects | AccountRepository.java | private Account[] accounts; |
| 8 | Console I/O, formatted output | BankController.java | Scanner, System.out.printf(...) |
| 9 | Constructor overloading | Account.java, Customer.java, Transaction.java | Default + parameterized constructors in each |
| 10 | Method overloading | BankService.java | Two deposit(...) methods |
| 11 | Static fields/methods | Account.java | totalAccounts, getTotalAccounts() |
| 12 | Explicit this | All model constructors | e.g. this.accountNumber = accountNumber; |
| 13 | String methods | Customer.java, BankController.java | trim(), split(), equals(), toUpperCase() |
| 14 | Base + 2 subclasses | Account -> SavingsAccount, CurrentAccount | Inheritance hierarchy |
| 15 | super | SavingsAccount, CurrentAccount constructors & withdraw() | super(...), super.withdraw(amount) |
| 16 | Overriding + dynamic binding | BankController.displayAllAccounts() | Account acc loop calling overridden toString() |
| 17 | Abstract class/method | Account.java | public abstract double calculateInterest(); |
| 18 | Interface via reference | Account implements Transactable | Used via Account/Transactable typed calls |
| 19 | toString()/equals() | Account, SavingsAccount, CurrentAccount, Customer, Transaction | All override toString(); Customer overrides equals() |
| 20 | final method/class | Account.java | public final void displayBankName() with justifying comment |
| 21 | 2+ packages, imports | Whole project | model, repository, service, controller, main - 5 packages |
