package com.site;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String pwd = "Mufe22004";

        Connection con = DriverManager.getConnection(url, user, pwd);
        if(con != null){
            System.out.println("Successfully connected");
        }

        String sql = "SELECT * FROM students";
        Statement statement =
                con.createStatement();
        ResultSet result =
                statement.executeQuery(sql);
        while (result.next()){
            int id = result.getInt("id");
            String name = result.getString("name");
            int age = result.getInt("age");

            System.out.println(id+" "+name+" "+age);
        }

    }
}
