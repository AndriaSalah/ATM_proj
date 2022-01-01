/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public  class MainPage extends JFrame implements ActionListener {

    JButton balance_info,deposit,withdraw,accounts,pay_credit,fawry ;
    Color c =new Color(60, 70, 92);
    Dimension d = new Dimension(200,50);
    Font f = new Font("SansSerif",Font.PLAIN,17);
    Font f2 = new Font("SansSerif",Font.PLAIN,34);
    CustomerInfo l = new CustomerInfo();
    int index;
    int balance = l.balance[index];
    String holder= l.holders[index];
    String account_id=l.account_id[index];


    public MainPage(int num) {

        index = num;
        //frame specs
        this.setTitle("National Bank Of Egypt ATM");
        this.setVisible(true);
        this.setSize(755, 463);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel l1 = new JLabel("National bank of Egypt services",SwingConstants.CENTER) ;
    l1.setFont(f2);
    l1.setForeground(Color.WHITE);
    JPanel pb,p1,p2,p3,p4 ;
    pb = new JPanel(new GridLayout(4,1,20,20));
    pb.setBackground(c);

    //title
    p1= new JPanel(new GridLayout(1,1,20,20));
    p1.setBackground(new Color(2, 94, 2));
    p1.setBorder(new EtchedBorder(3));
    p1.add(l1,SwingConstants.CENTER);

    //first 2 buttons
    p2 = new JPanel(new BorderLayout());
    p2.setBackground(c);
    balance_info = new JButton("BALANCE HISTORY");
        balance_info.setPreferredSize(d);
        balance_info.setFont(f);
        balance_info.setBackground(new Color(91, 91, 91));
        balance_info.setForeground(new Color(228, 228, 228));
        balance_info.addActionListener(this);
    deposit = new JButton("DEPOSIT");
        deposit.setPreferredSize(d);
        deposit.setFont(f);
        deposit.setBackground(new Color(91, 91, 91));
        deposit.setForeground(new Color(228, 228, 228));
        deposit.addActionListener(this);
    p2.add(balance_info,BorderLayout.EAST);
    p2.add(deposit,BorderLayout.WEST);

    // second 2 buttons
    p3= new JPanel(new BorderLayout());
    p3.setBackground(c);
    withdraw = new JButton("WITHDRAW");
        withdraw.setPreferredSize(d);
        withdraw.setFont(f);
        withdraw.setBackground(new Color(91, 91, 91));
        withdraw.setForeground(new Color(228, 228, 228));
        withdraw.addActionListener(this);
    accounts = new JButton("ACCOUNT INFO");
        accounts.setPreferredSize(d);
        accounts.setFont(f);
        accounts.setBackground(new Color(91, 91, 91));
        accounts.setForeground(new Color(228, 228, 228));
        accounts.addActionListener(this);
    p3.add(withdraw,BorderLayout.EAST);
    p3.add(accounts,BorderLayout.WEST);

    //third 2 buttons
    p4 = new JPanel(new BorderLayout());
    p4.setBackground(c);
    pay_credit = new JButton("CREDIT CARD");
        pay_credit.setPreferredSize(d);
        pay_credit.setFont(f);
        pay_credit.setBackground(new Color(91, 91, 91));
        pay_credit.setForeground(new Color(228, 228, 228));
        pay_credit.addActionListener(this);
    fawry = new JButton("FAWRY");
        fawry.setPreferredSize(d);
        fawry.setFont(f);
        fawry.setBackground(new Color(91, 91, 91));
        fawry.setForeground(new Color(228, 228, 228));
        fawry.addActionListener(this);
    p4.add(pay_credit,BorderLayout.EAST);
    p4.add(fawry,BorderLayout.WEST);

    //add to base
        pb.add(p1);
        pb.add(p2);
        pb.add(p3);
        pb.add(p4);
        this.add(pb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()){
        case "DEPOSIT":
            Deposit d = new Deposit(index);
            break;
        case "BALANCE HISTORY":
            //BalanceInfo b = new BalanceHistory();
            //this.dispose();
        case "ACCOUNT INFO":
            //AccountInfo i = new AccountInfo();
            //this.dispose();
        case "WITHDRAW":
            Withdraw w = new Withdraw(index);
            break;
            //this.dispose();
        case "FAWRY":
            //Fawry f = new Fawry();
            //this.dispose();
        case "CREDIT CARD":
            //CreditCard c = new CreditCard();
            //this.dispose();

    }

    }
}

