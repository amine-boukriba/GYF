package test;

import entities.Roles;
import entities.Users;
import services.ServiceRoles;
import services.ServicesUsers;


public class Main {
     
         public static void main(String[] args){
             
                ServiceRoles role=new ServiceRoles();
                ServicesUsers user=new ServicesUsers();
                
                role.create(new Roles("admin"));
                user.create(new Users("boukriba","mohamed amine","male",123551231,
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",3));
                role.create(new Roles("simple user"));
                user.create(new Users("haji","abdesatar","male",123551231,
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",4));
                System.out.println("before changes\n-------------------------------------");
                
                System.out.println(user.read()+"********************************************");
                System.out.println(role.read());
                System.out.println("before changes\n-------------------------------------");
                user.update(new Users(1,"boukriba","mohamed amine","male",123551231,
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",1));
                role.update(new Roles(1,"super admin"));
                System.out.println(user.read()+"********************************************");
                System.out.println(role.read());
                
                user.delete(new Users(1,"boukriba","mohamed amine","male",123551231,
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",1));
                user.delete(new Users(2,"haji","abdesatar","male",123551231,
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",1));
                role.delete(new Roles(1,"super admin"));
                role.delete(new Roles(2,"super admin"));
    }         
    
    }
   