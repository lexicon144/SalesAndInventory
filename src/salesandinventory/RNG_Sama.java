/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesandinventory;

import java.util.Random;

/**
 *
 * @author dell
 */
public class RNG_Sama {
    
    public int RNGmaker(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(999999999);
    }
}
