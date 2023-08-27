package org.example.repos;
import org.example.connect;
import org.example.model.MemberList;
import javax.swing.*;
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

        }
        catch (SQLException e) {
            System.out.println( "Error"+e.getMessage());
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

    public Boolean CountNmuber(String num){
        int n=0;
        try {
            Connection co=connect.geConnection();
            PreparedStatement pr=co.prepareStatement(" select count(*) from member_list where phone_num = ?") ;
            pr.setString(1,num);
            ResultSet rs=pr.executeQuery();
            while (rs.next()){
                n=rs.getInt(1);
            }
            if (n==0) return true;
            else  {
                JOptionPane.showMessageDialog(null,"رقم الفون الذي ادخلته موجود مسبقا , ادخل رقم جديد");
            return false;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
            if (rows_updat==1)  JOptionPane.showMessageDialog(null, "تم اضافة عضو جديد");
           // System.out.println(rows_updat + " rows inserted");
            c.commit();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
