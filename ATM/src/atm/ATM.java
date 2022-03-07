/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;


import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;


public class ATM {

 /**
  * @param args the command line arguments
  */
 public static void main(String[] args) {
     FlatDarkLaf.setup();
     UIManager.put( "Button.arc", 200 );
     UIManager.put( "Component.arc", 200 );
     UIManager.put( "ProgressBar.arc", 200 );
     UIManager.put( "TextComponent.arc", 30 );

  Login frame1 = new Login();
    frame1.setTitle("National Bank Of Egypt ATM");
    frame1.setVisible(true);
    frame1.setSize(400, 698);
    frame1.setLocationRelativeTo(null);
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


 }

}
