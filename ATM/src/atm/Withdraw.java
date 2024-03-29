package atm;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Withdraw extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    JTextField t1,t2;
    JLabel l1,l2;
    JPanel pb,p1,p2,p3;
    Color c =new Color(60, 70, 92);
    Font f = new Font("SansSerif",Font.PLAIN,17);
    Font f2 = new Font("SansSerif",Font.PLAIN,34);

    CustomerDataSQL p = new CustomerDataSQL();

    public Withdraw ( ){
        //sets how the ui components would look like
        FlatDarkLaf.setup();
        UIManager.put( "Button.arc", 20 );
        UIManager.put( "Component.arc", 20 );
        UIManager.put( "ProgressBar.arc", 20 );
        UIManager.put( "TextComponent.arc", 20 );

        // sets the title that would be shown in the title bar
        this.setTitle("National Bank Of Egypt ATM");
        this.setVisible(true);
        this.setSize(555, 363);
        this.setLocationRelativeTo(null);

        //base panel that will have all the other panels added to it
        //basically we divide our design into a series of panels that will have some specific components as some times
        //a single panel with single design won't fulfill the design we want it to have
        pb = new JPanel(new GridLayout(3,1,0,100));
        pb.setBackground(c);


        //balance info panel
        p1 = new JPanel(new GridLayout(1,2,100,100));
        p1.setBackground(c);
        l1 = new JLabel("Available balance : ");
        l1.setForeground(Color.white);
        l1.setFont(f);
        t1 = new JTextField();
        t1.setText(String.valueOf(p.balance));
        t1.setEditable(false);
        p1.add(l1);
        p1.add(t1);

        //deposit entry
        p2= new JPanel(new GridLayout(1,2,100,100));
        p2.setBackground(c);
        l2 = new JLabel("Amount withdrawn : ");
        l2.setForeground(Color.white);
        l2.setFont(f);
        t2 = new JTextField();
        t2.addActionListener(this);
        p2.add(l2);
        p2.add(t2);

        //buttons
        //panel init
        p3 = new JPanel(new GridLayout(1,3,100,100));
        p3.setBackground(c);
        //panel init end

        //withdraw start
        b1 = new JButton("Withdraw");
        b1.addActionListener(this);
        b1.setFont(f);
        b1.setBackground(new Color(91, 91, 91));
        b1.setForeground(new Color(228, 228, 228));
        //withdraw end

        //clear start
        b2 = new JButton("Clear");
        b2.addActionListener(this);
        b2.setFont(f);
        b2.setBackground(new Color(91, 91, 91));
        b2.setForeground(new Color(228, 228, 228));
        //clear end

        //cancel start
        b3 = new JButton("Cancel");
        b3.addActionListener(this);
        b3.setFont(f);
        b3.setBackground(new Color(91, 91, 91));
        b3.setForeground(new Color(228, 228, 228));
        //cancel end

        //adding components to the panel
        p3.add(b1);
        p3.add(b2);
        p3.add(b3);

        //adding the customised panels to the base panel then adding the base panel to the frame
        pb.add(p1);
        pb.add(p2);
        pb.add(p3);
        this.add(pb);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){

            case "Withdraw" :
                if (checkbalance()){
                check(Integer.parseInt(t2.getText()));
                JOptionPane.showMessageDialog(this,"money is withdrawn successfully");
                t2.setText("");
                p.place="withdraw";
                p.flushtodb();
                p.GetHistoryfromdb();

                }
                else {t2.setText("");}

                break;
            case "Clear" :
                t2.setText("");
                break;
            case "Cancel":
                this.dispose();
                break;
        }
    }
    public void check(int num){
        if (p.balance-num < 0 ){
            num -= p.balance;
            p.balance = 0;
            JOptionPane.showMessageDialog(this, "couldn't withdraw this extra " + num + " in cash ");
            t1.setText(String.valueOf(p.balance));
            t2.setText("");
            p.price=p.balance;
        }
        else{
            p.balance -= num;
            p.price=num;
            t1.setText(String.valueOf(p.balance));
            t2.setText("");

        }
    }
    public boolean checkbalance(){
        if (p.balance == 0 ){
            JOptionPane.showMessageDialog(this, "Balance available is not enough to withdraw this amount ");
            t2.setText("");
            return false;
        }
        else
            return true;
    }

}

