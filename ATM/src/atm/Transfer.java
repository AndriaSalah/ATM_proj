package atm;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Transfer extends JFrame implements ActionListener, DocumentListener {
    JButton Transfer, Cancel;
    JTextField Balance, Transfer_amount, Account_number;

    JLabel Balancel, Transfer_amountl, Account_numberl, Correct, Incorrect;
    JPanel Basepanel = new JPanel(new GridLayout(4, 1, 0, 30));
    JPanel MainPanel1, MainPanel2, MainPanel3;
    JPanel buttonpanel = new JPanel();
    ImageIcon incorrect = createImageIcon("image/incorrect.png", "Unverified logo");
    ImageIcon correct = createImageIcon("image/correct.png", "Verified logo");
    CustomerDataSQL c = new CustomerDataSQL();
    String transit;
    Color co = new Color(0, 103, 0);
    Color co1 = new Color(103, 0, 0);
    Color co2 = new Color(91, 91, 91);
    ErrorHandel err = new ErrorHandel();
    public Transfer() {
        //Icons that shows when the account number that was entered is verified to be actually there or not
        Incorrect = new JLabel(incorrect);
        Correct = new JLabel(correct);

        //panels initialization
        MainPanel1 = new JPanel(new GridLayout(1, 2, 240, 30));
        MainPanel2 = new JPanel(new GridLayout(1, 4));
        MainPanel3 = new JPanel(new GridLayout(1, 2, 240, 30));

        //buttons initialization
        Transfer = new JButton("Transfer");
        Transfer.setBackground(co2);
        Cancel = new JButton("Cancel");
        Cancel.setBackground(co1);

        Transfer.addActionListener(this);
        Cancel.addActionListener(this);

        //label initialization
        Balancel = new JLabel("Balance");
        Transfer_amountl = new JLabel("Transfer amount");
        Account_numberl = new JLabel("Account number");

        //text field initialization
        Balance = new JTextField();
        Transfer_amount = new JTextField();
        Transfer_amount.setEditable(false);
        Account_number = new JTextField();
        Account_number.getDocument().addDocumentListener(this);

        // updating balance text field with the currently logged in account's balance
        Balance.setText(Integer.toString(c.balance));
        Balance.setEditable(false);

        //Adding components to their panels and then to the frame
        buttonpanel.add(Transfer);
        buttonpanel.add(Cancel);

        MainPanel1.add(Balancel);
        MainPanel1.add(Balance);


        MainPanel2.add(Account_numberl);
        MainPanel2.add(Correct);
        MainPanel2.add(Incorrect);
        //they are set invisible just so they won't show without actually entering any data at first
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

        //main frame Customization
        setSize(495, 300);
        setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Transfer":
                // checks if Transfer amount text field has any input after it is enabled after verification of the Account number entered

                // checks if the input is a valid number or if it contains letters
                if(!err.check_letters(Transfer_amount.getText()) || Transfer_amount.getText().isEmpty()){
                    if(Transfer_amount.getText().isEmpty()){
                        JOptionPane.showMessageDialog(this,"Transfer amount is blank , please enter a valid Transfer amount");
                    }
                    else
                    JOptionPane.showMessageDialog(this,Transfer_amount.getText()+" is not a valid number , please enter a valid number");
                }
                //starts the transfer process by calling the transfer method
                 else {
                        transfer(Account_number.getText());
                        JOptionPane.showMessageDialog(this, "Transfer successful");

                        c.place = "Transfer-out";
                        c.price = Integer.parseInt(Transfer_amount.getText());
                        c.place_temp = "Transfer-in";
                        c.price_temp= Integer.parseInt(Transfer_amount.getText());
                        Account_number.setText("");
                        Transfer_amount.setText("");

                        c.flushtodb();
                        c.GetHistoryfromdb();
                        c.FlushTemptodb();

                        Transfer.setBackground(co2);
                        //Check.setBackground(co);
                        Transfer.setEnabled(false);
                        Transfer_amount.setEditable(false);

                    }


                break;
            case "Cancel":
                this.dispose();
                break;

        }

    }

    public void transfer(String account_number) {
        //loads allAccounts file to check if the account does in fact exist and if it exists it cuts the string using substring
        // to get the last 4 numbers as they are the pin of the account and the name of the data file of the account we want to transfer to
        //those 4 letters are then loaded in a variable called transit that is passed to customer data to load the temp account data into the application
        //from then whatever is sent will be loaded in their main data and history
        ArrayList<String> buffer = new ArrayList<>();
        File myfile = new File("Data/AllAccounts.txt");
        try {
            Scanner in = new Scanner(myfile);
            while (in.hasNextLine()) {
                buffer.add(in.nextLine());
            }
            in.close();
            for (int i = 0; i < buffer.size(); i++) {
                if (account_number.equals(buffer.get(i))) {
                    transit = buffer.get(i).substring(5, 9);
                    break;
                }
            }


        } catch (FileNotFoundException e) {

        }
        c.GetTempfromdb(transit);
        c.balance_temp += Integer.parseInt(Transfer_amount.getText());
        c.balance -= Integer.parseInt(Transfer_amount.getText());
        Balance.setText(Integer.toString(c.balance));
        Correct.setVisible(false);
        Incorrect.setVisible(false);

    }
    // checks using document listener automatically when an input is detected in the Account_number text field if the account number exists on the system or not
    // thus showing Correct label as in the account was verified and enables the Transfer button and enables the Transfer_amount text field
    // or shows the Incorrect as in the account is not verified and then the
    //Transfer button will be disabled and the Transfer amount text field will also be disabled

    public boolean check(String Account_number) {
        boolean found = false;
        ArrayList<String> temp = new ArrayList<>();
        File myfile = new File("Data/AllAccounts.txt");
        try {
            Scanner in = new Scanner(myfile);
            while (in.hasNextLine()) {
                temp.add(in.nextLine());
            }
            for (int i = 0; i < temp.size(); i++) {
                if (Account_number.equals(temp.get(i))) {
                    found = true;

                }
            }
            if (found) {
                Correct.setVisible(true);
                Incorrect.setVisible(false);
                Transfer_amount.setEditable(true);
                Transfer.setEnabled(true);
                Transfer.setBackground(co);
            } else {
                Incorrect.setVisible(true);
                Correct.setVisible(false);
                Transfer_amount.setEditable(false);
                Transfer.setEnabled(false);
                Transfer.setBackground(co2);
                return false;
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

    @Override
    public void insertUpdate(DocumentEvent e) {

        if(Account_number.getText().length() == 9 ){
            check(Account_number.getText());

        }
        else if(Account_number.getText().length() > 9){

            JOptionPane.showMessageDialog(this ,"Account number is 9 numbers long please delete any extra characters");

        }

    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // Resets the state of the frame on the deletion of a character from the text field
        if (Account_number.getText().length() < 9){
            Incorrect.setVisible(false);
            Correct.setVisible(false);
            Transfer.setEnabled(false);
        }

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}