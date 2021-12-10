/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class MainPage extends JFrame {

    public MainPage() {
        javax.swing.JButton jButton1;
        javax.swing.JButton jButton2;
        javax.swing.JButton jButton3;
        javax.swing.JButton jButton4;
        javax.swing.JButton jButton5;
        javax.swing.JButton jButton6;
        javax.swing.JLabel jLabel1;
        javax.swing.JPanel jPanel1;
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(204, 204, 204));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        //button Fawry
        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setForeground(new Color(204,204,204));
        jButton1.setText("Fawry");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 63;
        gridBagConstraints.ipady = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 117, 0, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        // button Accounts
        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setForeground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Accounts");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 49;
        gridBagConstraints.ipady = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 281, 0, 0);
        jPanel1.add(jButton2, gridBagConstraints);


        // Deposit button
        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setForeground(new Color(204,204,204));
        jButton3.setText("Deposit");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 57;
        gridBagConstraints.ipady = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 281, 54, 0);
        jPanel1.add(jButton3, gridBagConstraints);


        //pay your credit card button
        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setForeground(new Color(204,204,204));
        jButton4.setText("Pay your credit card");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipady = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 117, 54, 0);
        jPanel1.add(jButton4, gridBagConstraints);


        // balance info button
        jButton5.setBackground(new java.awt.Color(0, 0, 0));
        jButton5.setForeground(new Color(204,204,204));
        jButton5.setText("Balance info");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 117, 0, 0);
        jPanel1.add(jButton5, gridBagConstraints);

        //withdrawal button
        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setForeground(new Color(204,204,204));
        jButton6.setText("Withdrawl");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(26, 281, 0, 0);
        jPanel1.add(jButton6, gridBagConstraints);

        // label section

        jLabel1.setBackground(new java.awt.Color(0, 107, 0));
        jLabel1.setForeground(new Color(204,204,204));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 33)); // NOI18N
        jLabel1.setText("                National Bank Of Egypt services");
        jLabel1.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 170;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 6);
        jPanel1.add(jLabel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );

        pack();
        this.add(jPanel1);
    }// </editor-fold>




    // Variables declaration - do not modify

    // End of variables declaration

    }

