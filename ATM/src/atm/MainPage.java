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

public class MainPage extends JFrame {
    public MainPage() {
        //initialization
        JPanel p, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12;
        JButton b,b2,b3,b4,b5,b6;
        JLabel l1;

        //base panel
        p = new JPanel();
        p.setLayout(new GridLayout(0,2)) ;


        //label 1 panel

        p1 = new JPanel();
        l1= new JLabel("National Bank of Egypt Services");
        l1.setFont(new Font("times",Font.BOLD+Font.ITALIC,33));
        p1.add(l1);
        this.add(p1);


        //rest of the body

        //button 1

        p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        b = new JButton("withdrawal");
        p2.add(b,"Center");
        p.add(p2);

        //button 2

        p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        b2 = new JButton("balance information");
        p3.add(b2,"Center");
        p.add(p3);

        p4 = new JPanel();
        p4.setLayout(new BorderLayout());
        b3 = new JButton("put money");
        p4.add(b3,"Center");
        p.add(p4);

        p5 = new JPanel();
        p5.setLayout(new BorderLayout());
        b4 = new JButton("balance information");
        p5.add(b4,"Center");
        p.add(p5);

        p6 = new JPanel();
        p6.setLayout(new BorderLayout());
        b5 = new JButton("balance information");
        p6.add(b5,"Center");
        p.add(p6);

        p7 = new JPanel();
        p7.setLayout(new BorderLayout());
        b6 = new JButton("balance information");
        p7.add(b6,"Center");
        p.add(p7);

        this.add(p);
    }
}
