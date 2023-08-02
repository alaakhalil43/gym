package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class LoginScreen {
    static  void login(){
        JFrame jf= new JFrame("ELol_Gym");
        jf.getContentPane().setBackground(Color.gray);

        JTextField j1,j2;
        j1=new JTextField("username");
        j1.setBounds(50,100,200,30);


        j2=new JTextField("password");
        j2.setBounds(50,140,200,30);


        JButton jb=new JButton("Login");
        jb.setBounds(100,190,100,20);

        jf.setSize(400,400);
        jf.add(j1);
        jf.add(j2);
        jf.add(jb);

        jf.setLayout(null);
        jf.setVisible(true);

        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String username_j = j1.getText(); // to return the value from j1
                    String password_j = j2.getText();

                    Connection con = connect.geConnection();
                    PreparedStatement pr = con.prepareStatement("SELECT id FROM user WHERE username = ?");
                    pr.setString(1, username_j);
                    ResultSet rs = pr.executeQuery();
                    if (rs.next()) {
                         pr = con.prepareStatement("SELECT id FROM user WHERE password = ?");
                        pr.setString(1, password_j);
                        rs=pr.executeQuery();
                        if (rs.next())    JOptionPane.showMessageDialog(null, AppMessages.loginSucess);
                        else    JOptionPane.showMessageDialog(null, AppMessages.pass_uncorrect);

                    } else {
                        JOptionPane.showMessageDialog(null, AppMessages.username_uncorrect);
                    }

                }
                catch (SQLException ee) {
                    throw new RuntimeException(ee);
                }

            }
        });
  }




}
