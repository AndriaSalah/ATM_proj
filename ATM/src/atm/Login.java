/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class Login extends JFrame implements ActionListener {
    //frame stuff
    JPasswordField t1;
    JButton b, b2, b3, b4;

    public Login() {

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
        l1.setBackground(new Color(194, 123, 85));
        l1.setBorder(new EtchedBorder(3));
        l2.setFont(new Font("Times", Font.PLAIN, 15));


        p1.add(l1);
        p1.add(l2);
        p.add(p1);
        //frame1.add(p);


        //panel 2 for text field
        p2 = new JPanel();
        p2.setBackground(new Color(60, 70, 92));
        t1 = new JPasswordField();
        t1.setPreferredSize(new Dimension(125, 50));
        t1.setFont(new Font("sans",Font.PLAIN,24));
        t1.setEditable(false);
        t1.addActionListener(this);
        p2.add(t1);
        p.add(p2);
        //frame1.add(p);

        //panel3 for buttons
        p3 = new JPanel();
        p3.setBackground(new Color(60, 70, 92));
        p3.setLayout(new GridLayout(0, 3, 5, 5));
        p3.setSize(400, 400);
        for (int i = 1; i < 10; i++) {
            b = new JButton(String.valueOf(i));
            b.setBorder(new SoftBevelBorder(1));
            b.setBackground(new Color(91, 91, 91));
            b.setForeground(new Color(228, 228, 228));
            b.addActionListener(this);
            p3.add(b);
        }

        //button zero
        b4 = new JButton("0");
        b4.setPreferredSize(new Dimension(125, 35));
        b4.setBorder(new SoftBevelBorder(1));
        b4.setBackground(new Color(91, 91, 91));
        b4.setForeground(new Color(228, 228, 228));
        p6 = new JPanel();
        p6.setBackground(new Color(60, 70, 92));
        p6.add(b4);

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
        b2.setPreferredSize(new Dimension(150, 50));
        b2.setBackground(new Color(0, 153, 0));
        b2.setForeground(Color.white);
        b2.setBorder(new EtchedBorder(1));

        // EXIT button / button 3 customization

        b3 = new JButton("Exit");
        b3.addActionListener(this);
        b3.setPreferredSize(new Dimension(150, 50));
        b3.setBackground(new Color(153, 0, 0));
        b3.setForeground(Color.white);
        b3.setBorder(new EtchedBorder(1));
        p4.add(b2);
        p4.add(b3);
        p.add(p4);
        this.add(p);
    }
    public void verify(){
         String password = "5115";
         String buffer = t1.getText() ;
         if(buffer.equals(password)){
             MainPage m = new MainPage();
             this.dispose();
         }
         else{JOptionPane.showMessageDialog(this,"Pin is incorrect please try again");
         t1.setText("");
         }

    t1.getText();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Login":
                verify();
                //MainPage m = new MainPage();
                //this.dispose();
                break;
            case "Exit":

                System.exit(0);
                break;
            //for numbers
            case "0":
                t1.setText(t1.getText()+0);
                break;
            case "1":
                t1.setText(t1.getText()+1);
                break;
            case "2":
                t1.setText(t1.getText()+2);
                break;
            case "3":
                t1.setText(t1.getText()+3);
                break;
            case "4":
                t1.setText(t1.getText()+4);
                break;
            case "5":
                t1.setText(t1.getText()+5);
                break;
            case "6":
                t1.setText(t1.getText()+6);
                break;
            case "7":
                t1.setText(t1.getText()+7);
                break;
            case "8":
                t1.setText(t1.getText()+8);
                break;
            case "9":
                t1.setText(t1.getText()+9);
                break;
            default:

        }
    }
}
