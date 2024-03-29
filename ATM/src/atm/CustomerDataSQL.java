package atm;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDataSQL {

    public static int balance;
    public static String account_id;
    public static String Owner_Name;
    public static String cards;
    public static String mobile;
    public static int owe;


    public static int balance_temp;
    public static String account_id_temp;
    public static String Owner_Name_temp;
    public static String cards_temp;
    public static String mobile_temp;
    public static int owe_temp;


    public static String place;
    public static int price;
    public static String place_temp;
    public static int price_temp;

    static ArrayList<Object> price_list = new ArrayList<>();
    static ArrayList<Object> place_list = new ArrayList<>();

    static ArrayList<Object> price_list_temp = new ArrayList<>();
    static ArrayList<Object> place_list_temp = new ArrayList<>();
    //final static String url2 = "jdbc:sqlserver://localhost:1433;databaseName=atm;integratedSecurity=true;encrypt = false";
    final static String url = "jdbc:sqlserver://atm-proj.mssql.somee.com;packet size=4096;user=sevengunz_SQLLogin_1;password=ghbdpgkykd;data source=atm-proj.mssql.somee.com;persist security info=False;initial catalog=atm-proj; encrypt = false";


    public void flushtodb() {
        try {
            Connection db = DriverManager.getConnection(url);
            Statement statement_handler = db.createStatement();
            String sql = "update customer set balance = " + balance + ", owed_money = " + owe
                    + "where account_id = ('" + account_id + "');";
            System.out.println(sql);
            statement_handler.executeUpdate(sql);
            String sql2 = "insert into balance_history values ('" + account_id + "','" + place + "'," + price + ");";
            System.out.println(sql2);
            statement_handler.executeUpdate(sql2);
            place = "";
            price = 0;
            statement_handler.close();
            db.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Please check if you internet connection is working and try again");
            e.printStackTrace();
        }
    }

//    public void FlushHistorytodb() {
//        try {
//            Connection db = DriverManager.getConnection(url);
//            Statement statement_handler = db.createStatement();
//            String sql = "insert into balance_history values ('" + account_id + "','" + place + "'," + price + ");";
//            System.out.println(sql);
//            statement_handler.executeUpdate(sql);
//            statement_handler.close();
//            db.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        place = "";
//        price = 0;
//    }


    public void GetHistoryfromdb() {
        try {
            place_list.removeAll(place_list);
            price_list.removeAll(price_list);
            Connection db = DriverManager.getConnection(url);
            Statement statement_handler = db.createStatement();
            String sql = "select place,price from balance_history where account_id ='" + account_id + "';";
            System.out.println(sql);
            ResultSet sql_result = null;

            statement_handler.executeQuery(sql);
            sql_result = statement_handler.executeQuery(sql);
            while (sql_result.next()) {
                place_list.add(sql_result.getString(1));
                price_list.add(sql_result.getInt(2));
            }
            db.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Please check if you internet connection is working and try again");
            e.printStackTrace();
        }


    }


    public int getfromdb(String buffer) {
        try {
            Connection db = DriverManager.getConnection(url);
            Statement statement_handler = db.createStatement();
            String sql = "select * from customer where account_id like ('%" + buffer + "');";
            System.out.println(sql);
            ResultSet sql_result = statement_handler.executeQuery(sql);
            if (sql_result.next()) {
                Owner_Name = sql_result.getString(1);
                account_id = sql_result.getString(2);
                cards = String.valueOf(sql_result.getInt(3));
                balance = sql_result.getInt(4);
                owe = sql_result.getInt(5);
                mobile = String.valueOf(sql_result.getInt(6));
                GetHistoryfromdb();
                System.out.println(Owner_Name);
                db.close();
                return 1;

            }
            statement_handler.close();
            db.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return 3;
        }

        return 2;
    }


    public void GetTempfromdb(String transit) {
        try {
            Connection db = DriverManager.getConnection(url);
            Statement statement_handler = db.createStatement();
            String sql = "select Balance,account_id from customer where account_id = ('" + transit + "');";
            System.out.println(sql);
            ResultSet sql_result = statement_handler.executeQuery(sql);
            if (sql_result.next()) {
                balance_temp = sql_result.getInt(1);
                account_id_temp = sql_result.getString(2);
                System.out.println(balance_temp);
                System.out.println("loaded successfully");

            }
            statement_handler.close();
            db.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Please check if you internet connection is working and try again");
            e.printStackTrace();
        }
    }


    public void FlushTemptodb() {
        try {
            //update balance in db
            Connection db = DriverManager.getConnection(url);
            Statement statement_handler = db.createStatement();
            String sql = "update customer set balance = " + balance_temp
                    + " where account_id = ('" + account_id_temp + "');";
            System.out.println(sql);
            statement_handler.executeUpdate(sql);

            //flush history to db
            String sql2 = "insert into balance_history values ('" + account_id_temp + "','" + place_temp + "'," + price_temp + ");";
            System.out.println(sql2);
            statement_handler.executeUpdate(sql2);
            place_temp = "";
            price_temp = 0;
            statement_handler.close();
            db.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Please check if you internet connection is working and try again");
            e.printStackTrace();
        }
    }


}