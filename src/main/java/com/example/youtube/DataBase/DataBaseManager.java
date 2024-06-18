package com.example.youtube.DataBase;

import com.example.youtube.Model.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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




        /** get method  */

        //getUser
        public static User getUser(String name, String passWord ){
                StartConnection();
                String query="SELECT * from User WHERE name='%s',passWord= '%s' ";
                query=String.format(query,name,passWord);
            try {
                statement.execute(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            EncConnection();
                // complete this line with correct answer
                return new User("13","123","1321","123","123","123");

        }
        //getChannel
        public static Channel getChannel(String name, String passWord ){

            StartConnection();
            String query="SELECT * from User WHERE (name,passWord)  ";
            EncConnection();
            return null;

        }

        //this is for get video from
        public static ArrayList<Video> getList_video (String name, String passWord ){

            StartConnection();
            //TODO  get name and send the list of video
            EncConnection();
            return null;

        }
        public static ArrayList<Comment> getListComment(){

            StartConnection();
            String query="SELECT * from User WHERE (name,passWord)  ";
            EncConnection();
            return null;

        }
        public static ArrayList<PlayList>getPlayList(){

            StartConnection();
            EncConnection();
            return null;

        }
        public static ArrayList<Video> getListVideoByca(){

            StartConnection();
            String query="SELECT * from User WHERE (name,passWord)  ";
            EncConnection();
            return null;

        }



        /** insert method*/
        public static void insertUser(User  user){

            StartConnection();

            String query ="INSERT INTO  user (username,Email,passWord,IDuser,Time ,Country ) values ('%s','%s','%s','%s','%s','%s')";

            EncConnection();

        }

















}
