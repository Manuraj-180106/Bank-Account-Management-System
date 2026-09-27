# Bank Account Management System

**SRN:** R24SA024
**Student:** Manaswini K R
**University:** REVA University
**Program:** B.Sc. (BSTCs)
**Semester:** V
**Subject:** OOPS (Java)

## 1. Project Overview

This is a console-based Bank Account Management System implemented in Java. It models customers, savings accounts, current accounts and transactions using object-oriented programming. The application supports account creation, deposits, withdrawals, transfers, balance checks, and account listing.

The implementation follows a layered architecture (Model / Repository / Service / Controller), organized into four custom packages plus an entry-point package.

## 2. Project Structure
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

