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
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",1));
                role.create(new Roles("simple user"));
                user.create(new Users("haji","abdesatar","male",123551231,
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",1));
                
    }
    
    }
   