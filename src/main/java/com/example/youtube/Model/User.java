package com.example.youtube.Model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class User {
    /*  this is user class */

    private String username ;
    private String email ;
    private String ID;
    private LocalDate date;
    private String password ;
    private String country;

    /** Constructors */
    public User(String username,String email,String date,String passWord,String country,String ID)
    {
     this.username=username;
     this.date=LocalDate.parse(date);
     this.email=email;
     this.password=passWord;
     this.country=country;
     this.ID=ID;
    }

    public String getUsername() {
        return username;
    }

    public String getCountry() {
        return country;
    }

    public String getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void changeCountry(String country) {
        this.country = country;
        //add database method
    }

    public void changePassword(String password) {
        this.password = password;
        //add database method
    }

    public void changeUsername(String username) {
        this.username = username;
        //add database method
        // you should know this is unique
    }
}
