package org.example;
import org.example.model.MemberList;
import org.example.repos.MemberListRepo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMember {

    public void Add_Member(){

        JFrame jf= new JFrame("Add Member");
        jf.getContentPane().setBackground(Color.gray);
        jf.setSize(tools.screenWidth,tools.screenHeight);

        JTextField j2,j3,j4,j5,j6,j7;

        j2=new JTextField("Name");
        j2.setBounds(40,70,200,30);

        j3=new JTextField("Age");
        j3.setBounds(40,120,200,30);


        j4=new JTextField("Phone Number");
        j4.setBounds(40,170,200,30);


        j5=new JTextField("Address");
        j5.setBounds(40,220,200,30);

        j6=new JTextField("Length");
        j6.setBounds(40,270,200,30);

        j7=new JTextField("Weight");
        j7.setBounds(40,320,200,30);



        JButton jb=new JButton("Add Member");
        jb.setBounds(60,380,150,40);
        jb.setBackground(Color.CYAN);


        jf.add(j2);
        jf.add(j3);
        jf.add(j4);
        jf.add(j5);
        jf.add(j6);
        jf.add(j7);


        jf.add(jb);
        jf.setLayout(null);
        jf.setVisible(true);


        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = j2.getText();
                String age = j3.getText();
                String phone_num = j4.getText();
                String address = j5.getText();
                String length = j6.getText();
                String weight = j7.getText();

                MemberList m = new MemberList(0 , name ,Integer.parseInt(age)  , phone_num , address , Integer.parseInt(length) , Integer.parseInt(weight ));

                MemberListRepo repo = new MemberListRepo();
                repo.insertValues(m);


            }




        });




    }
}
