/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;


import java.sql.PreparedStatement;

/**
 *
 * @author John
 */
public class SalesAndInventory {
String sql="";
static String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";


    /**
     *
     */
     public static Boolean isAdminPresent; //this thing gets initialized EVERYTIME so therefore changing its value to NULL... dayum.. that sucks :(
PreparedStatement pStmt;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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

