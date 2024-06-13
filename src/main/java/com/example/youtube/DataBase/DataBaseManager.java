package com.example.youtube.DataBase;

import com.example.youtube.Model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseManager {


      static   Connection connection;
      static   Statement statement;
        private DataBaseManager() {

        }

        /** Start connection in database  */
        private static void StartConnection(){
                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hangman","root","");
                        statement=connection.createStatement();

                }catch (SQLException | ClassNotFoundException e){
                        e.getMessage();
                }
        }

        /**   End  connection in database  */
        private  static void EncConnection(){
                try {
                        if (connection != null) {
                                statement.close();
                                connection.close();

                        }
                }catch (Exception e){
                        e.getMessage();
                }

        }


        public static User getUser(String name, String passWord ){

                StartConnection();
                String query="SELECT * from User WHERE (name,passWord)  ";







                EncConnection();
                return null;

        }















}
