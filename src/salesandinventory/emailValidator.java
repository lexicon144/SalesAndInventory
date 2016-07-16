/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;

/**
 *
 * @author John
 */
public class emailValidator {
    String EMAIL_REGEX = "\"^[\\\\w-_\\\\.+]*[\\\\w-_\\\\.]\\\\\n@([\\\\w]+\\\\.)+[\\\\w]+[\\\\w]$";
    
	public boolean dva(String takeThisIn){
            return takeThisIn.matches(EMAIL_REGEX);
        }

}
