/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainPage extends JFrame implements ActionListener, MouseListener {

    JButton balance_info, deposit, withdraw, accounts, pay_credit, Fawry,Transfer ,Logout;
    Dimension d = new Dimension(200, 50);
    Color c = new Color(60, 70, 92);
    Font f = new Font("SansSerif", Font.PLAIN, 17);
    Font f2 = new Font("SansSerif", Font.PLAIN, 34);
    CustomerDataSQL p = new CustomerDataSQL();
    ImageIcon icon = createImageIcon("image/download.png", "bank logo");
    //ImageIcon loading = new ImageIcon("Image/loading.gif");
    //JLabel l = new JLabel( loading, JLabel.CENTER);
    JPanel pb, p1, p2, p3, p4,panimation;
    JLabel l1 = new JLabel("Welcome, "+p.Owner_Name,icon,SwingConstants.CENTER) ;
    public MainPage() {
        FlatDarkLaf.setup();
        UIManager.put( "Button.arc", 20 );
        UIManager.put( "Component.arc", 20 );
        UIManager.put( "ProgressBar.arc", 20 );
        UIManager.put( "TextComponent.arc", 20 );

        JFrame.setDefaultLookAndFeelDecorated(true);
        this.getRootPane().putClientProperty("JRootPane.titleBarBackground", new Color(2, 94, 2));
        this.getRootPane().putClientProperty("JRootPane.titleBarForeground", Color.white);

        //frame specs
        this.setTitle("National Bank Of Egypt ATM");
        this.setVisible(true);
        this.setSize(755, 463);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        l1.setFont(f2);
        l1.setForeground(Color.WHITE);
        l1.addMouseListener(this);
        
        pb = new JPanel(new GridLayout(4, 1, 20, 20));
        pb.setBackground(c);
        
        //title
        p1 = new JPanel(new GridLayout(1, 1, 20, 20));
        p1.setBackground(new Color(2, 94, 2));
       
        p1.add(l1, SwingConstants.CENTER);
       

        //first 2 buttons
        p2 = new JPanel(new BorderLayout());
        p2.setBackground(c);

        balance_info = new JButton("BALANCE HISTORY");
        balance_info.setPreferredSize(d);
        balance_info.setFont(f);
        balance_info.setBackground(new Color(91, 91, 91));
        balance_info.setForeground(new Color(228, 228, 228));
        balance_info.addActionListener(this);
        balance_info.addMouseListener(this);

        deposit = new JButton("DEPOSIT");
        deposit.setPreferredSize(d);
        deposit.setFont(f);
        deposit.setBackground(new Color(91, 91, 91));
        deposit.setForeground(new Color(228, 228, 228));
        deposit.addActionListener(this);
        deposit.addMouseListener(this);

        p2.add(balance_info, BorderLayout.EAST);
        p2.add(deposit, BorderLayout.WEST);

        // second 2 buttons
        p3 = new JPanel(new BorderLayout());
        p3.setBackground(c);

        withdraw = new JButton("WITHDRAW");
        withdraw.setPreferredSize(d);
        withdraw.setFont(f);
        withdraw.setBackground(new Color(91, 91, 91));
        withdraw.setForeground(new Color(228, 228, 228));
        withdraw.addActionListener(this);
        withdraw.addMouseListener(this);
        

        accounts = new JButton("ACCOUNT INFO");
        accounts.setPreferredSize(d);
        accounts.setFont(f);
        accounts.setBackground(new Color(91, 91, 91));
        accounts.setForeground(new Color(228, 228, 228));
        accounts.addActionListener(this);
        accounts.addMouseListener(this);

        p3.add(withdraw, BorderLayout.EAST);
        p3.add(accounts, BorderLayout.WEST);

        //third 2 buttons
        p4 = new JPanel(new GridLayout(1,3,70,0));
        p4.setBackground(c);

        pay_credit = new JButton("CREDIT CARD");
        pay_credit.setPreferredSize(d);
        pay_credit.setFont(f);
        pay_credit.setBackground(new Color(91, 91, 91));
        pay_credit.setForeground(new Color(228, 228, 228));
        pay_credit.addActionListener(this);
        pay_credit.addMouseListener(this);

//        Fawry = new JButton("FAWRY");
//        Fawry.setPreferredSize(d);
//        Fawry.setFont(f);
//        Fawry.setBackground(new Color(91, 91, 91));
//        Fawry.setForeground(new Color(228, 228, 228));
//        Fawry.addActionListener(this);
//        Fawry.addMouseListener(this);

        Transfer = new JButton("TRANSFER");
        Transfer.setPreferredSize(d);
        Transfer.setFont(f);
        Transfer.setBackground(new Color(91, 91, 91));
        Transfer.setForeground(new Color(228, 228, 228));
        Transfer.addActionListener(this);
        Transfer.addMouseListener(this);


        Logout = new JButton("Log Out");
        Logout.setPreferredSize(d);
        Logout.setFont(f);
        Logout.setBackground(new Color(103, 0, 0));
        Logout.setForeground(new Color(228, 228, 228));
        Logout.addActionListener(this);
        Logout.setPreferredSize(new Dimension(50, 50));



        p4.add(pay_credit);
        p4.add(Logout);
        p4.add(Transfer);

        //add to base
        pb.add(p1);
        pb.add(p2);
        pb.add(p3);
        pb.add(p4);


        this.add(pb);
        this.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "DEPOSIT":
                Deposit d = new Deposit();
                break;

            case "BALANCE HISTORY":
                BalanceHistory b = new BalanceHistory();
                break;

            case "ACCOUNT INFO":
                Account_info i = new Account_info();
                break;

            case "WITHDRAW":
                Withdraw w = new Withdraw();
                break;

            case "TRANSFER":
                Transfer f = new Transfer();
                break;

            case "CREDIT CARD":
                CreditCard c = new CreditCard();
                break;

            case "Log Out":
                Login_landscape login = new Login_landscape();
                this.dispose();
                break;
            default:
                JOptionPane.showMessageDialog(this, "Function not implemented yet");
        }

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
    public void mouseClicked(MouseEvent ae) {

    }

    @Override
    public void mousePressed(MouseEvent ae) {

    }

    @Override
    public void mouseReleased(MouseEvent ae) {

    }

    @Override
    public void mouseEntered(MouseEvent ae) {

    if(ae.getSource() == balance_info ){
    balance_info.setBackground(new Color(2, 94, 2));
    }
    else if(ae.getSource() == deposit ){
    deposit.setBackground(new Color(2, 94, 2));
    }
      if(ae.getSource() == withdraw ){
    withdraw.setBackground(new Color(2, 94, 2));
    }
       if(ae.getSource() == accounts ){
    accounts.setBackground(new Color(2, 94, 2));
    }
        if(ae.getSource() == pay_credit ){
    pay_credit.setBackground(new Color(2, 94, 2));
    }
        if(ae.getSource() == Transfer ){
    Transfer.setBackground(new Color(2, 94, 2));
    }
    }

    @Override
    public void mouseExited(MouseEvent ae) {
    if(ae.getSource() == balance_info ){
    balance_info.setBackground(new Color(91, 91, 91));
    }
     if(ae.getSource() == deposit ){
    deposit.setBackground(new Color(91, 91, 91));
    }
      if(ae.getSource() == withdraw ){
    withdraw.setBackground(new Color(91, 91, 91));
    }
       if(ae.getSource() == accounts ){
    accounts.setBackground(new Color(91, 91, 91));
    }
        if(ae.getSource() == pay_credit ){
    pay_credit.setBackground(new Color(91, 91, 91));
    }
        if(ae.getSource() == Transfer ){
    Transfer.setBackground(new Color(91, 91, 91));
    }
        
    }
}
