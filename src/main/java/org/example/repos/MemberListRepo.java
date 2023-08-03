package org.example.repos;

import org.example.connect;
import org.example.model.MemberList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberListRepo {

    public List<MemberList> getDataFromSql() {

        List<MemberList>  list = new ArrayList<>();


        try {
            Connection c = connect.geConnection();
            PreparedStatement pr = c.prepareStatement("SELECT id, name, age, phone_num, address, length, weight FROM member_list");
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                MemberList m1 = new MemberList(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));

                list.add(m1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  list;
    }
    public int getMaxId(){

        int id = 0;
        try {
            Connection co= connect.geConnection();

            PreparedStatement p=co.prepareStatement("SELECT COALESCE(MAX(id) + 1, 1) AS id FROM member_list ");
            ResultSet rs= p.executeQuery();
            while (rs.next()) {

               id = rs.getInt(1);
            }

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  id;
    }


    public void insertValues (MemberList member){

        try {
            Connection c = connect.geConnection();

            int Max_id =  getMaxId();

            PreparedStatement ps = c.prepareStatement("insert into member_list values(?,?,?,?,?,?,?)");

            ps.setInt(1,Max_id );
            ps.setString(2, member.getName());
            ps.setInt(3, member.getAge());
            ps.setString(4, member.getPhone_num());
            ps.setString(5, member.getAddress());
            ps.setInt(6, member.getLength());
            ps.setInt(7, member.getWeight());

            // check all fileds

            int rows_updat = ps.executeUpdate();    //all operation expect "select" use ps.excutequary()
            System.out.println(rows_updat + " rows inserted");
            c.commit();
        }


        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
