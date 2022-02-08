package atm;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditCard extends JFrame implements ActionListener {

        JButton b1,b2,b3;
        JTextField t1,t2,t3;
        JLabel l1,l2,l3;
        JPanel pb,p1,p2,p3,p4;
        Color c =new Color(60, 70, 92);
        Font f = new Font("SansSerif",Font.PLAIN,17);
        Font f2 = new Font("SansSerif",Font.PLAIN,34);
        JCheckBox chk = new JCheckBox("pay from account");


        static CustomerData p = new CustomerData();
        public CreditCard (){

            FlatDarkLaf.setup();
            UIManager.put( "Button.arc", 20 );
            UIManager.put( "Component.arc", 20 );
            UIManager.put( "ProgressBar.arc", 20 );
            UIManager.put( "TextComponent.arc", 20 );
            
            this.setTitle("National Bank Of Egypt ATM");
            this.setVisible(true);
            this.setSize(560, 363);
            this.setLocationRelativeTo(null);

            //base panel
            pb = new JPanel(new GridLayout(4,1,0,50));
            pb.setBackground(c);


            //balance info panel
            p1 = new JPanel(new GridLayout(1,2,100,0));
            p1.setBackground(c);
            l1 = new JLabel("Amount Owed : ");
            l1.setForeground(Color.white);
            l1.setFont(f);
            t1 = new JTextField();
            t1.setText(String.valueOf(p.owe));
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
            p3 = new JPanel(new GridLayout(1,4,15,100));
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
            chk.addActionListener(this);
            chk.setBackground(c);
            chk.setForeground(Color.white);
            p3.add(chk);
            p3.add(b1);
            p3.add(b2);
            p3.add(b3);

            p4 = new JPanel(new GridLayout(1,3,100,100));
            p4.setBackground(c);
            l3 = new JLabel("Avaialble balance");
            l3.setForeground(Color.white);
            l3.setFont(f);
            t3 = new JTextField();
            //t3.setBackground(new Color(212, 212, 212));
            t3.setEditable(false);
            t3.setText(Integer.toString(p.balance));
            p4.add(l3);
            p4.add(t3);
            pb.add(p1);
            pb.add(p2);
            pb.add(p4);

            pb.add(p3);
            this.add(pb);

        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (chk.isSelected()){
                t2.setEditable(false);
            }
            else t2.setEditable(true);

            switch (e.getActionCommand()){

                case "Pay Now" :
                    if(chk.isSelected()){
                        if(checkowe()) {
                            if (checkBalance()) {
                                if (checkb()) {
                                    JOptionPane.showMessageDialog(this, "money is deposited into your card successfully");
                                    p.place.add("Internal Credit payment");
                                    t2.setText("");
                                    p.flush();
                                    break;
                                }
                                JOptionPane.showMessageDialog(this,"operation canceled successfully");
                            }
                        }

                        break;

                    }
                    else if(checkowe()) {
                        check(Integer.parseInt(t2.getText()));
                        JOptionPane.showMessageDialog(this, "money is deposited into your card successfully");
                        p.place.add("Credit payment");
                        t2.setText("");
                        p.flush();
                    }
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
            if (p.owe-num < 0 ){
                p.price.add(p.owe);
                num -= p.owe;
                p.owe = 0 ;
                JOptionPane.showMessageDialog(this, "Returning extra " + num + " cash that was deposited ");
                 t1.setText(String.valueOf(p.owe));
                 t2.setText("");}
            else{
                p.owe -= num;
                p.price.add(num);
                t1.setText(String.valueOf(p.owe));
                t2.setText("");

            }
        }
        public boolean checkowe(){
            if (p.owe == 0 ){
             JOptionPane.showMessageDialog(this, "This account does not owe anything ");
            t2.setText("");
            return false;
            }
            else
                return true;
        }
        public boolean checkb(){

            if(p.owe < p.balance){
            p.price.add(p.owe);
            p.balance -= p.owe;
            p.owe=0;
            t1.setText(String.valueOf(p.owe));
            t3.setText(String.valueOf(p.balance));
            return true;
            }
          else{
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, "Available balance is insufficient to pay all the owed amount\nWould you like to use the availble amount anyway ? ", "Title on Box", dialogButton);
                System.out.println(dialogResult);
            if(dialogResult == 0){
                p.price.add(p.balance);
                p.owe -= p.balance;
                p.balance = 0;
                t1.setText(String.valueOf(p.owe));
                t3.setText(String.valueOf(p.balance));
                return true;
            }
            else  return false;
            }

        }
        public boolean checkBalance(){
            if(p.balance == 0 ){
                JOptionPane.showMessageDialog(this, "Balance available is insufficient");
                return false;
            }
            else return true;
        }

    }
