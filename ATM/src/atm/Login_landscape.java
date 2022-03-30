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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Login_landscape extends JFrame implements ActionListener,MouseListener {

    //frame stuff
    JPasswordField pin;
    JButton b, Login, Exit, zero, delete, Sign_up;

    CustomerData p = new CustomerData();
    Border border = new LineBorder(Color.BLACK, 1, true);
    JLabel Header, label;
    public Login_landscape() {
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
        this.setSize(649, 352);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //base panel that will have all the other panels added to it
        //basically we divide our design into a series of panels that will have some specific components as some times
        //a single panel with single design won't fulfill the design we want it to have
        //panel init
        JPanel basepanel =new JPanel (new GridLayout(1,2));
        JPanel extra = new JPanel(new GridLayout(2,1));
        JPanel extra2 = new JPanel(new BorderLayout());
        JPanel p = new JPanel();
        p.setBackground(new Color(60, 70, 92));
        JPanel p1, p2, p3, p4, p5, p6;

        p.setLayout(new BorderLayout());

        //component init
        //JLabel l1, l2;

        //panel 1 fr labels
        p1 = new JPanel();
        p1.setBackground(new Color(60, 70, 92));
        p1.setLayout(new GridLayout(3, 1));
        JPanel empty = new JPanel();
        empty.setBackground(new Color(0, 103, 0));
        Header = new JLabel("Welcome to the National Bank Of Egypt", SwingConstants.CENTER);
        label = new JLabel();
        Header.setFont(new Font("Times", Font.BOLD, 20));
        Header.setForeground(Color.white);
        label.setForeground(Color.white);
        Header.setOpaque(true);
        Header.setBackground(new Color(0, 103, 0));
        label.setFont(new Font("Times", Font.PLAIN, 15));

        p1.add(Header);
        p1.add(empty);
        p1.add(label);
        extra2.add(p1,BorderLayout.NORTH);


        //panel 2 for text field
        p2 = new JPanel();
        p2.setBackground(new Color(60, 70, 92));
        pin = new JPasswordField(3);

        pin.setFont(new Font("sans", Font.PLAIN, 36));
        pin.setEditable(false);

        pin.addActionListener(this);
        p2.add(pin);
        //p.add(p2);


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
        delete.setPreferredSize(new Dimension(35, 35));

        delete.setBackground(new Color(91, 91, 91));
        delete.setForeground(new Color(228, 228, 228));
        p2.add(delete);
        zero = new JButton("0");
        zero.addActionListener(this);
        zero.setPreferredSize(new Dimension(102, 35));

        zero.setBackground(new Color(91, 91, 91));
        zero.setForeground(new Color(228, 228, 228));
        zero.addMouseListener(this);
        p6 = new JPanel();
        p6.setBackground(new Color(60, 70, 92));
        p6.add(zero);
       // p6.add(delete);

        //p.add(p3);
        //p.add(p6);

        // panel 4 for login and exit buttons
        p5 = new JPanel();
        p5.setBackground(new Color(60, 70, 92));
        p.add(p5);
        p4 = new JPanel();
        p4.setBackground(new Color(60, 70, 92));
        p4.setSize(400, 400);

        // Login button / button 2 customization
        Login = new JButton("Login");
        Login.addActionListener(this);
        Login.setPreferredSize(new Dimension(100, 50));
        Login.setBackground(new Color(0, 103, 0));
        Login.setForeground(Color.white);


        // EXIT button / button 3 customization
        Exit = new JButton("Exit");
        Exit.addActionListener(this);
        Exit.setPreferredSize(new Dimension(100, 50));
        Exit.setBackground(new Color(103, 0, 0));
        Exit.setForeground(Color.white);


        // Create new account button
        Sign_up = new JButton("Sign-up");
        Sign_up.addActionListener(this);
        Sign_up.setPreferredSize(new Dimension (100,50));
        Sign_up.setBackground(new Color(0,103,0));
        Sign_up.setForeground(Color.white);

        p.add(p2,BorderLayout.CENTER);
        p4.add(Login);
        p4.add(Exit);
        p4.add(Sign_up);
        p.add(p4,BorderLayout.SOUTH);
        //extra.add(p2);
        extra.add(p3);
        extra.add(p6);
        basepanel.add(p);
        basepanel.add(extra);
        extra2.add(basepanel,BorderLayout.CENTER);
        this.add(extra2);
    }

    public void verify() {

        String buffer = (pin.getText());
        if (p.get_data(buffer)) {
            MainPage m = new MainPage();
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(this, "Pin is incorrect please try again", "Failed Login", JOptionPane.ERROR_MESSAGE);
            pin.setText("");
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
                pin.setText(pin.getText() + 0);

                delete.setEnabled(true);
                break;
            case "1":
                pin.setText(pin.getText() + 1);

                delete.setEnabled(true);
                break;
            case "2":
                pin.setText(pin.getText() + 2);
                delete.setEnabled(true);
                break;
            case "3":
                pin.setText(pin.getText() + 3);
                delete.setEnabled(true);
                break;
            case "4":
                pin.setText(pin.getText() + 4);
                delete.setEnabled(true);
                break;
            case "5":
                pin.setText(pin.getText() + 5);
                delete.setEnabled(true);
                break;
            case "6":
                pin.setText(pin.getText() + 6);
                delete.setEnabled(true);
                break;
            case "7":
                pin.setText(pin.getText() + 7);
                delete.setEnabled(true);
                break;
            case "8":
                pin.setText(pin.getText() + 8);
                delete.setEnabled(true);
                break;
            case "9":
                pin.setText(pin.getText() + 9);
                delete.setEnabled(true);
                break;

            case "<":
                if(!pin.getText().isEmpty() ){
                    String text = pin.getText();
                    text = text.substring(0,text.length()-1);
                    pin.setText(text);
                }
                else{JOptionPane.showMessageDialog(this, "Password field is already empty ");
                    delete.setEnabled(false);}
                break;

            case "Sign-up":
                SignUp s = new SignUp();
            default:
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {


    }


}



