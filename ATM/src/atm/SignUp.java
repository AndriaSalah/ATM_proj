package atm;

import com.formdev.flatlaf.FlatDarkLaf;
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
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2,t3;
    ErrorHandel er = new ErrorHandel();
    Font f = new Font("Sans",Font.PLAIN,30);
    public SignUp() {
        FlatDarkLaf.setup();
        UIManager.put( "Button.arc", 20 );
        UIManager.put( "Component.arc", 20 );
        UIManager.put( "ProgressBar.arc", 20 );
        UIManager.put( "TextComponent.arc", 20 );
        
        setSize(600,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("National Bank Of Egypt ATM");
        setBackground(new Color(60, 70, 92));
        JPanel pb,p1,p2;
        pb=new JPanel(new GridLayout(2,1,0,50));
        pb.setBackground(new Color(60,70,92));
        p1 = new JPanel(new GridLayout(3,6,0,10));
        p1.setBackground(new Color(60,70,92));

        // error indicators
        l4 = new JLabel("*");
        l4.setFont(f);
        l4.setForeground(Color.RED);
        l4.setVisible(false);
        l5 = new JLabel("*");
        l5.setFont(f);
        l5.setForeground(Color.RED);
        l5.setVisible(false);
        l6 = new JLabel("*");
        l6.setFont(f);
        l6.setForeground(Color.RED);
        l6.setVisible(false);

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
        p1.add(l4);
        p1.add(t1);
        p1.add(l2);
        p1.add(l5);
        p1.add(t2);
        p1.add(l3);
        p1.add(l6);
        p1.add(t3);
        pb.add(p1);

        p2 = new JPanel(new FlowLayout());
        p2.setBackground(new Color(60,70,92));
        b1 = new JButton("Sign-Up");
        b1.setPreferredSize(new Dimension(150,60));
        b1.setBackground(new Color(0, 103, 0));
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b2 = new JButton("Cancel");
        b2.setBackground(new Color(103, 0, 0));
        b2.setForeground(Color.white);
        b2.setPreferredSize(new Dimension(150,60));
        b2.addActionListener(this);
        p2.add(b1);
        p2.add(b2);
        pb.add(p2);
        add(pb);



    }

    public void genAccNo() {

        String Chars = "abcdefghijklmnopqrstuvwxyz123456789";

        do {
            while (sb.length() < 9) {
                int randomint = rnd.nextInt(Chars.length());
                char in = Chars.charAt(randomint);
                sb.append(in);
            }
            account_number = sb.toString();
        }
        while (!randcheck());


    }

    public boolean randcheck() {
        ArrayList<String> temp = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileReader("Data/AllAccounts.txt"));
            while (in.hasNextLine()) {
                temp.add(in.nextLine());
            }

            for (int i = 0; i < temp.size(); i++) {
                if (account_number.equals(temp.get(i))) {
                    sb.setLength(0);
                    return false;
                }
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
            int i = 0;
            Scanner in = new Scanner(new FileReader("Data/allcards.txt"));
            ArrayList<String> temp = new ArrayList();
            while (in.hasNextLine()) {
                temp.add(in.nextLine());
            }
            if (temp.size() > 0 ) {
                do {
                    card_number = (int) ((Math.random() * 100000000) + 999999999);
                    i++;
                }
                while (Integer.toString(card_number).equals(temp.get(i-1)) && i < temp.size());
            }
            else  card_number = (int) ((Math.random() * 100000000) + 999999999);



        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    public void flush(){
        try {
            PrintWriter f1 = new PrintWriter(new FileWriter( "Data/AllAccounts.txt",true));
            f1.println(account_number);
            f1.close();
            PrintWriter f2 = new PrintWriter(new FileWriter( "Data/allcards.txt",true));
            f2.println(card_number);
            f2.close();
            PrintWriter f3 = new PrintWriter( "Data/"+pin+".txt");
            f3.println(name);
            f3.println(300000);
            f3.println(account_number);
            f3.println(card_number);
            f3.println(mobile);
            f3.println(30000);
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
                if(!er.check_numbers(t1.getText())){
                    l4.setVisible(true);
                }
                else l4.setVisible(false);
                if(!er.check_letters(t2.getText())){
                    l5.setVisible(true);
                }
                else l5.setVisible(false);
                if(!er.checkpin(t3.getText())){
                    l6.setVisible(true);
                }
                else l6.setVisible(false);
                    switch (er.indicator){
                        case "A":
                            JOptionPane.showMessageDialog(this,"please dont use Numbers in the name field");
                            er.indicator="";
                            break;
                        case "B":
                            JOptionPane.showMessageDialog(this,"please dont use Letters in the Mobile field");
                            er.indicator="";
                            break;
                        case "C":
                            JOptionPane.showMessageDialog(this,"please make sure your pin is not longer than 4 numbers");
                            er.indicator="";
                            break;
                        case "D":
                            JOptionPane.showMessageDialog(this,"please dont use Letters in the pin field");
                            er.indicator="";
                            break;
                        case "CD":
                            JOptionPane.showMessageDialog(this,"please make sure you pin is not longer 4 numbers and doesnt contain any letters");
                            er.indicator="";
                            break;
                        case "BD":
                            JOptionPane.showMessageDialog(this,"please make sure your pin doesnt contain any letters\n also check if the mobile field has any letters");
                            er.indicator="";
                            break;
                        case "BC":
                            JOptionPane.showMessageDialog(this,"please make sure your pin is not longer than 4 numbers\nalso check if the mobile field has any letters");
                            er.indicator="";
                            break;
                        case "BCD":
                            JOptionPane.showMessageDialog(this,"please make sure your pin doesnt contain any letters and is not longer than 4 numbers\nalso check if the mobile field has any letters");
                            er.indicator="";
                            break;
                        case "AB":
                            JOptionPane.showMessageDialog(this,"please make sure your name doesnt contain any numbers\nalso check if the mobile field has any letters");
                            er.indicator="";
                            break;
                        case "AC":
                            JOptionPane.showMessageDialog(this,"please make sure your name doesnt contain any numbers\nalso check if the pin entered is not longer than 4 numbers");
                            er.indicator="";
                            break;
                        case "AD":
                            JOptionPane.showMessageDialog(this,"please make sure your name doesnt contain any numbers\nalso check if the pin field has any letters");
                            er.indicator="";
                            break;
                        case "ABC":
                            JOptionPane.showMessageDialog(this,"please make sure your name doesnt contain any numbers\nalso check if the mobile field has any letters\nalso check if your pin is longer than 4 numbers");
                            er.indicator="";
                            break;
                        case "ABD":
                            JOptionPane.showMessageDialog(this,"please make sure your name doesnt contain any numbers\nalso check if the mobile field has any letters\nalso check if your pin doesnt contain letters");
                            er.indicator="";
                            break;
                        case "ABCD":
                            JOptionPane.showMessageDialog(this,"please make sure your name doesnt contain any numbers\nalso check if the mobile field has any letters\nalso check if your pin is longer than 4 numbers and contains letters");
                            er.indicator="";
                            break;
                        default:
                            name = t1.getText();
                            mobile = t2.getText();
                            pin = t3.getText();
                            genAccNo();
                            genCardnum();
                            flush();
                            JOptionPane.showMessageDialog(this , "account Created successfully");
                            JOptionPane.showMessageDialog(this,"please enter your pin in the login page to access your account");
                            this.dispose();
                            break;
                         }
                         break;


            case "Cancel" :
                this.dispose();
                break;
        }
    }
}