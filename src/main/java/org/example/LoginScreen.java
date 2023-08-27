package org.example;
import org.example.model.login;
import org.example.repos.UserRepo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public  class LoginScreen {
    public   void login(){

         // 2:42 8/8

        JFrame jf= new JFrame("ELol_Gym");
        jf.getContentPane().setBackground(Color.gray);
        jf.setSize(tools.screenWidth,tools.screenHeight);

        JTextField j1,j2;
        j1=new JTextField("username");
        j1.setBounds(550,200,200,40);
        j1.setHorizontalAlignment(JTextField.CENTER);


        j2=new JTextField("password");
        j2.setBounds(550,250,200,40);
        j2.setHorizontalAlignment(JTextField.CENTER);


        JButton jb=new JButton("Login");
        jb.setBounds(600,300,100,30);



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
                u.login_(l);

            }
        });
  }

}
