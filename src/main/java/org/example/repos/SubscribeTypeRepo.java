package org.example.repos;

import org.example.connect;
import org.example.model.SubscribeType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscribeTypeRepo {
    public List<SubscribeType> getAll() {

        List<SubscribeType> list = new ArrayList<>();
        try {
            Connection c = connect.geConnection();
            PreparedStatement pr = c.prepareStatement("select id , name from subscribe_type");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                SubscribeType subscribeType = new SubscribeType(rs.getInt(1) ,rs.getString(2) );
                list.add(subscribeType);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list; // id and name
    }





    }
