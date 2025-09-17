package bank.management.system;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton saving, fixed, current, recurring;
    JCheckBox atm_card, internet_banking, mobile_banking, email_sms, chequebook, e_statement, declaration;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);

        saving = new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway",Font.BOLD,16));
        saving.setBackground(Color.WHITE);
        saving.setBounds(100, 180, 250, 20);
        add(saving);

        fixed = new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway",Font.BOLD,16));
        fixed.setBackground(Color.WHITE);
        fixed.setBounds(350, 180, 250, 20);
        add(fixed);

        current = new JRadioButton("Current Account");
        current.setFont(new Font("Raleway",Font.BOLD,16));
        current.setBackground(Color.WHITE);
        current.setBounds(100, 220, 250, 20);
        add(current);

        recurring = new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway",Font.BOLD,16));
        recurring.setBackground(Color.WHITE);
        recurring.setBounds(350, 220, 250, 20);
        add(recurring);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(saving);
        groupaccount.add(fixed);
        groupaccount.add(current);
        groupaccount.add(recurring);

        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(100,300,200,30);
        add(cardno);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-1349");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel card_detail = new JLabel("Your 16 Digit Card Nmber");
        card_detail.setFont(new Font("Raleway",Font.BOLD,12));
        card_detail.setBounds(100,330,300,20);
        add(card_detail);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel p_number = new JLabel("XXXX");
        p_number.setFont(new Font("Raleway",Font.BOLD,22));
        p_number.setBounds(330,370,300,30);
        add(p_number);

        JLabel pin_detail = new JLabel("Your 4 Digit Pin");
        pin_detail.setFont(new Font("Raleway",Font.BOLD,12));
        pin_detail.setBounds(100,400,300,20);
        add(pin_detail);

        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,450,200,30);
        add(services);

        atm_card = new JCheckBox("ATM CARD");
        atm_card.setFont(new Font("Raleway", Font.BOLD,16));
        atm_card.setBounds(100,500,200,30);
        atm_card.setBackground(Color.WHITE);
        add(atm_card);

        internet_banking = new JCheckBox("INTERNET BANKING");
        internet_banking.setFont(new Font("Raleway", Font.BOLD,16));
        internet_banking.setBounds(350,500,200,30);
        internet_banking.setBackground(Color.WHITE);
        add(internet_banking);

        mobile_banking = new JCheckBox("MOBILE BANKING");
        mobile_banking.setFont(new Font("Raleway", Font.BOLD,16));
        mobile_banking.setBounds(100,550,200,30);
        mobile_banking.setBackground(Color.WHITE);
        add(mobile_banking);

        email_sms = new JCheckBox("EMAIL & SMS ALERTS");
        email_sms.setFont(new Font("Raleway", Font.BOLD,16));
        email_sms.setBounds(350,550,200,30);
        email_sms.setBackground(Color.WHITE);
        add(email_sms);

        chequebook = new JCheckBox("CHEQUE BOOK");
        chequebook.setFont(new Font("Raleway", Font.BOLD,16));
        chequebook.setBounds(100,600,200,30);
        chequebook.setBackground(Color.WHITE);
        add(chequebook);

        e_statement = new JCheckBox("E-STATEMENT");
        e_statement.setFont(new Font("Raleway", Font.BOLD,16));
        e_statement.setBounds(350,600,200,30);
        e_statement.setBackground(Color.WHITE);
        add(e_statement);

        declaration = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge.");
        declaration.setFont(new Font("Raleway", Font.BOLD,12));
        declaration.setBounds(100,680,600,30);
        declaration.setBackground(Color.WHITE);
        add(declaration);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
    }

    public void actionPerformed(ActionEvent ae){                       // overriding function
        if (ae.getSource() == submit){
            String accoutType = null;
            if (saving.isSelected()){
                accoutType = "Saving Account";
            } else if (fixed.isSelected()) {
                accoutType = "Fixed Deposit Account";
            } else if (current.isSelected()) {
                accoutType = "Current Account";
            } else if (recurring.isSelected()) {
                accoutType = "Recurring Deposit Account";
            }

            Random random = new Random();
            String card_number = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pin_number = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(atm_card.isSelected()){
                facility = facility + " ATM CARD";
            } else if (internet_banking.isSelected()){
                facility = facility + " INTERNET BANKING";
            } else if (mobile_banking.isSelected()){
                facility = facility + " MOBILE BANKING";
            } else if (email_sms.isSelected()){
                facility = facility + " EMAIL & SMS ALERTS";
            } else if (chequebook.isSelected()){
                facility = facility + " CHEQUE BOOK";
            } else if (e_statement.isSelected()) {
                facility = facility + " E-STATEMENT";
            }

            try {
                if (accoutType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required!");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accoutType+"', '"+card_number+"', '"+pin_number+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+card_number+"', '"+pin_number+"')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: " + card_number + "\n Pin: " + pin_number);
                }
                setVisible(false);
                new Deposit(pin_number).setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new SignupThree("");
    }
}
