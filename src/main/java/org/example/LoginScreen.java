package org.example;

import org.example.model.login;
import org.example.repos.UserRepo;

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

                String pass=j2.getText();
                String user=j1.getText();

                // باخد اوبجكت اخزن فيه الداتا اللي بحناجها
                // والمفروض باخد الداتا دي واعمل عليها الكونكشن هناك

                login l=new login(user,pass);
                UserRepo u=new UserRepo();
                u.inservalues(l);


            }
        });
  }




}
