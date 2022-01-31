package atm;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fawry extends JFrame implements ActionListener {

    JPanel pb, p1, p2;
    JLabel l1, l2, l3;
    JTextField t1, t2;
    JButton b1, b2;

    Font f = new Font("SansSerif", Font.BOLD, 10);
    Font f2 = new Font("SansSerif", Font.ITALIC, 20);
    Border border = new LineBorder(Color.BLACK, 2, false);
    ImageIcon icon = createImageIcon("image/icon.png", "Fawry logo");
    Color c = new Color(60, 70, 92);

    public Fawry() {
        this.setTitle("National Bank Of Egypt ATM");
        this.setVisible(true);
        this.setSize(333, 395);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        pb = new JPanel(new GridLayout(3, 1));
        pb.setBackground(c);
        l1 = new JLabel(icon);
        pb.add(l1);

        p1 = new JPanel();
        p1.setBackground(c);
        l2 = new JLabel("enter phone Number");
        l2.setForeground(Color.white);
        t1 = new JTextField();
        t1.setColumns(20);
        l3 = new JLabel("recharge amount");
        l3.setForeground(Color.white);
        t2 = new JTextField();
        t2.setColumns(20);

        p2 = new JPanel();
        p2.setBackground(c);
        b1 = new JButton("Recharge");
        b1.addActionListener(this);
        b1.setPreferredSize(new Dimension(100, 35));
        b1.setBackground(new Color(91, 91, 91));
        b1.setForeground(new Color(228, 228, 228));
        b2 = new JButton("Cancel");
        b2.addActionListener(this);
        b2.setPreferredSize(new Dimension(100, 35));
        b2.setBackground(new Color(91, 91, 91));
        b2.setForeground(new Color(228, 228, 228));

        p1.add(l2);
        p1.add(t1);
        p1.add(l3);
        p1.add(t2);
        p2.add(b1);
        p2.add(b2);
        pb.add(l1);
        pb.add(p1);
        pb.add(p2);
        this.add(pb);

    }

    /**
     * Returns an ImageIcon, or null if the path was invalid.
     */
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Recharge":
                JOptionPane.showMessageDialog(this, "Recharge was completed successfully");
                t1.setText("");
                t2.setText("");
                break;
            case "Cancel":
                this.dispose();
                break;
        }
    }
}
