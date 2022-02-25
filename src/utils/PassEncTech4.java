/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
   
public class PassEncTech4  
{  
    PassBasedEnc encrypter;
    public static void main(String[] args)  
    {  
        /* Plain text Password. */  
        String password = "myNewPass123";  
          
        /* generates the Salt value. It can be stored in a database. */  
        String saltvalue = PassBasedEnc.getSaltvalue(30);  
          
        /* generates an encrypted password. It can be stored in a database.*/  
        String encryptedpassword = PassBasedEnc.generateSecurePassword(password, saltvalue);  
          
        /* Print out plain text password, encrypted password and salt value. */  
        System.out.println("Plain text password = " + password);  
        System.out.println("Secure password = " + encryptedpassword);  
        System.out.println("Salt value = " + saltvalue);  
          
        /* verify the original password and encrypted password */  
        Boolean status = PassBasedEnc.verifyUserPassword(password,encryptedpassword,saltvalue);  
        if(status==true)  
            System.out.println("Password Matched!!");  
        else  
            System.out.println("Password Mismatched");  
    }  
}  
  

