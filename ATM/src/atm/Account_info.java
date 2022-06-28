package atm;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Account_info extends JFrame {

    JPanel pb, p1, p2, p3, p4, p5;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;

    CustomerDataSQL p = new CustomerDataSQL();
    Font f = new Font("SansSerif", Font.BOLD, 20);
    Font f2 = new Font("SansSerif", Font.ITALIC, 20);
    Border border = new LineBorder(Color.BLACK, 2, false);

    public Account_info() {
        FlatDarkLaf.setup();
        UIManager.put( "Button.arc", 20 );
        UIManager.put( "Component.arc", 20 );
        UIManager.put( "ProgressBar.arc", 20 );
        UIManager.put( "TextComponent.arc", 20 );
        this.setTitle("National Bank Of Egypt ATM");
        this.setVisible(true);
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);

        pb = new JPanel(new GridLayout(5, 1));
        pb.setBorder(border);
        pb.setBackground(new Color(2, 94, 2));

        p1 = new JPanel(new BorderLayout());
        p1.setBackground(new Color(2, 94, 2));
        l1 = new JLabel("Name          : ");
        l1.setFont(f);
        l1.setForeground(new Color(228, 228, 228));
        l2 = new JLabel(p.Owner_Name, SwingConstants.CENTER);
        l2.setFont(f2);
        l2.setForeground(new Color(252, 194, 0));
        p1.add(l1, BorderLayout.WEST);
        p1.add(l2, BorderLayout.CENTER);

        p2 = new JPanel(new BorderLayout());
        p2.setBackground(new Color(2, 94, 2));
        l3 = new JLabel("Mobile number : ");
        l3.setFont(f);
        l3.setForeground(new Color(228, 228, 228));
        l4 = new JLabel(p.mobile, SwingConstants.CENTER);
        l4.setFont(f2);
        l4.setForeground(new Color(252, 194, 0));
        p2.add(l3, BorderLayout.WEST);
        p2.add(l4, BorderLayout.CENTER);

        p3 = new JPanel(new BorderLayout());
        p3.setBackground(new Color(2, 94, 2));
        l5 = new JLabel("AccountID      : ");
        l5.setFont(f);
        l5.setForeground(new Color(228, 228, 228));
        l6 = new JLabel(p.account_id, SwingConstants.CENTER);
        l6.setFont(f2);
        l6.setForeground(new Color(252, 194, 0));
        p3.add(l5, BorderLayout.WEST);
        p3.add(l6, BorderLayout.CENTER);

        p4 = new JPanel(new BorderLayout());
        p4.setBackground(new Color(2, 94, 2));
        l7 = new JLabel("Card Number    : ");
        l7.setFont(f);
        l7.setForeground(new Color(228, 228, 228));
        l8 = new JLabel(p.cards, SwingConstants.CENTER);
        l8.setFont(f2);
        l8.setForeground(new Color(252, 194, 0));
        p4.add(l7, BorderLayout.WEST);
        p4.add(l8, BorderLayout.CENTER);

        p5 = new JPanel(new BorderLayout());
        p5.setBackground(new Color(2, 94, 2));
        l9 = new JLabel("Balance        : ");
        l9.setFont(f);
        l9.setForeground(new Color(228, 228, 228));
        l10 = new JLabel(String.valueOf(p.balance), SwingConstants.CENTER);
        l10.setFont(f2);
        l10.setForeground(new Color(252, 194, 0));
        p5.add(l9, BorderLayout.WEST);
        p5.add(l10, BorderLayout.CENTER);

        pb.add(p1);
        pb.add(p2);
        pb.add(p3);
        pb.add(p4);
        pb.add(p5);
        this.add(pb);
    }

}
