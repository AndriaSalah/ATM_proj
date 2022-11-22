package atm;

import javax.swing.*;
import java.awt.*;

public class test_loading {
    ImageIcon loading = new ImageIcon("G:\\Projects\\ATM_proj\\ATM\\src\\atm\\Image\\loading1.gif");
    JLabel l = new JLabel( loading, JLabel.CENTER);
    public test_loading(){
        JFrame f = new JFrame();
        JPanel p = new JPanel(new BorderLayout());
        p.add(l,BorderLayout.CENTER);
        f.add(p);
        f.setVisible(true);
        f.setSize(600,600);
        f.setLocationRelativeTo(null);
        f.setGlassPane(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color (0,0,0,150));
                g.fillRect(0,0,getWidth(),getHeight());
            }
        });
    }
}
