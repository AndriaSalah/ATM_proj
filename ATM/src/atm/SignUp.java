package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SignUp extends JFrame implements ActionListener {
    String name;
    String mobile;
    String pin;
    int card_number;
    String account_number;
    StringBuilder sb = new StringBuilder();
    Random rnd = new Random();
    JButton b1,b2;
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    public SignUp() {
        setSize(600,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("National Bank Of Egypt ATM");
        setBackground(new Color(60, 70, 92));
        JPanel pb,p1,p2;
        pb=new JPanel(new GridLayout(2,1,0,50));
        pb.setBackground(new Color(60,70,92));
        p1 = new JPanel(new GridLayout(3,3,0,10));
        p1.setBackground(new Color(60,70,92));
        l1 = new JLabel("Name");
        l1.setForeground(Color.white);
        l2 = new JLabel("Mobile number");
        l2.setForeground(Color.white);
        l3 = new JLabel("Pin");
        l3.setForeground(Color.white);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        pb.add(p1);

        p2 = new JPanel(new FlowLayout());
        p2.setBackground(new Color(60,70,92));
        b1 = new JButton("Sign-Up");
        b1.setPreferredSize(new Dimension(150,80));
        b1.setBackground(new Color(0, 103, 0));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b2 = new JButton("Cancel");
        b2.setBackground(new Color(103, 0, 0));
        b2.setForeground(Color.white);
        b2.setPreferredSize(new Dimension(150,80));
        b2.addActionListener(this);
        p2.add(b1);
        p2.add(b2);
        pb.add(p2);
        add(pb);



    }

    public void genAccNo() {

        String Chars = "abcdefghijklmnopqrstuvwxyz123456789";

      //  do {
            while (sb.length() < 9) {
                int randomint = rnd.nextInt(Chars.length());
                char in = Chars.charAt(randomint);
                sb.append(in);
            }
            account_number = sb.toString();
        }
      //  while (!randcheck());


  //  }

    public boolean randcheck() {
        ArrayList<String> temp = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileReader("Data/AllAccounts.txt"));
            while (in.hasNextLine()) {
                temp.add(in.nextLine());
            }

            for (int i = 0; i < temp.size(); i++) {
                if (account_number.equals(temp.get(i))) ;
                sb.setLength(0);
                return false;
            }
            in.close();
            temp.removeAll(temp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        return true;
    }

    public void genCardnum() {
        try {
           // int i = 0;
            Scanner in = new Scanner(new FileReader("Data/allcards.txt"));
            ArrayList<String> temp = new ArrayList();
            while (in.hasNextLine()) {
                temp.add(in.nextLine());
            }
            //do {
                card_number = (int) ((Math.random() * 100000000) + 999999999);
                //i++;
            //}
           // while (!Integer.toString(card_number).equals(temp.get(i-1)) && i < temp.size());



        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    public void flush(){
        try {
            PrintWriter f1 = new PrintWriter(new FileWriter( "Data/AllAccounts.txt"),true);
            f1.println(account_number);
            f1.close();
            PrintWriter f2 = new PrintWriter(new FileWriter( "Data/allcards"),true);
            f2.println(card_number);
            f2.close();
            PrintWriter f3 = new PrintWriter( "Data/"+pin+".txt");
            f3.println(name);
            f3.println(0);
            f3.println(account_number);
            f3.println(card_number);
            f3.println(mobile);
            f3.println(0);
            f3.close();
            PrintWriter f4 = new PrintWriter( "Data/"+pin+".history.txt");
            f4.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "Sign-Up" :
                if(t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this, "Please enter the required data");
                }
                else{
                name = t1.getText();
                mobile = t2.getText();
                pin = t3.getText();
                genAccNo();
                genCardnum();
                flush();
                JOptionPane.showMessageDialog(this , "account Created successfully");
                JOptionPane.showMessageDialog(this,"please enter your pin in the login page to access your account");
                this.dispose();
                }
                break;

            case "Cancel" :
                this.dispose();
                break;
        }
    }
}