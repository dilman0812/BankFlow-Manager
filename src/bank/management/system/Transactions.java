package bank.management.system;

import javax.swing.*;                   // for JFrame
import java.awt.*;                       // image class
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fast_cash, mini_statement, pin_change, balance_inquiry, exit;
    String pinNumber;
    Transactions(String pinNumber) {
        this.pinNumber = pinNumber;                 // storing local variable in global variable
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);                // scaling the image
        ImageIcon i3 = new ImageIcon(i2);                                                                   // converting the scaled image back into an Image icon
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);                    // adding text on image

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);                // tells this button is clicked perform some action
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fast_cash  = new JButton("Fast Cash");
        fast_cash.setBounds(170,450,150,30);
        fast_cash.addActionListener(this);
        image.add(fast_cash);

        mini_statement = new JButton("Mini Statement");
        mini_statement.setBounds(355,450,150,30);
        mini_statement.addActionListener(this);
        image.add(mini_statement);

        pin_change  = new JButton("Pin Change");
        pin_change.setBounds(170,485,150,30);
        pin_change.addActionListener(this);
        image.add(pin_change);

        balance_inquiry = new JButton("Balance Inquiry");
        balance_inquiry.setBounds(355,485,150,30);
        balance_inquiry.addActionListener(this);
        image.add(balance_inquiry);

        exit = new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == fast_cash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == pin_change){
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if (ae.getSource() == balance_inquiry){
            setVisible(false);
            new BalanceInquiry(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");

    }
}
