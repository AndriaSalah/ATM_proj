/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;


public class ATM {

 /**
  * @param args the command line arguments
  */
 public static void main(String[] args) {
  Login frame1 = new Login();
  frame1.setTitle("National Bank Of Egypt ATM");
  frame1.setVisible(true);
  frame1.setSize(400, 700);
  frame1.setBackground(Color.white);
  frame1.setLocationRelativeTo(null);
  frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }

}
