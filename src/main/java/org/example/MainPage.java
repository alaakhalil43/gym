package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage {

     public void MainPage(){


        JFrame jf= new JFrame("Main Page");
        jf.setSize(800,800);


        JPanel panel = new JPanel(new BorderLayout());
        JLabel nameLabel = new JLabel("الاسم:");
        JTextField nameField = new JTextField(20);


        panel.add(nameLabel, BorderLayout.NORTH);
        panel.add(nameField, BorderLayout.CENTER);


JButton jb1=new JButton("اضافة عضو");
         jb1.setBounds(120,100,250,250);
         jb1.getFont();
        jb1.setFont(new Font("Arial", Font.PLAIN, 30));

         jb1.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
        AddMember a1=new AddMember();
        a1.Add_Member();

             }
         });







JButton jb2=new JButton("قائمة الاعضاء");
        jb2.setBounds(400,100,250,250);
        jb2.setFont(new Font("Arial", Font.PLAIN, 30));



JButton jb3=new JButton("استعلامات");
        jb3.setBounds(120,400,250,250);
        jb3.setFont(new Font("Arial", Font.PLAIN, 30));

JButton jb4=new JButton("الايرادات");
        jb4.setBounds(400,400,250,250);
        jb4.setFont(new Font("Arial", Font.PLAIN, 30));




        jf.add(jb1);
        jf.add(jb2);
        jf.add(jb3);
        jf.add(jb4);
        jf.add(nameField);
        jf.add(nameLabel);

        jf.setLayout(null);
        jf.setVisible(true);




    }






}
