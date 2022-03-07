/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets;  
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException; 
/**
 *
 * @author boukr
 */
public class Password_hash {
    
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException  
    {  
        /* MessageDigest instance for hashing using SHA512*/  
        MessageDigest md = MessageDigest.getInstance("SHA-512");  
  
        /* digest() method called to calculate message digest of an input and return array of byte */  
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    }  
      
    public static String toHexString(byte[] hash)  
    {  
        /* Convert byte array of hash into digest */  
        BigInteger number = new BigInteger(1, hash);  
  
        /* Convert the digest into hex value */  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        /* Pad with leading zeros */  
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    }  
  
    /* Driver code */  
    public static void main(String args[])  
    {  
        try  
        {  
            String string1 = "ABCD1234";  
            System.out.println("\n" + string1 + " : " + toHexString(getSHA(string1)));  
  
            String string2 = "hashtrial";  
            System.out.println("\n" + string2 + " : " + toHexString(getSHA(string2)));  
        }  
        catch (NoSuchAlgorithmException e)   
        {  
            System.out.println("Exception thrown for incorrect algorithm: " + e);  
        }  
    }  
    
    
}
