/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;

/**
 *
 * @author dell
 */
public class dataForModifyPassword {
    
    private static String userName = "", password = "", userType ="";
    //this is the constructor for this class
    //finally... i am now applying what i have learned with sir romar .. YAYAYAYAYAAAAY!
    
    /*
    public dataForModifyPassword(String userName, String password, String userType){
        this.userName = userName;
        this.password = password;
        this.userType = userType;
    }
    */
    
    /**
     * All this data is for
     * Transferring data FROM LOGIN
     * TO -> Mainmenu and stuff
     * 
     */
    public dataForModifyPassword(){
    }
    
    /**
     * Accesses variable UserName
     * @return userName
     */
    public String getUserName(){
        return userName;
    }
    /**
     * Accesses variable Password
     * @return password
     */
    public String getPassword(){
        return password;
    }
    /**
     * Accesses variable UserType
     * @return userType
     */
    public String getUserType(){
        return userType;
    }
    /**
     * Mutates variable UserName
     * @param in 
     */
    public void setUserName(String in){
        this.userName = in;
    }
    /**
     * Mutates variable Password
     * @param in 
     */
    public void setPassword(String in){
        this.password = in;
    }
    /**
     * Mutates variable UserType
     * @param in 
     */
    public void setUserType(String in){
        this.userType = in;
    }
    
}
