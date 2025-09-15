package bank.management.system;

import java.sql.*;

public class Conn {

    /* JDBC(java DB Connectivity)
     Steps:
     1. Register the Driver
     2. Create Connection
     3. Create Statement
     4. Execute Query
     5. Close Connection
     */

    // constructor
    Connection c;
    Statement s;
    public Conn() {
        try {                       // exception handling because MySQL is an external entity (so there can be errors)
//            Class.forName(com.mysql.cj.jdbc.Driver);       we don't have to write this now because modern JDBC can pick it automatically
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "#password");             // driverManager class has function getConnection(url)
            s = c.createStatement();

        } catch (Exception e){
            System.out.println(e);
        }
    }

}
