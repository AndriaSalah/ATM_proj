package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditCard extends JFrame implements ActionListener {

        JButton b1,b2,b3;
        JTextField t1,t2;
        JLabel l1,l2;
        JPanel pb,p1,p2,p3;
        Color c =new Color(60, 70, 92);
        Font f = new Font("SansSerif",Font.PLAIN,17);
        Font f2 = new Font("SansSerif",Font.PLAIN,34);
        CustomerInfo l = new CustomerInfo();
        public CreditCard (){
            this.setTitle("National Bank Of Egypt ATM");
            this.setVisible(true);
            this.setSize(555, 363);
            this.setLocationRelativeTo(null);

            //base panel
            pb = new JPanel(new GridLayout(3,1,0,100));
            pb.setBackground(c);


            //balance info panel
            p1 = new JPanel(new GridLayout(1,2,100,100));
            p1.setBackground(c);
            l1 = new JLabel("Amount Owed : ");
            l1.setForeground(Color.white);
            l1.setFont(f);
            t1 = new JTextField();
            t1.setText(String.valueOf(l.owe[l.index]));
            t1.setEditable(false);
            p1.add(l1);
            p1.add(t1);
            //deposit entry
            p2= new JPanel(new GridLayout(1,2,100,100));
            p2.setBackground(c);
            l2 = new JLabel("Amount deposited : ");
            l2.setForeground(Color.white);
            l2.setFont(f);
            t2 = new JTextField();
            t2.addActionListener(this);
            p2.add(l2);
            p2.add(t2);

            //buttons
            p3 = new JPanel(new GridLayout(1,3,100,100));
            p3.setBackground(c);
            b1 = new JButton("Pay Now");
            b1.addActionListener(this);
            b1.setFont(f);
            b1.setBackground(new Color(91, 91, 91));
            b1.setForeground(new Color(228, 228, 228));
            b2 = new JButton("Clear");
            b2.addActionListener(this);
            b2.setFont(f);
            b2.setBackground(new Color(91, 91, 91));
            b2.setForeground(new Color(228, 228, 228));
            b3 = new JButton("Cancel");
            b3.addActionListener(this);
            b3.setFont(f);
            b3.setBackground(new Color(91, 91, 91));
            b3.setForeground(new Color(228, 228, 228));
            p3.add(b1);
            p3.add(b2);
            p3.add(b3);

            pb.add(p1);
            pb.add(p2);
            pb.add(p3);
            this.add(pb);

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()){

                case "Pay Now" :

                    if(checkowe()) {
                        check(Integer.parseInt(t2.getText()));
                        JOptionPane.showMessageDialog(this, "money is deposited into your card successfully");
                        t2.setText("");}
                    else{ t2.setText("");}

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
            if (l.owe[l.index]-num < 0 ){
                num -= l.owe[l.index];
                l.owe[l.index] = 0 ;
                JOptionPane.showMessageDialog(this, "Returning extra " + num + " cash that was deposited ");
                 t1.setText(String.valueOf(l.owe[l.index]));
                 t2.setText("");}
            else{
                l.owe[l.index] -= num;
                t1.setText(String.valueOf(l.owe[l.index]));
                t2.setText("");

            }
        }
        public boolean checkowe(){
            if (l.owe[l.index]== 0 ){
             JOptionPane.showMessageDialog(this, "This account does not owe anything ");
            t2.setText("");
            return false;
            }
            else
                return true;
        }

    }
