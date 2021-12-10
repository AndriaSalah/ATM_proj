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
        p.setLayout(new GridLayout(3,3)) ;


        //label 1 panel

        p1 = new JPanel();
        l1= new JLabel("National Bank of Egypt Services");
        l1.setFont(new Font("times",Font.BOLD+Font.ITALIC,33));
        p1.add(l1);
        p.add(p1);


        //rest of the body

        //button 1

        p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        b = new JButton("withdrawal");
        p2.add(b,"Center");
        p.add(p2);


    }
}
