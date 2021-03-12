package com.example.myapplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBHelper {

    public List<UserInfo> findAll(){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<UserInfo> list = null;
        try {
            conn = DBService.getConnection();
            String sql = "select * from identity";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            UserInfo userInfo = null;
            list = new ArrayList<UserInfo>();
            while (rs.next()){
                String name = rs.getString("CustomerName");
                String gender = rs.getString("CustomerGender");
                Date birth = rs.getDate("CustomerBirthday");
                int id = rs.getInt("CardIdNo");

                userInfo = new UserInfo();
                userInfo.setCustomerName(name);
                userInfo.setCustomerGender(gender);
                userInfo.setCustomerBirthday(birth);
                userInfo.setCardId(id);

                list.add(userInfo);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBService.closeAll(stmt,conn,rs);
        }
        return list;
    }
}
