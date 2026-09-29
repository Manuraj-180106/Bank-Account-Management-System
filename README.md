# Bank Account Management System

**SRN:** R24SA024
**Student:** Manaswini K R
**University:** REVA University
**Program:** B.Sc. (BSTCs)
**Semester:** V
**Subject:** OOPS (Java)

## 1. Project Overview

This is a console-based Bank Account Management System implemented in Java. It models customers, savings accounts, current accounts and transactions using object-oriented programming. The application supports account creation, deposits, withdrawals, transfers, balance checks, and account listing.

The implementation follows a layered architecture (Model / Repository / Service / Controller), organized into five custom packages.

## 2. Project Structure

```
Bank-Account-Management-System/
├── src/
│   ├── main/
│   │   └── Main.java
│   ├── model/
│   │   ├── Account.java
│   │   ├── AccountType.java
│   │   ├── CurrentAccount.java
│   │   ├── Customer.java
│   │   ├── SavingsAccount.java
│   │   ├── Transactable.java
│   │   └── Transaction.java
│   ├── repository/
│   │   └── AccountRepository.java
│   ├── service/
│   │   └── BankService.java
│   └── controller/
│       └── BankController.java
├── docs/
│   └── architecture-diagram.png
├── README.md
└── REQUIREMENTS.md
```

## 3. Features Implemented

- Savings and current account creation
- Deposit and withdrawal operations, with validation
- Inter-account money transfer
- Account balance and detail lookup
- Interest calculation (savings only)
- Overdraft handling (current accounts)
- Duplicate account number prevention
- Input validation (negative/zero amounts rejected)
- Formatted console output
- Object-oriented inheritance and polymorphism

## 4. Mandatory Feature Traceability

| # | Requirement | Implementation | Location |
|---|---|---|---|
| 1 | Encapsulation | Private fields with public getters/setters | Account.java, Customer.java, Transaction.java |
| 2 | Data types, constants, variable scope | double, String, int, static field, final constant, local variables | Account.java |
| 3 | Operators and precedence | `getBalance() * interestRate / 100` | SavingsAccount.java |
| 4 | Type conversion/casting | `int roundedShortfall = (int) balanceAfterWithdrawal` | CurrentAccount.java |
| 5 | Enum | AccountType (SAVINGS, CURRENT) | AccountType.java |
| 6 | Control flow and jump statements | if/else, switch, while, for, break, continue, return | BankController.java, BankService.java |
| 7 | Array of objects | `Account[] accounts` | AccountRepository.java |
| 8 | Console I/O and formatting | Scanner, System.out.printf | BankController.java |
| 9 | Constructor overloading | Default and parameterized constructors | Account.java, Customer.java, Transaction.java |
| 10 | Method overloading | Two deposit() methods with different parameters | BankService.java |
| 11 | Static fields/methods | totalAccounts, getTotalAccounts() | Account.java |
| 12 | this reference | Constructor field assignments | Account.java, Customer.java |
| 13 | String methods | trim(), equals(), toUpperCase(), split() | Customer.java, BankController.java |
| 14 | Base class + 2 subclasses | Account → SavingsAccount, CurrentAccount | Account.java, SavingsAccount.java, CurrentAccount.java |
| 15 | super keyword | Parent constructor and parent method calls | SavingsAccount.java, CurrentAccount.java |
| 16 | Method overriding + dynamic binding | Overridden withdraw()/toString() accessed through Account references | BankController.java (displayAllAccounts) |
| 17 | Abstract class + abstract method | Account (abstract), calculateInterest() (abstract) | Account.java |
| 18 | Interface | Transactable implemented by Account, accessed through interface reference | Transactable.java, BankService.java |
| 19 | Object method overriding | toString() and equals() overridden | Account.java, Customer.java, Transaction.java |
| 20 | Final method/class | Final displayBankName() with justifying comment | Account.java |
| 21 | Custom packages | model, repository, service, controller, main | src/ package hierarchy |

## 5. Important Code Locations

