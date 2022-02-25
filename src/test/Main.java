package test;

import entities.Roles;
import entities.Users;
import services.ServiceRoles;
import services.ServicesUsers;


public class Main {
     
         public static void main(String[] args){
             
                ServiceRoles role=new ServiceRoles();
                ServicesUsers user=new ServicesUsers();
                
                role.ajout(new Roles("admin"));
                user.ajout(new Users("boukriba","mohamed amine","male",123551231,
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",3));
                role.ajout(new Roles("simple user"));
                user.ajout(new Users("haji","abdesatar","male",123551231,
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",4));
                System.out.println("before changes\n-------------------------------------");
                
                System.out.println(user.affiche()+"********************************************");
                System.out.println(role.affiche());
                System.out.println("before changes\n-------------------------------------");
                user.modifier(new Users(3,"boukriba","mohamed amine","male",123551231,
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",1));
                role.modifier(new Roles(4,"super admin"));
                System.out.println(user.affiche()+"********************************************");
                System.out.println(role.affiche());
                
                user.supprime(8);
                user.supprime(7);
                role.supprime(15);
                role.supprime(16);
    }         
    
    }
   