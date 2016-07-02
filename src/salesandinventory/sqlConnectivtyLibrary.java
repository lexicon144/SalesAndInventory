/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author John
 */

public class sqlConnectivtyLibrary {
    String sql = "";
    
    public static void connector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_sandv","root","iamgroot");
            Statement stmt = null;
            ResultSet rs = null;
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("EEE" + e.getMessage());
        }
    }
    
}
