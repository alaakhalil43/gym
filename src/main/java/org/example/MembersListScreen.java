package org.example;

import org.example.model.MemberList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MembersListScreen {

     public DefaultTableModel model;

    public void getDataFromSql() {
        try {
            Connection c = connect.geConnection();
            PreparedStatement pr = c.prepareStatement("SELECT id, name, age, phone_num, address, length, weight FROM member_list");
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                MemberList m1 = new MemberList(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                model.addRow(new Object[]{m1.getId(), m1.getName(), m1.getAge(), m1.getPhone_num(), m1.getAddress(), m1.getLength(), m1.getWeight()});
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

  public void Member_List() {
        JFrame frame = new JFrame("Swing Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        model = new DefaultTableModel(new String[]{"id", "Name", "Age", "phone_num", "address", "length", "weight"}, 0);

        getDataFromSql();

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setVisible(true);
    }


}