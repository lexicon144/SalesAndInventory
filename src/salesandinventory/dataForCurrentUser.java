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
public class dataForCurrentUser {
    //VARIABLE DECLARATION
    private static String user_EmployeeName = null,
            user_Role = null,
            user_Address = null,
            userEmail = null, 
            userGender = null;
    private static int user_Age = 0,
            user_ContactNumber = 0;
    //MUTATOR METHODS
    /**
     * Mutates variable UserEmployeeName
     * @param in 
     */
    public void setUserEmployeeName(String in){
        user_EmployeeName = in;
    }
    /**
     * Mutates variable UserRole
     * @param in 
     */
    public void setUserRole(String in){
        user_Role = in;
    }
    /**
     * Mutates variable UserAddress
     * @param in 
     */
    public void setUserAddress(String in){
        user_Address = in;
    }
    /**
     * Mutates variable UserAge
     * @param in 
     */
    public void setUserAge(int in){
        user_Age = in;
    }
    /**
     * Mutates variable UserContactNumber
     * @param in 
     */
    public void setUserContactNumber(int in){
        user_ContactNumber = in;
    }
    /**
     * Mutates variable UserEmail
     * @param in 
     */
    public void setUserEmail(String in){
        userEmail = in;
    }
    /**
     * Mutates variable UserGender
     * @param in 
     */
    public void setUserGender(String in){
        userGender = in;
    }
    //ACCESSOR METHODS
    /**
     * Accesses variable UserEmployeeName
     * @return user_EmployeeName
     */
    public String getUserEmployeeName(){
        return user_EmployeeName;
    }
    /**
     * Accesses variable UserRole
     * @return user_Role
     */
    public String getUserRole(){
        return user_Role;
    }
    /**
     * Accesses variable UserAddress
     * @return user_Address
     */
    public String getUserAddress(){
        return user_Address;
    }
    /**
     * Accesses variable UserAge
     * @return user_Age
     */
    public int getUserAge(){
        return user_Age;
    }
    /**
     * Accesses variable UserContactNumber
     * @return user_ContactNumber
     */
    public int getUserContactNumber(){
        return user_ContactNumber;
    }
    /**
     * Accesses variable UserEmail
     * @return userEmail
     */
    public String getUserEmail(){
        return userEmail;
    }
    /**
     * Accesses variable UserGender
     * @return userGender
     */
    public String getUserGender(){
        return userGender;
    }
}
