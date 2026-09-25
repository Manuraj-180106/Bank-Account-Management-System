Bank Account Management System

A console-based Java application developed as a mini-project for the OOPS Java practical course.

The project simulates basic banking operations such as account creation, deposit, withdrawal, fund transfer, balance checking, and viewing account details while demonstrating core Java and Object-Oriented Programming concepts.

Student Details
| Details          | Information                    |
| ---------------- | ------------------------------ |
| **Name**         | Manaswini K R                  |
| **Course**       | B.Sc. BStCs – 5th Semester     |
| **University**   | REVA University                |
| **Subject**      | OOPS Java                      |
| **Project Type** | Console-Based Java Application |

Project Overview
The Bank Account Management System is a console-based application that allows users to perform basic banking operations.

Main Operations
Create Savings Account
Create Current Account
Deposit money
Withdraw money
Transfer money between accounts
Check account balance
View account details
Calculate interest
View all accounts
Display total account count

The project is designed using a layered architecture:

Features
Create Savings and Current accounts
Deposit and withdraw money
Savings account minimum-balance validation
Current account overdraft facility
Transfer money between accounts
Duplicate account number validation
Invalid/negative amount validation
Interest calculation
View individual account details
View all accounts
Console-based menu system
Object-oriented design using Java

Project Architecture
USER
 │
 │ Menu choice / Account data
 ▼
BANK CONTROLLER
(BankController.java)
 │
 │ Request
 ▼
BANK SERVICE
(BankService.java)
 │
 │ Store / Find / Update
 ▼
ACCOUNT REPOSITORY
(AccountRepository.java)
 │
 │ Account objects
 ▼
MODEL
(Account / SavingsAccount / CurrentAccount)
 │
 │ Result
 └──────────────────────────────┐
                                ▼
                         BANK SERVICE
                                │
                                ▼
                       BANK CONTROLLER
                                │
                                ▼
                              USER

The project follows a simple layered structure.

Controller Layer

Handles:

Console menu
User input
User output
Calling service methods

File:
controller/BankController.java

Service Layer

Handles:

Business logic
Validation
Account creation
Deposit
Withdrawal
Transfer
Account type selection

File:
service/BankService.java

Repository Layer

Handles:

Account storage
Searching accounts
Retrieving all accounts

File:
repository/AccountRepository.java

Model Layer

Contains the actual account classes and supporting components.

Project Structure
Bank-Account-Management-System/
│
└── src/
    │
    ├── main/
    │   └── Main.java
    │
    ├── model/
    │   ├── AccountType.java
    │   ├── Transactable.java
    │   ├── Account.java
    │   ├── SavingsAccount.java
    │   ├── CurrentAccount.java
    │   ├── Customer.java
    │   └── Transaction.java
    │
    ├── repository/
    │   └── AccountRepository.java
    │
    ├── service/
    │   └── BankService.java
    │
    └── controller/
        └── BankController.java

