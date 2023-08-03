package org.example;

import org.example.model.MemberList;
import org.example.repos.MemberListRepo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class MembersListScreen {



  public void Member_List() {

       DefaultTableModel model;

      JFrame frame = new JFrame("Swing Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        model = new DefaultTableModel(new String[]{"id", "Name", "Age", "phone_num", "address", "length", "weight"}, 0);


      MemberListRepo ml=new MemberListRepo();
       List<MemberList> data =  ml.getDataFromSql();


      for (MemberList member : data) {
          Object[] row = {member.getId(), member.getName(), member.getAge(), member.getPhone_num(),
                  member.getAddress(), member.getLength(), member.getWeight()};
          model.addRow(row);
      }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);
    }



}