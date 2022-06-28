package atm;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public  class CustomerData{
static String num ;


    public static  int  balance      ;
    public static  String account_id ;
    public static  String Owner_Name ;
    public static  String cards      ;
    public static  String mobile     ;
    public static  int  owe          ;
;

    public static  int  balance_temp      ;
    public static  String account_id_temp ;
    public static  String Owner_Name_temp ;
    public static  String cards_temp      ;
    public static  String mobile_temp     ;
    public static  int  owe_temp          ;




static ArrayList<Object> price = new ArrayList<>();
static ArrayList<Object> place = new ArrayList<>();

static ArrayList<Object> price_temp = new ArrayList<>();
static ArrayList<Object> place_temp = new ArrayList<>();


    public boolean get_data(String num) {
        this.num = num;
        ArrayList<String> temp = new ArrayList<>() ;
        File myfile = new File("Data/"+num+".txt");
        Scanner in ;
        if (myfile.exists()) {
            try {
                in = new Scanner(new FileReader("Data/"+num+".txt"));
            } catch (FileNotFoundException e) {
               return false;
            }
            while(in.hasNextLine()){

                temp.add(in.nextLine());

            }

            Owner_Name = temp.get(0);
            balance = Integer.parseInt(temp.get(1));
            account_id = temp.get(2);
            cards = temp.get(3);
            mobile = temp.get(4);
            owe = Integer.parseInt(temp.get(5));
            in.close();
            get_history();
            return true;
        }
        else
             return false;
   }

    public void get_history(){
        try {
            Scanner in = new Scanner(new FileReader("Data/"+num+".history.txt"));
            ArrayList<Object> temp =  new ArrayList<>();
            while (in.hasNextLine()){
               temp.add(in.nextLine());
            }
            for (int i = 0; i < temp.size() ; i+=2) {
                place.add(temp.get(i));
                if(i != temp.size() - 1) {
                    price.add(temp.get(i + 1));
                }

            }
            in.close();

            System.out.printf("\n\n");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"File not found");
        }

    }
    public static void flush(){
        try {

           PrintWriter fw = new PrintWriter("Data/"+num+".txt");
            fw.println(Owner_Name);
            fw.println(balance);
            fw.println(account_id);
            fw.println(cards);
            fw.println(mobile);
            fw.println(owe);
            fw.close();
            PrintWriter h = new PrintWriter( "Data/"+num+".history.txt");
            for (int i = 0; i < place.size() ; i++) {
                h.println(place.get(i));
                h.println(price.get(i));

            }
            h.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File not found");
        }



        }
    public static void flushHist(){
        place.removeAll(place);
        price.removeAll(price);

    }
    public void GetTransferAccount(String transit){
        ArrayList<String> temp = new ArrayList<>();
        File myfile = new File("Data/"+transit+".txt");
        try {
            Scanner in = new Scanner(myfile);
            while (in.hasNextLine()){
                temp.add(in.nextLine());
            }
            Owner_Name_temp = temp.get(0);
            balance_temp = Integer.parseInt(temp.get(1));
            account_id_temp = temp.get(2);
            cards_temp = temp.get(3);
            mobile_temp = temp.get(4);
            owe_temp = Integer.parseInt(temp.get(5));

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

    }
    public void flush_temp(String transit){
        try {
            PrintWriter fw = new PrintWriter("Data/"+transit+".txt");
            fw.println(Owner_Name_temp);
            fw.println(balance_temp);
            fw.println(account_id_temp);
            fw.println(cards_temp);
            fw.println(mobile_temp);
            fw.println(owe_temp);
            fw.close();
            PrintWriter h = new PrintWriter( "Data/"+transit+".history.txt");
            for (int i = 0; i < place_temp.size() ; i++) {
                h.println(place_temp.get(i));
                h.println(price_temp.get(i));

            }
            h.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"File not found");
        }
    }
    public void get_temp_history(String transit){
        try {
            Scanner in = new Scanner(new FileReader("Data/"+transit+".history.txt"));
            ArrayList<Object> temp =  new ArrayList<>();
            while (in.hasNextLine()){
                temp.add(in.nextLine());
            }
            for (int i = 0; i < temp.size() ; i+=2) {
                place_temp.add(temp.get(i));
                if(i != temp.size() - 1) {
                    price_temp.add(temp.get(i + 1));
                }

            }
            in.close();

            System.out.printf("\n\n");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"File not found");
        }

    }



}
