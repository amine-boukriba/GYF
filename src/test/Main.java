package test;

import entities.Users;
import services.ServicesUsers;


public class Main {
     
         public static void main(String[] args){
                ServicesUsers user=new ServicesUsers();
                user.create(new Users("boukriba","mohamed amine","male",123551231,
                        "mohamed@gmail.com","tunisia","tunis",4534,"2021-01-22",0));
    }
    
    }
   