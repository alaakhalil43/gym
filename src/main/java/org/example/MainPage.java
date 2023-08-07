package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {

     public void MainPage(){

        JFrame jf= new JFrame("Main Page");
        jf.setSize(tools.screenWidth,tools.screenHeight);


//    JButton jb1=new JButton("اضافة عضو");
//         jb1.setBounds(300,100,250,250);
//         jb1.getFont();
//        jb1.setFont(new Font("Arial", Font.PLAIN, 30));


 JButton jb2=new JButton("قائمة الاعضاء");
        jb2.setBounds(850,200,250,250);
        jb2.setFont(new Font("Arial", Font.PLAIN, 30));
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                         MembersListScreen m1=new MembersListScreen();
                         m1.Member_List();
            }
        });
 JButton jb3=new JButton("استعلامات");
        jb3.setBounds(250,200,250,250);
        jb3.setFont(new Font("Arial", Font.PLAIN, 30));

 JButton jb4=new JButton("الايرادات");
        jb4.setBounds(550,200,250,250);
        jb4.setFont(new Font("Arial", Font.PLAIN, 30));


//        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.add(jb4);

        jf.setLayout(null);
        jf.setVisible(true);


    }
}
