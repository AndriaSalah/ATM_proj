/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class Login extends JFrame {
    //frame stuff
    public Login() {
        //panel init
        JPanel p = new JPanel();
        p.setBackground(new Color(166, 163, 163));
        JPanel p1, p2, p3, p4, p5, p6;

        p.setLayout(new GridLayout(6, 1));

        //component init
        TextField t1;
        JButton b, b2, b3, b4;

        JLabel l1, l2;

        //panel 1 fr labels
        p1 = new JPanel();
        p1.setLayout(new GridLayout(2, 1));
        l1 = new JLabel("Welcome to the National Bank Of Egypt", SwingConstants.CENTER);
        l2 = new JLabel("Please enter your pin", SwingConstants.CENTER);
        l1.setFont(new Font("Times", Font.BOLD, 20));
        l1.setForeground(Color.white);
        l1.setOpaque(true);
        l1.setBackground(new Color(0, 153, 0));
        l1.setBorder(new LineBorder(Color.white));
        l2.setFont(new Font("Times", Font.PLAIN, 15));

        p1.add(l1);
        p1.add(l2);
        p.add(p1);
        //frame1.add(p);


        //panel 2 for text field
        p2 = new JPanel();
        t1 = new TextField();
        t1.setPreferredSize(new Dimension(125, 50));
        p2.add(t1);
        p.add(p2);
        //frame1.add(p);

        //panel3 for buttons
        p3 = new JPanel();

        p3.setLayout(new GridLayout(0, 3, 5, 5));
        p3.setSize(400, 400);
        for (int i = 1; i < 10; i++) {
            b = new JButton(String.valueOf(i));
            b.setBorder(new SoftBevelBorder(1));
            //b.setBackground(Color.white);
            p3.add(b);
        }

        //button zero
        b4 = new JButton("0");
        b4.setPreferredSize(new Dimension(125, 35));
        b4.setBorder(new SoftBevelBorder(1));

        p6 = new JPanel();
        p6.add(b4);

        p.add(p3);
        p.add(p6);


        // panel 4 for login and exit buttons

        p5 = new JPanel();
        p.add(p5);
        p4 = new JPanel();
        p4.setSize(400, 400);

        // Login button / button 2 customization

        b2 = new JButton("Login");
        b2.setPreferredSize(new Dimension(150, 50));
        b2.setBackground(new Color(0, 153, 0));
        b2.setForeground(Color.white);
        b2.setBorder(new EtchedBorder(1));

        // EXIT button / button 3 customization

        b3 = new JButton("Exit");
        b3.setPreferredSize(new Dimension(150, 50));
        b3.setBackground(new Color(153, 0, 0));
        b3.setForeground(Color.white);
        b3.setBorder(new EtchedBorder(1));
        p4.add(b2);
        p4.add(b3);
        p.add(p4);
        this.add(p);
    }
}
