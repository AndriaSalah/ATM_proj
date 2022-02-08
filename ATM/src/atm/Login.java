/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    //frame stuff
    JPasswordField t1;
    JButton b, b2, b3, b4, delete,newacc;

    CustomerData p = new CustomerData();
    Border border = new LineBorder(Color.BLACK, 1, true);

    public Login() {
        //change how the ui components will look like
        FlatDarkLaf.setup();
        UIManager.put( "Button.arc", 200 );
        UIManager.put( "Component.arc", 200 );
        UIManager.put( "ProgressBar.arc", 200 );
        UIManager.put( "TextComponent.arc", 200 );
        // change the color of the title bar
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(0, 103, 0));
        this.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);

        //sets a title that would be shown in the title bar
        this.setTitle("National Bank Of Egypt ATM");
        this.setVisible(true);
        this.setSize(400, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //base panel that will have all the other panels added to it
        //basically we divide our design into a series of panels that will have some specific components as some times
        //a single panel with single design won't fulfill the design we want it to have
        //panel init
        JPanel p = new JPanel();
        p.setBackground(new Color(60, 70, 92));
        JPanel p1, p2, p3, p4, p5, p6;

        p.setLayout(new GridLayout(6, 1));

        //component init
        JLabel l1, l2;

        //panel 1 fr labels
        p1 = new JPanel();
        p1.setBackground(new Color(60, 70, 92));
        p1.setLayout(new GridLayout(2, 1));
        l1 = new JLabel("Welcome to the National Bank Of Egypt", SwingConstants.CENTER);
        l2 = new JLabel("Please enter your pin", SwingConstants.CENTER);
        l1.setFont(new Font("Times", Font.BOLD, 20));
        l1.setForeground(Color.white);
        l2.setForeground(Color.white);
        l1.setOpaque(true);
        l1.setBackground(new Color(0, 103, 0));
        l2.setFont(new Font("Times", Font.PLAIN, 15));

        p1.add(l1);
        p1.add(l2);
        p.add(p1);
        ;

        //panel 2 for text field
        p2 = new JPanel();
        p2.setBackground(new Color(60, 70, 92));
        t1 = new JPasswordField(2);

        t1.setFont(new Font("sans", Font.PLAIN, 36));
        t1.setEditable(false);

        t1.addActionListener(this);
        p2.add(t1);
        p.add(p2);


        //panel3 for buttons
        p3 = new JPanel();
        p3.setBackground(new Color(60, 70, 92));
        p3.setLayout(new GridLayout(0, 3, 5, 5));
        p3.setSize(400, 400);

        //for loop to make 1-9 buttons
        for (int i = 1; i < 10; i++) {
            b = new JButton(String.valueOf(i));
           // b.setBorder(border);
            b.setBackground(new Color(91, 91, 91));
            b.setForeground(new Color(228, 228, 228));
            b.addActionListener(this);
            p3.add(b);
        }

        //button zero and delete
        delete = new JButton("<");
        delete.addActionListener(this);
        delete.setPreferredSize(new Dimension(125, 35));

        delete.setBackground(new Color(91, 91, 91));
        delete.setForeground(new Color(228, 228, 228));
        b4 = new JButton("0");
        b4.addActionListener(this);
        b4.setPreferredSize(new Dimension(125, 35));

        b4.setBackground(new Color(91, 91, 91));
        b4.setForeground(new Color(228, 228, 228));
        p6 = new JPanel();
        p6.setBackground(new Color(60, 70, 92));
        p6.add(b4);
        p6.add(delete);

        p.add(p3);
        p.add(p6);

        // panel 4 for login and exit buttons
        p5 = new JPanel();
        p5.setBackground(new Color(60, 70, 92));
        p.add(p5);
        p4 = new JPanel();
        p4.setBackground(new Color(60, 70, 92));
        p4.setSize(400, 400);

        // Login button / button 2 customization
        b2 = new JButton("Login");
        b2.addActionListener(this);
        b2.setPreferredSize(new Dimension(100, 50));
        b2.setBackground(new Color(0, 103, 0));
        b2.setForeground(Color.white);


        // EXIT button / button 3 customization
        b3 = new JButton("Exit");
        b3.addActionListener(this);
        b3.setPreferredSize(new Dimension(100, 50));
        b3.setBackground(new Color(103, 0, 0));
        b3.setForeground(Color.white);


        // Create new account button
        newacc = new JButton("Sign-up");
        newacc.addActionListener(this);
        newacc.setPreferredSize(new Dimension (100,50));
        newacc.setBackground(new Color(0,103,0));
        newacc.setForeground(Color.white);


        p4.add(b2);
        p4.add(b3);
        p4.add(newacc);
        p.add(p4);
        this.add(p);
    }

    public void verify() {

        String buffer = (t1.getText());
        if (p.get_data(buffer)) {
            MainPage m = new MainPage();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Pin is incorrect please try again", "Failed Login", JOptionPane.ERROR_MESSAGE);
            t1.setText("");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Login":
                verify();
                break;
            case "Exit":

                System.exit(0);
                break;
            //for numbers
            case "0":
                t1.setText(t1.getText() + 0);
                delete.setEnabled(true);
                break;
            case "1":
                t1.setText(t1.getText() + 1);
                delete.setEnabled(true);
                break;
            case "2":
                t1.setText(t1.getText() + 2);
                delete.setEnabled(true);
                break;
            case "3":
                t1.setText(t1.getText() + 3);
                delete.setEnabled(true);
                break;
            case "4":
                t1.setText(t1.getText() + 4);
                delete.setEnabled(true);
                break;
            case "5":
                t1.setText(t1.getText() + 5);
                delete.setEnabled(true);
                break;
            case "6":
                t1.setText(t1.getText() + 6);
                delete.setEnabled(true);
                break;
            case "7":
                t1.setText(t1.getText() + 7);
                delete.setEnabled(true);
                break;
            case "8":
                t1.setText(t1.getText() + 8);
                delete.setEnabled(true);
                break;
            case "9":
                t1.setText(t1.getText() + 9);
                delete.setEnabled(true);
                break;

            case "<":
                if(!t1.getText().isEmpty() ){
                String text = t1.getText();
                text = text.substring(0,text.length()-1);
                t1.setText(text);
                }
                else{JOptionPane.showMessageDialog(this, "Password field is already empty ");
                delete.setEnabled(false);}
                break;

            case "Sign-up":
                SignUp s = new SignUp();
                default:
            }


        }


}


