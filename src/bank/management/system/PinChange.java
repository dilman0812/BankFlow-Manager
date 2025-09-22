package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin_text, repin_text;
    JButton change, back;
    String pinNumber;

    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Change you PIN");
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(250,280,500,20);
        image.add(text);

        JLabel new_pin = new JLabel("New PIN:");
        new_pin.setFont(new Font("System", Font.BOLD,16));
        new_pin.setBounds(165,320,180,25);
        image.add(new_pin);

        pin_text = new JPasswordField();
        pin_text.setFont(new Font("Raleway", Font.BOLD,16));
        pin_text.setBounds(330,320,180,25);
        image.add(pin_text);

        JLabel repin = new JLabel("Re-Enter New PIN:");
        repin.setFont(new Font("System", Font.BOLD,16));
        repin.setBounds(165,360,180,25);
        image.add(repin);

        repin_text = new JPasswordField();
        repin_text.setFont(new Font("Raleway", Font.BOLD,16));
        repin_text.setBounds(330,360,180,25);
        image.add(repin_text);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change) {
            try {
                String n_pin = pin_text.getText();
                String r_pin = repin_text.getText();

                if (!n_pin.equals(r_pin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (n_pin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                    return;
                }
                if (r_pin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }
                Conn conn = new Conn();                 // now we update the pin in all tables
                String query1 = "update bank set pin = '"+r_pin+"' where pin = '"+pinNumber+"'";
                String query2 = "update login set pin_number = '"+r_pin+"' where pin_number = '"+pinNumber+"'";
                String query3 = "update signupthree set pin_number = '"+r_pin+"' where pin_number = '"+pinNumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changed sucessfully");

                setVisible(false);
                new Transactions(n_pin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
