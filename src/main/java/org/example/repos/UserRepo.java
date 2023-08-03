package org.example.repos;

import org.example.AppMessages;
import org.example.connect;
import org.example.model.login;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepo {


    public void login_(login l){

        try {
            Connection con = connect.geConnection();

            PreparedStatement pr = con.prepareStatement("SELECT id FROM user WHERE username = ?");

            pr.setString(1, l.getUser());
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                pr = con.prepareStatement("SELECT id FROM user WHERE password = ?");
                pr.setString(1, l.getPassword());
                rs=pr.executeQuery();




                if (rs.next())    JOptionPane.showMessageDialog(null, AppMessages.loginSucess);
                else    JOptionPane.showMessageDialog(null, AppMessages.pass_uncorrect);

            } else {
                JOptionPane.showMessageDialog(null, AppMessages.username_uncorrect);
            }

        }
        catch (SQLException ee) {
            throw new RuntimeException(ee);
        }

    }


}
