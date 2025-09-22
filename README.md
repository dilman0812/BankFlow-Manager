# Bank Management System

A desktop-based Java application that simulates core banking operations, including user r>

##  Database Integration

### **JDBC Connectivity Implementation**
This project implements robust MySQL database connectivity using Java Database Connectivi>

**Complete Signup-to-Database Pipeline**
- **Signup Integration:** Final signup form persists all user data to MySQL
- **Real-time Data Persistence:** User account creation fully operational with live datab>
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
  - **Step 3:** Account services configuration and data persistence

- **Main Banking Dashboard:** Complete transactions interface with:
  - Deposit operations
  - Withdrawal system
  - Fast Cash Withdrawal: One-click preset amounts
  - **PIN Change:** PIN update functionality with basic validation
  - **Balance Inquiry:** Account balance calculation

- **Database Integration:**
  - MySQL Transaction Processing
  - Balance Validation
  - PIN management across multiple tables

- **Professional UI Assets:** Enhanced user experience with ATM interface graphics
- **Form Validation:** Basic input validation and error checking
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
            └── icons/              // Visual assets
                ├── atm.jpg         // ATM interface background
                └── logo.jpg        // Bank branding logo

```
