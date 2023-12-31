package org.example.repos;
import org.example.connect;
import org.example.model.GetSubscribeDetails;
import org.example.model.SubscribeList;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SavaSubscribeRepo {
    public int getMaxId_subscribes(){

        int id = 0;
        try {
            Connection co= connect.geConnection();

            PreparedStatement p=co.prepareStatement("SELECT COALESCE(MAX(id) + 1, 1) AS id FROM subscribes ");
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

public List<SubscribeList> GetDataFromSql(){
        List<SubscribeList>list=new ArrayList<>();
    try {
        Connection c=connect.geConnection();
        PreparedStatement pr=c.prepareStatement("  select s.id , ml.name,st.name,ps.price,s.date_start\n" +
                " from subscribes as s\n" +
                " inner join member_list as ml\n" +
                " inner join subscribe_price as ps\n" +
                " inner join subscribe_type as st\n" +
                " where ml.id=s.id_member and ps.id=s.Subscription_price and st.id=s.Subscription_price ;");
        ResultSet rs=pr.executeQuery();
        while (rs.next()){
            SubscribeList s1=new SubscribeList(rs.getString(1) , rs.getString(2) ,
                    rs.getString(3) , rs.getInt(4) , rs.getDate(5));
            list.add(s1);

        }


        return  list;
    }
    catch (SQLException e) {
        throw new RuntimeException(e);
    }

}

public int CheckId(int id) {
    int id_;
    try {
        id_ = 0;
        Connection c = connect.geConnection();
        PreparedStatement pr = c.prepareStatement("select count(*) from subscribes where id_member =?");
        pr.setInt(1, id);
        ResultSet rs = pr.executeQuery();
        while (rs.next()) {
            id_ = rs.getInt(1);
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    return id_;
}




    public void inservalues(GetSubscribeDetails s){
        try {

            LocalDate currentDate = LocalDate.now();
            Connection c = connect.geConnection();
            PreparedStatement pr=c.prepareStatement("insert into subscribes values(?,?,?,?,?)");
          pr.setInt(1,getMaxId_subscribes());
            pr.setInt(2,s.id1);
            pr.setInt(3,s.id2);
            pr.setInt(4,s.id2);
            pr.setDate(5, Date.valueOf(currentDate));

            if (CheckId(s.id1)>=1) JOptionPane.showMessageDialog(null, "تم اضافه هذا العضو من قبل");
            else {
                int rows_updat = pr.executeUpdate();    //all operation expect "select" use ps.excutequary()
                if (rows_updat == 1) JOptionPane.showMessageDialog(null, "تم اضافة اشتراك جديد");
            }
            c.commit();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
