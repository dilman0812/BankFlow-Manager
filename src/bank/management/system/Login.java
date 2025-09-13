package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;              // for ResultSet

public class Login extends JFrame implements ActionListener {      // (extents) inheritance,JFrame is a class of swing,

    JButton login,signup, clear;                // defined globally to use access them outside of constructor
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login() {

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);                        // setting border layout null

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));   // new object to get the image
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);   // scaling the image
        ImageIcon i3 = new ImageIcon(i2);               // converting the scaled image back into an Image icon
        JLabel label = new JLabel(i3);                      // we have to put image icon in JLabel to put it in frame, but we can't put image in JLabel (ImageIcon only)
        label.setBounds(70,10,100,100);
        add(label);                                         // placing JLabel on the frame using add function

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Railway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Railway",Font.BOLD,28));
        pin.setBounds(120,220,400,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);        // background color

        setSize(800, 480);             // dimensions of frame
        setVisible(true);                          // make the frame visible
        setLocation(350,200);                // set frame location
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == clear) {            // source of the button clicked
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login){
            Conn conn = new Conn();               // establishing connection with database
            String cardNumber = cardTextField.getText();       // getting value from cardTextField
            String pinNumber = pinTextField.getText();

            String query = "select * from login where card_number = '"+cardNumber+"' and pin_number = '"+pinNumber+"'";           // getting data from the login table where card_number and pin_number matches the cardNumber and pinNumber
            try {
                ResultSet rs = conn.s.executeQuery(query);             // putting data in ResulSet ,DDL command so we use executeQuerry()
                if (rs.next()) {
                    setVisible(false);              // if rs.next got data that means successful login
                    new Transactions(pinNumber).setVisible(true);               // forwarding pinNumber because we don't need it again if login was successful
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin!");
                }
            } catch(Exception e) {
                System.out.println(e);
            }
        }else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true) ;
        }
    }
    public static void main(String[] args) {
        new Login();                             // object  (if we make an object constructor is called so we have to write our code in constructor because we want to see the frame after making the object)
    }
}
