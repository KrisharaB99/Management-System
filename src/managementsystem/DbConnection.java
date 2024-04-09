/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Gangani
 */
public class DbConnection {
    
    private static Connection conn;
    
    private static void connect() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/manage","root","");
        
    }
    
    public static void IUD(String sql) throws Exception{
        if(conn == null){
            connect();
        }
        conn.createStatement().executeUpdate(sql);
    }
    
    public static ResultSet Search(String sql) throws Exception{
        if(conn == null){
            connect();
        }
        return conn.createStatement().executeQuery(sql);
    }
    
   
    
}
