 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author John
 */
public class SalesAndInventory {
String sql="";


static String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

     public static Boolean isAdminPresent; //this thing gets initialized EVERYTIME so therefore changing its value to NULL... dayum.. that sucks :(
     public PreparedStatement pStmt;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    protected Connection chainSmokersConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_sandv","root","");
            if (con == null){
                System.out.println("Can't establish connection for ModifyPassword.java");
            }
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(frm_ModifyPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    return null;
    }
    
    protected ResultSet zeddSet(Statement xxx, String textQl) throws SQLException{
        ResultSet yyy = xxx.executeQuery(textQl);
        return yyy;
    }
    
    
    
    //THESE FUNCTIONS MODIFY the ISADMINPRESENT
    /*
    public boolean getAdmin(){
        return isAdminPresent;
    }
    public void setAdmin(boolean whoIsUser){
        isAdminPresent = whoIsUser;
    }
    */
}

