# Bank Management System

A desktop-based Java application that simulates core banking operations, including user registration, login, and fund transactions.

##  Database Integration

### **JDBC Connectivity Implementation**
This project implements robust MySQL database connectivity using Java Database Connectivity (JDBC) for persistent data storage.

**Complete Signup-to-Database Pipeline**
- **3-Step Registration System:** Multi-form user onboarding with progressive data collection
- **Real-time Data Persistence:** User account creation fully operational with live database
- **Multi-table Inserts:** Data efficiently stored across normalized database tables

#### **JDBC Connection Steps Implemented:**
1.  **Driver Auto-Loading:** JDBC 4.0+ automatic driver registration
2.  **Connection Establishment:** 'DriverManager.getConnection()'
3.  **PreparedStatement Usage:** Secure parameterized queries for user data insertion
4.  **Transaction Management:** Atomic database operations for signup process
5.  **Resource Management:** Proper connection closing with try-with-resources

### **Database Configuration**
- **Database System:** MySQL
- **Database Name:** `bankmanagementsystem`
- **Tables Implemented:** `signup`, `signuptwo`, `signupthree`, `login`, `bank`
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

## Current Features

- **Banking Authentication Portal:** Swing-based login interface with card number and PIN validation

- **3-Step Customer Onboarding Process:**
  - **Step 1 (SignupOne):** Personal identification data collection including name, father's name, date of birth, gender, email, marital status, and complete address details
  - **Step 2 (SignupTwo):** Comprehensive financial profile including religion, category, income range, education qualification, occupation, and identification documents
  - **Step 3 (SignupThree):** Account configuration with card generation, PIN assignment, and banking service selection

- **Main Banking Dashboard:** Complete transactions interface with:
  - Deposit operations
  - Withdrawal system
  - Fast Cash Withdrawal: One-click preset amounts
  - PIN Change: PIN update functionality with basic validation
  - Balance Inquiry: Account balance calculation
  - Mini Statements: Transaction history with balance display

- **Database Integration:**
  - MySQL Transaction Processing
  - Balance Validation
  - PIN management across multiple tables
  - Transaction history tracking
  - Automated card number and PIN generation

- **Professional UI Assets:** Enhanced user experience with ATM interface graphics
- **Form Validation:** Comprehensive input validation and error checking across all forms
- **MySQL Database Integration:** Persistent data storage with JDBC connectivity

## Technology Stack

- **Frontend:** Java Swing & AWT (GUI Components)
- **Backend:** Core Java
- **Database:** MySQL with JDBC Connectivity
- **IDE:** IntelliJ IDEA

## Project Structure
```
src/
└── bank/
    └── management/
        └── system/
            ├── Login.java          // Card number & PIN authentication
            ├── SignupOne.java      // Step 1: Personal details collection
            ├── SignupTwo.java      // Step 2: Financial profile & occupation
            ├── SignupThree.java    // Step 3: Account services configuration
            ├── Conn.java           // MySQL database connection layer
            ├── Transactions.java   // Main banking dashboard
            ├── Deposit.java        // Deposit transaction processing
            ├── Withdrawal.java     // Withdrawal transaction processing
            ├── FastCash.java       // One-click preset amount withdrawals
            ├── PinChange.java      // PIN update functionality
            ├── BalanceInquiry.java // Account balance calculation
            ├── MiniStatement.java  // Transaction history and balance display
            └── icons/              // Visual assets
                ├── atm.jpg         // ATM interface background
                └── logo.jpg        // Bank branding logo

```
