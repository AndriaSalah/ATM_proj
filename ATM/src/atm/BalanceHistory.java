package atm;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceHistory extends JFrame implements ActionListener {

    CustomerInfo l = new CustomerInfo();
    Font f = new Font("SansSerif", Font.ITALIC, 17);
    Font f2 = new Font("SansSerif", Font.PLAIN, 24);
    Color c = new Color(60, 70, 92);
    JLabel l1, l2, l3, l4;
    JScrollPane sc = new JScrollPane();
    JPanel pb, p1, p2, p3, p4;
    JButton b1;
    Border border = new LineBorder(new Color(190,192,203),1,false);
    // Border border2 = new LineBorder(Color.WHITE,1,false);
    public BalanceHistory() {
        this.setTitle("National Bank Of Egypt ATM");
        this.setVisible(true);
        this.setSize(755, 463);
        this.setLocationRelativeTo(null);
        pb = new JPanel(new GridLayout(1, 2));

        p1 = new JPanel(new GridLayout(2, 1));
            p1.setBackground(c);
        p2 = new JPanel(new BorderLayout());
            p2.setBackground(c);
            p2.setBorder(border);
        l1 = new JLabel("Name");
            l1.setFont(new Font("SansSerif",Font.PLAIN,34));
            l1.setForeground(new Color(228, 228, 228));
        l2 = new JLabel("", SwingConstants.CENTER);
            l2.setFont(f);
            l2.setForeground(new Color(228, 228, 228));


        l2.setText(l.holders[l.index]);
        p2.add(l1, BorderLayout.WEST);
        p2.add(l2, BorderLayout.CENTER);
        p1.add(p2);

        p3 = new JPanel(new BorderLayout());
            p3.setBackground(c);
            p3.setBorder(border);
        l3 = new JLabel("Credit Card Number");
            l3.setFont(f2);
            l3.setForeground(new Color(228, 228, 228));


        l4 = new JLabel("", SwingConstants.CENTER);
            l4.setFont(f);
            l4.setForeground(new Color(228, 228, 228));

        l4.setText(l.cards[l.index]);

        p3.add(l3, BorderLayout.WEST);
        p3.add(l4, BorderLayout.CENTER);
        p1.add(p3);
        pb.add(p1);
        p4 = new JPanel(new GridLayout(1, 1));
            p4.setBackground(c);

        JTable T1 = new JTable(l.History, new String[]{"places", "prices"});
        T1.setBackground(new Color(2, 94, 2));
        T1.setFont(f);
        T1.setForeground(Color.white);
        T1.setBorder(border);
        p4.add(T1);

        pb.add(p4);
        this.add(pb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
