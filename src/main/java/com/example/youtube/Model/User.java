package com.example.youtube.Model;

import java.time.LocalDate;
import java.util.Date;

public class User {
    /*  this is user class */


    /** All variable  */
    String username ;
    String email ;
    int id=-1;
    LocalDate date;
    String password ;


    /** Constructors */
    public User(String username,String email,LocalDate date,String passWord  )
    {
     this.username=username;
     this.date=LocalDate.now();
     this.email=email;
     this.password=passWord;
    }





    /* all method */














}