- Encapsulation and abstraction: `src/model/Account.java`
- Inheritance: `src/model/SavingsAccount.java`, `src/model/CurrentAccount.java`
- Customer model: `src/model/Customer.java`
- Data storage layer: `src/repository/AccountRepository.java`
- Business logic layer: `src/service/BankService.java`
- Interface: `src/model/Transactable.java`
- Console UI: `src/controller/BankController.java`
- Application entry point: `src/main/Main.java`

## 6. Compilation and Execution

From the project root:

```
cd src
javac -d out main/Main.java model/*.java repository/*.java service/*.java controller/*.java
java -cp out main.Main
```

The project was compiled successfully with standard javac and executed successfully using the Main class.

## 7. Sample End-to-End Run

The demonstrated flow includes:

- Creating savings and current accounts
- Depositing and withdrawing money
- Testing minimum-balance and overdraft rules
- Transferring money between accounts
- Viewing individual account details and interest
- Viewing all accounts with total account count
- Exiting the application

## 8. Class Structure

```
                    <<abstract>>
                      Account
                    /         \
                   /           \
        SavingsAccount       CurrentAccount

Transactable  <..............  Account

Account --> Customer
AccountRepository --> Account[]
BankService --> AccountRepository
BankController --> BankService
```

## 9. Data Flow Diagram

```
+-----------------------------------------------------------+
|                      USER (Console)                       |
+---------------------------+-------------------------------+
                             | types menu choice / data
                             v
+-----------------------------------------------------------+
|  main/Main.java                                            |
|  - Entry point                                              |
|  - Creates: AccountRepository -> BankService -> Controller  |
|  - Calls controller.start()                                  |
+---------------------------+-------------------------------+
                             | hands control to
                             v
+-----------------------------------------------------------+
|  controller/BankController.java                             |
|  - Displays menu (System.out)                                |
|  - Reads input (Scanner)                                      |
|  - NO business logic here                                      |
|  - Calls BankService methods                                    |
+---------------------------+-------------------------------+
                             | passes clean data (accNo, amount)
                             v
+-----------------------------------------------------------+
|  service/BankService.java                                   |
|  - All business rules live here                               |
|  - Validates duplicates, negative amounts, etc.                 |
|  - Decides SAVINGS vs CURRENT (switch on AccountType)             |
|  - Calls AccountRepository methods                                  |
+---------------------------+-------------------------------+
                             | asks repository to store/find
                             v
+-----------------------------------------------------------+
|  repository/AccountRepository.java                           |
|  - Pure storage layer                                          |
|  - Holds Account[] accounts array                                |
|  - addAccount(), findByAccountNumber(), getAllAccounts()           |
|  - NO business rules, NO I/O                                        |
+---------------------------+-------------------------------+
                             | stores/retrieves
                             v
+-----------------------------------------------------------+
|  model/ (Account, SavingsAccount, CurrentAccount,             |
|          Customer, Transaction, AccountType, Transactable)      |
|  - The actual data + object behavior                              |
|  - Account is abstract, implements Transactable                     |
|  - SavingsAccount / CurrentAccount extend Account                     |
+-----------------------------------------------------------+
```

## 9a. Architecture Diagram (Visual)

![Architecture Diagram](docs/architecture-diagram.png)

This diagram shows the full request/response cycle: the console user enters choices, `Main.java` wires up the layers, `BankController` manages menu and input, `BankService` handles all banking operations, `AccountRepository` stores accounts, and the model classes (`Account`, `SavingsAccount`, `CurrentAccount`, `Customer`, `Transaction`, `AccountType`, `Transactable`) hold the actual data and behavior.

## 10. Frontend Decision

The assignment specifies a console-based real-world application, so the submitted implementation uses a console interface rather than a GUI, with a clear menu and formatted output.

## 11. Submission Checklist

- [x] Complete Java source code
- [x] Custom package structure (5 packages)
- [x] Mandatory Unit-I and Unit-II OOP features (21/21)
- [x] README/traceability report
- [x] Compiles using standard Java tools
- [x] Runs without compilation errors