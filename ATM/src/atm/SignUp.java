package atm;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SignUp extends JFrame implements ActionListener, MouseListener,sql_interface {

    String name;
    String mobile;
    String pin;
    int card_number;
    String account_number;
    StringBuilder sb = new StringBuilder();
    Random rnd = new Random();
    JButton sign_up, cancel;
    JLabel Name_l, Phone_l, Pin_l, err_name, err_phone, err_pin;
    JTextField Username, Mobile, Pin;
    ErrorHandel er = new ErrorHandel();
    Font f = new Font("Sans", Font.PLAIN, 30);
    boolean click = false;
    boolean click2 = false;
    boolean click3 = false;

    public SignUp() {
        FlatDarkLaf.setup();
        UIManager.put("Button.arc", 20);
        UIManager.put("Component.arc", 20);
        UIManager.put("ProgressBar.arc", 20);
        UIManager.put("TextComponent.arc", 20);

        setSize(600, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("National Bank Of Egypt ATM");
        setBackground(new Color(60, 70, 92));
        JPanel pb, p1, p2;
        pb = new JPanel(new GridLayout(2, 1, 0, 50));
        pb.setBackground(new Color(60, 70, 92));
        p1 = new JPanel(new GridLayout(3, 6, 0, 10));
        p1.setBackground(new Color(60, 70, 92));

        // error indicators
        err_name = new JLabel("*");
        err_name.setFont(f);
        err_name.setForeground(Color.RED);
        err_name.setVisible(false);
        err_phone = new JLabel("*");
        err_phone.setFont(f);
        err_phone.setForeground(Color.RED);
        err_phone.setVisible(false);
        err_pin = new JLabel("*");
        err_pin.setFont(f);
        err_pin.setForeground(Color.RED);
        err_pin.setVisible(false);

        Name_l = new JLabel("Name");
        Name_l.setForeground(Color.white);
        Phone_l = new JLabel("Mobile number");
        Phone_l.setForeground(Color.white);
        Pin_l = new JLabel("Pin");
        Pin_l.setForeground(Color.white);
        Username = new JTextField("Name");
        Username.addMouseListener(this);
        Mobile = new JTextField("Phone number");
        Mobile.addMouseListener(this);
        Pin = new JTextField("Pin");
        Pin.addMouseListener(this);
        p1.add(Name_l);
        p1.add(err_name);
        p1.add(Username);
        p1.add(Phone_l);
        p1.add(err_phone);
        p1.add(Mobile);
        p1.add(Pin_l);
        p1.add(err_pin);
        p1.add(Pin);
        pb.add(p1);

        p2 = new JPanel(new FlowLayout());
        p2.setBackground(new Color(60, 70, 92));
        sign_up = new JButton("Sign-Up");
        sign_up.setPreferredSize(new Dimension(150, 60));
        sign_up.setBackground(new Color(0, 103, 0));
        sign_up.setForeground(Color.white);
        sign_up.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.setBackground(new Color(103, 0, 0));
        cancel.setForeground(Color.white);
        cancel.setPreferredSize(new Dimension(150, 60));
        cancel.addActionListener(this);
        p2.add(sign_up);
        p2.add(cancel);
        pb.add(p2);
        add(pb);

    }

    public void genAccNo(String pin) {

        String Chars = "abcdefghijklmnopqrstuvwxyz123456789";

        do {
            while (sb.length() < 5) {
                int randomint = rnd.nextInt(Chars.length());
                char in = Chars.charAt(randomint);
                sb.append(in);
            }
            sb.append(pin);
            account_number = sb.toString();
        } while (!randcheck());

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
            if (temp.size() > 0) {
                do {
                    card_number = (int) ((Math.random() * 100000000) + 999999999);
                    i++;
                } while (Integer.toString(card_number).equals(temp.get(i - 1)) && i < temp.size());
            } else {
                card_number = (int) ((Math.random() * 100000000) + 999999999);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    public void flush() {
        try {
            PrintWriter f1 = new PrintWriter(new FileWriter("Data/AllAccounts.txt", true));
            f1.println(account_number);
            f1.close();
            PrintWriter f2 = new PrintWriter(new FileWriter("Data/allcards.txt", true));
            f2.println(card_number);
            f2.close();
            PrintWriter f3 = new PrintWriter("Data/" + pin + ".txt");
            f3.println(name);
            f3.println(300000);
            f3.println(account_number);
            f3.println(card_number);
            f3.println(mobile);
            f3.println(30000);
            f3.close();
            PrintWriter f4 = new PrintWriter("Data/" + pin + ".history.txt");
            f4.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Sign-Up":
                if (Username.getText().isEmpty() || Mobile.getText().isEmpty() || Pin.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter the required data");
                }
                if (!er.check_numbers(Username.getText())) {
                    err_name.setVisible(true);
                } else {
                    err_name.setVisible(false);
                }
                if (!er.check_letters(Mobile.getText())) {
                    err_phone.setVisible(true);
                } else {
                    err_phone.setVisible(false);
                }
                if (!er.checkpin(Pin.getText())) {
                    err_pin.setVisible(true);
                } else {
                    err_pin.setVisible(false);
                }
                switch (er.indicator) {
                    case "A":
                        JOptionPane.showMessageDialog(this, "please dont use Numbers in the name field");
                        er.indicator = "";
                        break;
                    case "B":
                        JOptionPane.showMessageDialog(this, "please dont use Letters in the Mobile field");
                        er.indicator = "";
                        break;
                    case "C":
                        JOptionPane.showMessageDialog(this, "please make sure your pin is not longer than 4 numbers");
                        er.indicator = "";
                        break;
                    case "D":
                        JOptionPane.showMessageDialog(this, "please dont use Letters in the pin field");
                        er.indicator = "";
                        break;
                    case "CD":
                        JOptionPane.showMessageDialog(this, "please make sure you pin is not longer 4 numbers and doesnt contain any letters");
                        er.indicator = "";
                        break;
                    case "BD":
                        JOptionPane.showMessageDialog(this, "please make sure your pin doesnt contain any letters\n also check if the mobile field has any letters");
                        er.indicator = "";
                        break;
                    case "BC":
                        JOptionPane.showMessageDialog(this, "please make sure your pin is not longer than 4 numbers\nalso check if the mobile field has any letters");
                        er.indicator = "";
                        break;
                    case "BCD":
                        JOptionPane.showMessageDialog(this, "please make sure your pin doesnt contain any letters and is not longer than 4 numbers\nalso check if the mobile field has any letters");
                        er.indicator = "";
                        break;
                    case "AB":
                        JOptionPane.showMessageDialog(this, "please make sure your name doesnt contain any numbers\nalso check if the mobile field has any letters");
                        er.indicator = "";
                        break;
                    case "AC":
                        JOptionPane.showMessageDialog(this, "please make sure your name doesnt contain any numbers\nalso check if the pin entered is not longer than 4 numbers");
                        er.indicator = "";
                        break;
                    case "AD":
                        JOptionPane.showMessageDialog(this, "please make sure your name doesnt contain any numbers\nalso check if the pin field has any letters");
                        er.indicator = "";
                        break;
                    case "ABC":
                        JOptionPane.showMessageDialog(this, "please make sure your name doesnt contain any numbers\nalso check if the mobile field has any letters\nalso check if your pin is longer than 4 numbers");
                        er.indicator = "";
                        break;
                    case "ABD":
                        JOptionPane.showMessageDialog(this, "please make sure your name doesnt contain any numbers\nalso check if the mobile field has any letters\nalso check if your pin doesnt contain letters");
                        er.indicator = "";
                        break;
                    case "ABCD":
                        JOptionPane.showMessageDialog(this, "please make sure your name doesnt contain any numbers\nalso check if the mobile field has any letters\nalso check if your pin is longer than 4 numbers and contains letters");
                        er.indicator = "";
                        break;
                    default:
                        name = Username.getText();
                        mobile = Mobile.getText();
                        pin = Pin.getText();
                        genAccNo(pin);
                        genCardnum();
                        flush();
                        flushtodb();
                        JOptionPane.showMessageDialog(this, "account Created successfully");
                        JOptionPane.showMessageDialog(this, "please enter your pin in the login page to access your account");
                        this.dispose();
                        break;
                }
                break;

            case "Cancel":
                this.dispose();
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == Username) {
            click = true;
            click2 = false;
            click3 = false;

        }
        if (e.getSource() == Mobile) {
            click = false;
            click2 = true;
            click3 = false;

        }
        if (e.getSource() == Pin) {
            click = false;
            click3 = true;
            click2 = false;

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == Username) {
            if (!click) {
                if (Username.getText().equals("Name")) {
                    Username.setText("");
                }
            }
        }
        if (e.getSource() == Mobile) {
            if (!click2) {
                if (Mobile.getText().equals("Phone number")) {
                    Mobile.setText("");
                }
            }
        }
        if (e.getSource() == Pin) {
            if (!click3) {
                if (Pin.getText().equals("Pin")) {
                    Pin.setText("");
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == Username) {
            if (!click) {
                if (Username.getText().equals("")) {
                    Username.setText("Name");
                }
            }
        }
        if (e.getSource() == Mobile) {
            if (!click2) {
                if (Mobile.getText().equals("")) {
                    Mobile.setText("Phone number");
                }
            }
        }
        if (e.getSource() == Pin) {
            if (!click3) {
                if (Pin.getText().equals("")) {
                    Pin.setText("Pin");
                }
            }
        }
    }

    @Override
    public void flushtodb() {
        try {
            Connection db = DriverManager.getConnection(url);
            Statement statement_handler = db.createStatement();
            String sql = "insert into customer values ('" +
                    name+"','"+account_number+"',"+card_number+","+300000+","
                    +20000+","+mobile+
                    ");";
            statement_handler.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void GetTempfromdb(String transit) {

    }

    @Override
    public void FlushTemptodb() {

    }

    @Override
    public void GetTempHistoryfromdb(String buffer) {

    }

    @Override
    public boolean getfromdb(String buffer) {
        return false;
    }

    @Override
    public void GetHistoryfromdb(String buffer) {

    }
}
