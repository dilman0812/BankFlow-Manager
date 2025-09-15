  GNU nano 6.0.1                 README.md                 Modified  
# Bank Management System

A desktop-based Java application that simulates core banking operations, 
including user registration, login, and fund transactions. Built with Java 
Swing and MySQL.

## 🗄️ Database Integration

### **JDBC Connectivity Implementation**
This project implements robust MySQL database connectivity using Java 
Database Connectivity (JDBC) API. The connection is established through 
a dedicated `Conn.java` class following the standard JDBC process.

#### **JDBC Connection Steps Implemented:**
1.  **Driver Auto-Loading:** JDBC 4.0+ automatic driver registration
2.  **Connection Establishment:** 'DriverManager.getConnection()'
3.  **Statement Creation:** 'connection.createStatement()'
4.  **Query Execution:** (Implemented throughout application)
5.  **Resource Management:** Proper connection closing

### **Database Configuration**
- **Database System:** MySQL
- **Database Name:** 'bankmanagementsystem'
- **Tables:** Users, Accounts, Transactions (to be implemented)

### **Connection Setup**
```java
// Database connection configuration in Conn.java
connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/bankmanagementsystem", 
    "yourmysqlusername", 
    "yourmysqlpassword"
);

🚀 Current Features
Banking Authentication Portal: Swing-based login interface with card
number and PIN validation

Customer Onboarding Form: Initial registration page collecting:

Personal identification data

Contact information (email)

Residential address details

Real-time input validation and error checking

MySQL Database Integration: Secure, persistent data storage with
proper JDBC connectivity

💻 Technology Stack
Frontend: Java Swing & AWT (GUI Components)

Backend: Core Java

Database: MySQL with JDBC Connectivity

IDE: IntelliJ IDEA



src/
└── bank/
    └── management/
        └── system/
            ├── Login.java          // Card number & PIN authentication
            ├── SignupOne.java      // Step 1: Personal details collection
            ├── Conn.java           // MySQL database connection layer
            └── (More components in development)
icons/
├── atm.jpg             // Application icon
└── logo.jpg            // Logo used in the UI
