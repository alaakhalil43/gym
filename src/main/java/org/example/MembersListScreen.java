package org.example;
import org.example.model.MemberList;
import org.example.model.Util;
import org.example.repos.MemberListRepo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MembersListScreen {

    public void Member_List() {


        JFrame jf = new JFrame("Members List");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(tools.screenWidth, tools.screenHeight);


        JTextField j2, j3, j4, j5, j6, j7;
        Font f = new Font("Arial", Font.PLAIN, 15);

        j2 = new JTextField("Name");
        j2.setBounds(40, 70, 200, 50);
        j2.setHorizontalAlignment(JTextField.CENTER);
        j2.setFont(f);


        j3 = new JTextField("Age");
        j3.setBounds(340, 70, 200, 50);
        j3.setHorizontalAlignment(JTextField.CENTER);
        j3.setFont(f);

        j4 = new JTextField("Phone Number");
        j4.setBounds(640, 70, 200, 50);
        j4.setHorizontalAlignment(JTextField.CENTER);
        j4.setFont(f);

        j5 = new JTextField("Address");
        j5.setBounds(40, 130, 200, 50);
        j5.setHorizontalAlignment(JTextField.CENTER);
        j5.setFont(f);

        j6 = new JTextField("Length");
        j6.setBounds(340, 130, 200, 50);
        j6.setHorizontalAlignment(JTextField.CENTER);
        j6.setFont(f);

        j7 = new JTextField("Weight");
        j7.setBounds(640, 130, 200, 50);
        j7.setHorizontalAlignment(JTextField.CENTER);
        j7.setFont(f);

        Font f2 = new Font("Serif", Font.BOLD, 20);
        JButton jb = new JButton("Add Member");
        jb.setBounds(900, 90, 150, 60);
        jb.setFont(f2);
        jb.setBackground(Color.CYAN);


        jf.add(j2);
        jf.add(j3);
        jf.add(j4);
        jf.add(j5);
        jf.add(j6);
        jf.add(j7);

        jf.add(jb);

        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = j2.getText();
                String age = j3.getText();
                String phone_num = j4.getText();
                String address = j5.getText();
                String length = j6.getText();
                String weight = j7.getText();


                boolean valid = valid(name, age, phone_num, address, length, weight);
                if (valid)  {
                    boolean checkInteger= Check(age,phone_num,length,weight);
                    if (checkInteger) {
                        MemberListRepo mm=new MemberListRepo();
                        if ( mm.CountNmuber(phone_num) ){
                        MemberList m = new MemberList(0, name, Integer.parseInt(age), phone_num, address, Integer.parseInt(length), Integer.parseInt(weight));
                        MemberListRepo repo = new MemberListRepo();
                        repo.insertValues(m);

                        jf.add(DrawTable(), BorderLayout.SOUTH); // وضع الجدول في منطقة BorderLayout.SOUTH
                        jf.setVisible(true);
                    }
                    }
                }

            }
        });

        jf.setLayout(new BorderLayout());
        jf.add(DrawTable(), BorderLayout.SOUTH); // وضع الجدول في منطقة BorderLayout.SOUTH

        jf.setVisible(true);
    }
    public JScrollPane DrawTable(){

        DefaultTableModel model = new DefaultTableModel(new String[]{"id", "Name", "Age", "phone_num", "address", "length", "weight"}, 0);
        MemberListRepo ml = new MemberListRepo();
        List<MemberList> data = ml.getDataFromSql();

        for (MemberList member : data) {
            Object[] row = {member.getId(), member.getName(), member.getAge(), member.getPhone_num(),
                    member.getAddress(), member.getLength(), member.getWeight()};
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        return  scrollPane ;
    }



    public boolean valid(String name, String age, String phone_num, String address, String length, String weight) {

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "يجب ادخال الاسم");
            return false;
        } else if (age.isEmpty()) {
            JOptionPane.showMessageDialog(null, "يجب ادخال العمر");
            return false;
        } else if (phone_num.isEmpty()) {
            JOptionPane.showMessageDialog(null, "يجب ادخال رقم التلفون");
            return false;
        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "يجب ادخال العنوان");
            return false;
        } else if (length.isEmpty()) {
            JOptionPane.showMessageDialog(null, "يجب ادخال الطول");
            return false;
        } else if (weight.isEmpty()) {
            JOptionPane.showMessageDialog(null, "يجب ادخال الوزن");
            return false;
        }
        return true;
    }

    public boolean Check( String age, String phone_num, String length, String weight) {

        if (Util.check(age) == false) {
            JOptionPane.showMessageDialog(null, "قم بكتابه العمر بشكل صحيح");
            return false;

        } else if ( phone_num.length()!=11) {
            JOptionPane.showMessageDialog(null, "قم بكتابه رقم التلفون بشكل صحيح");
            return false;

        } else if (Util.check(length) == false) {
            JOptionPane.showMessageDialog(null, "قم بكتابه الطول بشكل صحيح");
            return false;

        } else if (Util.check(weight) == false) {
            JOptionPane.showMessageDialog(null, "قم بكتابه الوزن بشكل صحيح");
            return false;
        }
        return true;
    }




    }