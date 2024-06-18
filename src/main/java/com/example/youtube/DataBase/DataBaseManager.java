package com.example.youtube.DataBase;

import com.example.youtube.Model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class DataBaseManager {


      static   Connection connection;
      static   Statement statement;
        private DataBaseManager() {

        }

        /** Start connection in database  */
        private static void StartConnection(){
                try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","");
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
        public static User getUser(String name, String passWord) {
            StartConnection();
            String query = "SELECT * FROM User WHERE username='%s' AND passWord='%s'";
            try {
                query=String.format(query,name,passWord);

                ResultSet rs = statement.executeQuery(query);
                if (rs.next()) {
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String idUser = rs.getString("IDuser");
                    String country = rs.getString("Contry");
                    String password = rs.getString("passWord");
                    String data = rs.getString("Time");

                    EncConnection();
                    return new User(username, email,data,country, password,idUser);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            EncConnection();
            return null;
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
            String query = "INSERT INTO user (username, Email, passWord, IDuser, Time, Contry) values ('%s','%s','%s','%s','%s','%s')";
            UUID uuid = UUID.randomUUID();
            LocalDate localDate = LocalDate.now();

            query = String.format(query, user.getUsername(), user.getEmail(), "1", "12", localDate.toString(), user.getCountry());

            try {
                statement.execute(query);
            } catch (SQLException e) {
                    e.printStackTrace();
            }

            EncConnection();

        }

















}
