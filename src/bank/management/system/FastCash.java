package bank.management.system;

import javax.swing.*;                   // for JFrame
import java.awt.*;                      // image class
import java.awt.event.*;
import java.sql.*;                      // for ResultSet
import java.util.Date;                     // for Date

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fast_cash, mini_statement, pin_change, balance_enquiry, back;
    String pinNumber;
    FastCash(String pinNumber) {
        this.pinNumber = pinNumber;                 // storing local variable in global variable
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);                // scaling the image
        ImageIcon i3 = new ImageIcon(i2);                                                                   // converting the scaled image back into an Image icon
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);                    // adding text on image

        deposit = new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);                // tells this button is clicked perform some action
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fast_cash  = new JButton("Rs 1000");
        fast_cash.setBounds(170,450,150,30);
        fast_cash.addActionListener(this);
        image.add(fast_cash);

        mini_statement = new JButton("Rs 2000");
        mini_statement.setBounds(355,450,150,30);
        mini_statement.addActionListener(this);
        image.add(mini_statement);

        pin_change  = new JButton("Rs 5000");
        pin_change.setBounds(170,485,150,30);
        pin_change.addActionListener(this);
        image.add(pin_change);

        balance_enquiry = new JButton("Rs 10000");
        balance_enquiry.setBounds(355,485,150,30);
        balance_enquiry.addActionListener(this);
        image.add(balance_enquiry);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);   // typecasting into JButton because ae.getSource() return an object, substring because we don't need the Rs
            Conn c = new Conn();
            try {
                ResultSet rs  = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));                // amount is String but balance is integer so Integer.parseInt()
                    }
                    else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs " + amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinNumber).setVisible(true);

            } catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");

    }
}
