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
    
    public dataForModifyPassword(){
    }
    
    //These are the accessor methods..
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getUserType(){
        return userType;
    }
    //these are the mutator methods..
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setUserType(String userType){
        this.userType = userType;
    }
    
}
