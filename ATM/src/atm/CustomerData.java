package atm;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerData {
static String num ;

    //int                   [] pins       = {1919,5115,2019,8888};
    public static  int  balance      ;
    public static  String account_id ;
    public static  String holders    ;
    public static  String cards      ;
    public static  String mobile     ;
    public static  int  owe          ;

static ArrayList<Object> price = new ArrayList<>();
static ArrayList<Object> place = new ArrayList<>();



    public boolean get_data(String num) {
        this.num = num;
        ArrayList<String> temp = new ArrayList<>() ;
        File myfile = new File("Data/"+num+".txt");
        Scanner in = null;
        if (myfile.exists()) {
            try {
                in = new Scanner(new FileReader("Data/"+num+".txt"));
            } catch (FileNotFoundException e) {
               return false;
            }
            while(in.hasNextLine()){

                temp.add(in.nextLine());

            }

            holders = temp.get(0);
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
            for (int i = 0; i <price.size() ; i++) {
                System.out.print(place.get(i));
                System.out.println(price.get(i));

            }
            System.out.printf("\n\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public void flush(){
        try {
            System.out.println(num);
           PrintWriter fw = new PrintWriter("Data/"+num+".txt");
            fw.println(holders);
            fw.println(balance);
            fw.println(account_id);
            fw.println(cards);
            fw.println(mobile);
            fw.println(owe);
            fw.close();
            PrintWriter h = new PrintWriter( "Data/"+num+".history.txt");
            for (int i = 0; i < place.size() ; i++) {
                h.println(place.get(i));
//                if(i != place.size() - 1) {
                    h.println(price.get(i));
                //}
            }
            h.close();
            place.removeAll(place);
            price.removeAll(price);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
