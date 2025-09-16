package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTextField, aadharTextField;
    JButton next;
    JRadioButton sen_yes, sen_no, ex_yes, ex_no;
    JComboBox religions, categories, occup, incomeRange, education;
    String formno;

    SignupTwo(String formno){
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 40);             // set bounds works only when setLayout is null.
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);             // set bounds works only when setLayout is null.
        add(religion);

        String val_religion[] = {"Sikh", "Hindu", "Muslim", "Christian", "Other"};
        religions = new JComboBox(val_religion);               // to add a drop down we'll pass an array of string
        religions.setBounds(300, 140, 400, 30);
        religions.setBackground(Color.WHITE);
        add(religions);


        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD,20));
        category.setBounds(100,190,200,30);
        add(category);

        String val_categories[] = {"General", "OBC", "SC", "ST", "Other"};
        categories = new JComboBox(val_categories);
        categories.setBackground(Color.WHITE);
        categories.setBounds(300, 190, 400, 30);
        add(categories);


        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD,20));
        income.setBounds(100,240,200,30);
        add(income);

        String val_income[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        incomeRange = new JComboBox(val_income);
        incomeRange.setBackground(Color.WHITE);
        incomeRange.setBounds(300, 240, 400, 30);
        add(incomeRange);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD,20));
        educational.setBounds(100,290,200,30);
        add(educational);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD,20));
        qualification.setBounds(100,315,200,30);
        add(qualification);

        String val_education[] = {"Non Graduate", "Graduate", "Post Graduate", "Doctrate", "Others"};
        education = new JComboBox(val_education);
        education.setBackground(Color.WHITE);
        education.setBounds(300, 315, 400, 30);
        add(education);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD,20));
        occupation.setBounds(100,390,200,30);
        add(occupation);

        String val_occupation[] = {"Salaried","Self-Employed","Business","Student","Retired","Other"};
        occup = new JComboBox(val_occupation);
        occup.setBackground(Color.WHITE);
        occup.setBounds(300,390,400,30);
        add(occup);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);

        JLabel senior = new JLabel("Senior Citizon:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);

        sen_yes = new JRadioButton("Yes");
        sen_yes.setBackground(Color.WHITE);
        sen_yes.setBounds(300, 540,100,30);
        add(sen_yes);

        sen_no = new JRadioButton("No");
        sen_no.setBackground(Color.WHITE);
        sen_no.setBounds(450, 540,100,30);
        add(sen_no);

        ButtonGroup citizenGroup = new ButtonGroup();
        citizenGroup.add(sen_yes);
        citizenGroup.add(sen_no);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway",Font.BOLD,20));
        existing.setBounds(100,590,200,30);
        add(existing);

        ex_yes = new JRadioButton("Yes");
        ex_yes.setBackground(Color.WHITE);
        ex_yes.setBounds(300, 590,100,30);
        add(ex_yes);

        ex_no = new JRadioButton("No");
        ex_no.setBackground(Color.WHITE);
        ex_no.setBounds(450, 590,100,30);
        add(ex_no);

        ButtonGroup ex_accGroup = new ButtonGroup();
        ex_accGroup.add(ex_yes);
        ex_accGroup.add(ex_no);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String religion = (String) religions.getSelectedItem();      // getting the value from the JComboBox (this function returns an object so we typecast it into string)
        String category = (String) categories.getSelectedItem();
        String income = (String) incomeRange.getSelectedItem();
        String educated = (String) education.getSelectedItem();
        String occupation = (String) occup.getSelectedItem();
        String senior_citizen = null;
        if (sen_yes.isSelected()) {
            senior_citizen = "Yes";
        } else if (sen_no.isSelected()) {
            senior_citizen = "No";
        }

        String existing_account = null;
        if (ex_yes.isSelected()){
            existing_account = "Yes";
        }
        else if (ex_no.isSelected()){
            existing_account = "No";
        }

        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();


        try {                                       // exception handling : because at runtime there's a chance of error
            Conn c = new Conn();
            // The quotes (') are for SQL, and the plus signs (+) and double-quotes (") are for Java.
            String query = "insert into signuptwo values('"+formno+"','"+religion+"', '"+category+"', '"+income+"', '"+educated+"', '"+occupation+"', '"+pan+"', '"+aadhar+"', '"+senior_citizen+"', '"+existing_account+"')";            // DML command to insert data in mysql DB  (step 4)
            c.s.executeUpdate(query);               // running DML command by passing our query

            setVisible(false);

            // signup3 object
            new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");              // passing empty string because no default constructor
    }
}
