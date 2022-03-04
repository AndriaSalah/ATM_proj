package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Transfer extends JFrame implements ActionListener {
        JButton Transfer,Cancel,Check;
        JTextField Balance,Transfer_amount,Account_number;
        JCheckBox check = new JCheckBox();
        JLabel Balancel,Transfer_amountl,Account_numberl,Correct,Incorrect;
        JPanel Basepanel = new JPanel(new GridLayout(4,1,0,30));
        JPanel MainPanel1,MainPanel2,MainPanel3;
        JPanel buttonpanel = new JPanel();
        ImageIcon incorrect = createImageIcon("image/incorrect.png", "bank logo");
        ImageIcon correct = createImageIcon("image/correct.png", "bank logo");
        CustomerData c = new CustomerData();
        String transit;

    public Transfer(){
     Incorrect = new JLabel (incorrect);
     Correct = new JLabel(correct);
    check.setEnabled(false);
    MainPanel1 = new JPanel(new GridLayout(1,2,240,30));
    MainPanel2 = new JPanel(new GridLayout(1,4));
    MainPanel3 = new JPanel(new GridLayout(1,2,240,30));

    Transfer = new JButton("Transfer");
    Cancel = new JButton("Cancel");
    Check = new JButton("Check");
    Transfer.addActionListener(this);
    Cancel.addActionListener(this);
    Check.addActionListener(this);

    Balancel = new JLabel("Balance");
    Transfer_amountl = new JLabel("Transfer amount");
    Account_numberl = new JLabel("Account number");
    Balance = new JTextField();
    Transfer_amount = new JTextField();
    Transfer_amount.setEditable(false);
    Account_number = new JTextField(13);

    Balance.setText(Integer.toString(c.balance));
    Balance.setEditable(false);

    buttonpanel.add(Check);
    buttonpanel.add(Transfer);
    buttonpanel.add(Cancel);

    MainPanel1.add(Balancel);
    MainPanel1.add(Balance);



    MainPanel2.add(Account_numberl);
    MainPanel2.add(Correct);
    MainPanel2.add(Incorrect);
    Correct.setVisible(false);
    Incorrect.setVisible(false);
    MainPanel2.add(Account_number);

    MainPanel3.add(Transfer_amountl);
    MainPanel3.add(Transfer_amount);

    Basepanel.add(MainPanel1);
    Basepanel.add(MainPanel2);
    Basepanel.add(MainPanel3);
    Basepanel.add(buttonpanel);

    add(Basepanel);
    setVisible(true);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    //491 x 297
    setSize(495,300);
    setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){

            case "Transfer":
               if(transfer(Account_number.getText())) {
                   JOptionPane.showMessageDialog(this, "Transfer successful");
                   c.get_temp_history(transit);
                   c.place.add("Transfer-out");
                   c.price.add(Transfer_amount.getText());
                   c.place_temp.add("Transfer-in");
                   c.price_temp.add(Transfer_amount.getText());
                   Account_number.setText("");
                   Transfer_amount.setText("");
                   c.flush();
                   c.flush_temp(transit);
               }
               else JOptionPane.showMessageDialog(this,"unsuccesfull");
                break;
            case "Cancel":
                this.dispose();
                break;
            case "Check" :
                check(Account_number.getText());
                break;
        }

    }
    public boolean transfer(String account_number){
        ArrayList<String> buffer = new ArrayList<>();
        File myfile = new File("Data/AllAccounts.txt");
        try {
            Scanner in = new Scanner(myfile);
            while (in.hasNextLine()){
                buffer.add(in.nextLine());
            }
            in.close();
            for (int i = 0; i < buffer.size(); i++) {
                if(account_number.equals(buffer.get(i))){
                    transit = buffer.get(i).substring(5,9);
                   break;
                }
            }
            System.out.println(transit);

        } catch (FileNotFoundException e) {
            return false;
        }
        c.GetTransferAccount(transit);
        c.balance_temp += Integer.parseInt(Transfer_amount.getText());
        c.balance -= Integer.parseInt(Transfer_amount.getText());
        Balance.setText(Integer.toString(c.balance));
        Correct.setVisible(false);
        Incorrect.setVisible(false);
        return true;
    }
    public boolean check(String Account_number){
        boolean found = false ;
        ArrayList<String>temp = new ArrayList<>();
        File myfile = new File("Data/AllAccounts.txt");
        try {
            Scanner in = new Scanner(myfile);
            while(in.hasNextLine()){
                temp.add(in.nextLine());
            }
            for (int i = 0; i <temp.size() ; i++) {
                if(Account_number.equals(temp.get(i))){
                   found = true;

                }
            }
            if (found){
                Correct.setVisible(true);
                Incorrect.setVisible(false);
                Transfer_amount.setEditable(true);
            }
            else {
                Incorrect.setVisible(true);
                Correct.setVisible(false);
                Transfer_amount.setEditable(false);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }
    protected ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}
