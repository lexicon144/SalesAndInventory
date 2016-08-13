 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;


import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;


/**
 *
 * @author John
 * 
 * THIS IS THE BASE CLASS THAT THE PROGRAM NEEDS
 * THIS CLASS GENERATES MOST OF THE NEEDED PARTS
 * FOR THE PROGRAM TO RUN AND EXECUTE I/O PERFECTLY
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
    
    /**
     * ChainSmokersConnection
     * Doesnt ACCEPT ANYTHING!!
     * but it returns a Connection..
     * use IT!!
     * @return
     * @throws ClassNotFoundException 
     */
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
        //string is your... is the SQL string thing... 
        //statement is the statemment object
        //THIS WHOLE METHOD RETURNS A FREAKING
        //RESULT SET!! HAHAHAHHAAH!
        ResultSet yyy = xxx.executeQuery(textQl);
        return yyy;
    }
    /**
     *
     * FixThisFrameOrYourLife
     * SetSize -> INT-INT
     * SetResizable -> Bool
     * SetVisible -> Bool
     * SetLocationRelativeTo -> Component
     * JDialog -> JDialog
     */
    public void fixThisFrameOrYourLife(int A, int B, Boolean J, Boolean K, Component Q, JDialog R){
        
        R.setSize(A, B);
        R.setResizable(J);
        R.setVisible(K);
        R.setLocationRelativeTo(Q);
    }
    /**
     *
     * FixThisFrameOrYourLife
     * SetSize -> INT-INT
     * SetResizable -> Bool
     * SetVisible -> Bool
     * SetLocationRelativeTo -> Component
     * JFrame -> JFrame
     */
    public void fixThisFrameOrYourLife(int A, int B, Boolean J, Boolean K, Component Q, JFrame R){
        
        R.setSize(A, B);
        R.setResizable(J);
        R.setVisible(K);
        R.setLocationRelativeTo(Q);
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

