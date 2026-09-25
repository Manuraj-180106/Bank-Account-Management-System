# Bank Account Management System

A console-based Java application demonstrating core Object-Oriented Programming principles, developed as a mini-project for the OOPS Java practical course.

## Student Details

- **Name:** Manaswini K R
- **Course:** B.Sc. BStCs, 5th Semester
- **University:** REVA University
- **Subject:** OOPS Java

## Overview

This project simulates a simple banking system where users can create accounts, deposit/withdraw money, check balances, transfer funds between accounts, and view account details — all through a console menu.

## Project Structure

Bank-Account-Management-System/
└── src/
├── main/
│ └── Main.java
├── model/
│ ├── AccountType.java
│ ├── Transactable.java
│ ├── Account.java
│ ├── SavingsAccount.java
│ ├── CurrentAccount.java
│ ├── Customer.java
│ └── Transaction.java
├── repository/
│ └── AccountRepository.java
├── service/
│ └── BankService.java
└── controller/
└── BankController.java


## Data Flow Diagram
┌─────────────────────────────────────────────────────────┐
│                      USER (Console)                      │
└───────────────────────┬───────────────────────────────────┘
                         │ types menu choice / data
                         ▼
┌─────────────────────────────────────────────────────────┐
│  main/Main.java                                          │
│  - Entry point                                            │
│  - Creates: AccountRepository → BankService → Controller  │
│  - Calls controller.start()                                │
└───────────────────────┬───────────────────────────────────┘
                         │ hands control to
                         ▼
┌─────────────────────────────────────────────────────────┐
│  controller/BankController.java                           │
│  - Displays menu (System.out)                              │
│  - Reads input (Scanner)                                    │
│  - NO business logic here                                    │
│  - Calls BankService methods                                  │
└───────────────────────┬───────────────────────────────────┘
                         │ passes clean data (e.g. accNo, amount)
                         ▼
┌─────────────────────────────────────────────────────────┐
│  service/BankService.java                                 │
│  - All business rules live here                             │
│  - Validates duplicates, negative amounts, etc.               │
│  - Decides SAVINGS vs CURRENT (switch on AccountType)          │
│  - Calls AccountRepository methods                               │
└───────────────────────┬───────────────────────────────────┘
                         │ asks repository to store/find
                         ▼
┌─────────────────────────────────────────────────────────┐
│  repository/AccountRepository.java                         │
│  - Pure storage layer                                        │
│  - Holds Account[] accounts array                              │
│  - addAccount(), findByAccountNumber(), getAllAccounts()          │
│  - NO business rules, NO I/O                                        │
└───────────────────────┬───────────────────────────────────┘
                         │ stores/retrieves
                         ▼
┌─────────────────────────────────────────────────────────┐
│  model/ (Account, SavingsAccount, CurrentAccount,           │
│          Customer, Transaction, AccountType, Transactable)     │
│  - The actual data + object behavior                              │
│  - Account is abstract, implements Transactable                     │
│  - SavingsAccount / CurrentAccount extend Account                     │
└─────────────────────────────────────────────────────────┘

## Features

- Create Savings or Current accounts
- Deposit and withdraw money
- Savings accounts enforce a minimum balance rule
- Current accounts allow overdraft up to a set limit
- Transfer money between accounts
- View individual account details and interest calculation
- View all accounts with total account count

## How to Run

### Using an IDE (e.g. VS Code)

1. Clone this repository
2. Open the folder in VS Code (with the Java Extension Pack installed)
3. Open `src/main/Main.java`
4. Click the **Run** button above the `main` method, or right-click → **Run Java**

### Using plain javac/java commands
cd src
javac -d out main/Main.java model/.java repository/.java service/.java controller/.java
java -cp out main.Main


## OOP Concepts Demonstrated

This project demonstrates 21 core Java/OOP concepts including encapsulation, inheritance, polymorphism (method overriding + dynamic binding), abstraction (abstract classes and interfaces), constructor/method overloading, static members, final constants/methods, enums, arrays of objects, and more.

See [REQUIREMENTS.md](REQUIREMENTS.md) for the full mapping of each concept to its exact location in the code.

## Testing

The following scenarios were tested and verified working:

- Savings account minimum-balance withdrawal rule
- Successful savings withdrawal within limit
- Current account overdraft within limit
- Overdraft-limit rejection
- Duplicate account number rejection
- Negative/invalid amount rejection (deposit and withdrawal)
- Account transfer between two accounts
- Dynamic binding across account types (SavingsAccount / CurrentAccount)
- Interest calculation

## Author

**Manaswini K R**
B.Sc. BStCs, 5th Semester
REVA University
