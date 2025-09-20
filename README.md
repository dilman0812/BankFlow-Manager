# Bank Management System

A desktop-based Java application that simulates core banking operations, including user registration, login, and fund transactions. Built with Java Swing and MySQL.

##  Database Integration

### **JDBC Connectivity Implementation**
This project implements robust MySQL database connectivity using Java Database Connectivity (JDBC) API. The connection layer ensures secure and efficient data persistence for all banking operations.

**Complete Signup-to-Database Pipeline**
- **Signup Integration:** Final signup form persists all user data to MySQL
- **Real-time Data Persistence:** User account creation fully operational with live database storage
- **Multi-table Inserts:** Data efficiently stored across normalized database tables

#### **JDBC Connection Steps Implemented:**
1.  **Driver Auto-Loading:** JDBC 4.0+ automatic driver registration
2.  **Connection Establishment:** 'DriverManager.getConnection()'
3.  **PreparedStatement Usage:** Secure parameterized queries for user data insertion
4.  **Transaction Management:** Atomic database operations for signup process
5.  **Resource Management:** Proper connection closing with try-with-resources

### **Database Configuration**
- **Database System:** MySQL
- **Database Name:** 'bankmanagementsystem'
- **Tables Implemented:** Users, Accounts, SignupData
- **Data Validation:** Server-side validation before database insertion

### **Connection Setup**
```java
// Database connection configuration in Conn.java
connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/bankmanagementsystem",
    "yourmysqlusername",
    "yourmysqlpassword"
);
```

### Current Features

- **Banking Authentication Portal:** Swing-based login interface with card number and PIN validation
- **Multi-Step Customer Onboarding:**
  - **Step 1:** Personal identification data (name, DOB, gender, contact, address)
  - **Step 2:** Comprehensive financial profile including:
    - Income details and financial background
    - Education qualification and occupation
    - Government ID verification (PAN, Aadhaar)
  - **Step 3:** Account services configuration and data persistence:
    - Account type selection (Savings, Current, FD, RD)
    - Digital banking services (ATM Card, Net Banking, Mobile Banking, Alerts, Cheque Book, E-Statement)
    - Final confirmation and MySQL database integration
- **Main Banking Dashboard:** Complete transactions interface with:
  - Deposit operations
  - Withdrawal system
- **Professional UI Assets:** Enhanced user experience with:
  - ATM interface background graphics
  - Bank branding logo
- **Live Database Integration:** Real-time MySQL data persistence during signup process
- **Form Validation:** Real-time input validation and error checking
- **MySQL Database Integration:** Secure, persistent data storage with proper JDBC connectivity

## Technology Stack

- **Frontend:** Java Swing & AWT (GUI Components)
- **Backend:** Core Java
- **Database:** MySQL with JDBC Connectivity
- **IDE:** IntelliJ IDEA

## Project Structure

## Project Structure

src/
└── bank/
    └── management/
        └── system/
            ├── Login.java          // Card number & PIN authentication
            ├── SignupOne.java      // Step 1: Personal details collection
            ├── SignupTwo.java      // Step 2: Financial profile & government IDs
            ├── SignupThree.java    // Step 3: Account services & database persistence
            ├── Conn.java           // MySQL database connection layer
            ├── Transactions.java    // Main banking dashboard
            ├── Deposit.java        // Deposit transaction processing
            ├── Withdrawal.java     // Withdrawal transaction processing
            └── icons/              // Visual assets
                ├── atm.jpg         // ATM interface background
                └── logo.jpg        // Bank branding logo
