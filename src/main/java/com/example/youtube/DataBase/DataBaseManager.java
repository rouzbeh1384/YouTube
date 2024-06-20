package com.example.youtube.DataBase;

import com.example.youtube.Model.*;

import java.io.IOException;
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

        // getUser form database
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

        //getChannel with  0= username  1=UUID
        //table  ID_chanel	Name	information	image	username
        public static Channel getChannel(String identifier,int number){
            StartConnection();
            String query;
            if(number==0) {
                query= "SELECT * FROM chanel WHERE username='%s'";
            }
            else{
                query="SELECT * FROM chanel WHERE ID_chanel='%s'";
            }

            try {
                query=String.format(query,identifier);

                ResultSet rs = statement.executeQuery(query);
                if (rs.next()) {
                    String username = rs.getString("username");
                    String name =rs.getString("Name");
                    String image = rs.getString("image");
                    String ID_chanel = rs.getString("ID_chanel");
                    String information = rs.getString("information");
                    EncConnection();
                    return new Channel(ID_chanel,name,information,username,image);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            EncConnection();
            return null;
        }
        //this is for get video from chanel ALL
        //ID_video	Chanel_ID	time_uplode	view	PlayTime	like	Dis_like	name	information	category
        //                      1       2           3
        //    public Video(String ID,String name,String description,String uplaodTime,
        //                  Integer duration,Integer like,Integer deslike,Integer view)
    public static ArrayList<Video> getList_video (String chanel  ){
            ArrayList<Video> videos=new ArrayList<>();
            String query;
            StartConnection();
            query="SELECT * FROM video ";
//            query="SELECT `ID_video`, `Chanel_ID`, `time_uplode`, `view`, `PlayTime`, `like`, `Dis_like`, `name`, `information` FROM `video` WHERE 1";
            query=String.format(query,chanel);
            try{
                ResultSet resultSet=statement.executeQuery(query);
                System.out.println(resultSet.getFetchSize());
                while (resultSet.next()){
                String  IDVidoe=   resultSet.getString("ID_video");
                String Chanel_ID =   resultSet.getString("Chanel_ID");
                String  time_uplode=   resultSet.getString("time_uplode");
                int view =   resultSet.getInt("view");
                int playTime =   resultSet.getInt("PlayTime");
                int  like=   resultSet.getInt("like");
                int  Dis_like =   resultSet.getInt("Dis_like");
                String  name=   resultSet.getString("name");
                String information=        resultSet.getString("information");

//                videos.add(new Video(IDVidoe,name ,information,time_uplode,playTime,like,Dis_like,view,Chanel_ID));
                }
                return videos;
            }catch (Exception e){
                e.getMessage();
            }
            EncConnection();
            return null;
        }
        public static ArrayList<Comment> getListComment(String video_ID ){

            //TODO 2 way for this 1-add column in comment table or join with user table
            StartConnection();
            String query="SELECT * FROM  comment WHERE ID_video=? " ;
            ArrayList<Comment>comments=new ArrayList<>();
            try {
                //comment		witerer	ID_video	like	dislike
               ResultSet resultSet= statement.executeQuery(query);
               while (resultSet .next()){
                    String comment =resultSet.getString("comment");
                    String witer =resultSet.getString("witerer");
                   String ID_video =resultSet.getString("ID_video");
                   int like =resultSet.getInt("like");
                   int dislike=resultSet.getInt("dislike");
                   String time =resultSet.getString("Time");
                   String UserID =resultSet.getString("UserID");



                   comments.add(new Comment(comment,UserID,witer,ID_video,time,like,dislike));
               }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            EncConnection();
            return comments;

        }
        public static ArrayList<PlayList>getPlayList(){

            StartConnection();

            EncConnection();
            return null;

        }



    public static ArrayList<Video> getListVideoByCategory(String category) {
        ArrayList<Video> videos = new ArrayList<>();
        StartConnection();

        String query = "SELECT * FROM video   JOIN  category_video ON video.ID_video = category_video.ID_video WHERE category_video.category=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, category);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String path = resultSet.getString("path");
                String ID_video = resultSet.getString("ID_video");
                String Chanel_ID = resultSet.getString("Chanel_ID");
                String time_uplode = resultSet.getString("time_uplode");
                int view = resultSet.getInt("view");
                int PlayTime = resultSet.getInt("PlayTime");
                int like = resultSet.getInt("like");
                int Dis_like = resultSet.getInt("Dis_like");
                String name = resultSet.getString("name");
                String information = resultSet.getString("information");
                String categr=resultSet.getString("category");
//              videos.add(new Video(path, ID_video, Chanel_ID, name, information, time_uplode, PlayTime, like, Dis_like, view));
                System.out.println((categr+ path+"\t"+ ID_video+"\t"+ Chanel_ID+"\t"+ name+"\t"+ information+"\t"+ time_uplode+ PlayTime+ like+ Dis_like+ view));
            }
            EncConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return videos;
    }







        /** insert method*/
        //insert User in chanel TODO check in User
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

        //insert chanel complete
        // ID_chanel	Name	information	image	username
        public static void insertChanel (String Name ,String username,String ID_chanel,String image,String information){


            StartConnection();
            String query ="INSERT INTO chanel (ID_chanel,Name,information,image,username) VALUES ('%s','%s','%s','%s','%s')";
            query=String.format(query,ID_chanel,Name,information,image,username);
            try{

                statement.execute(query);

            }catch (Exception e){
                e.getMessage();
            }


            EncConnection();
        }



        //insert video in
        public static void insertVideo(Video video) {

            StartConnection();
            for (String x:video.getHashtagsList()) {
                String query1 = "INSERT INTO category_video (category,ID_video) " +
                        "VALUES (?,?)";
                try {
                    PreparedStatement statement = connection.prepareStatement(query1);
                    statement.setString(1,x);
                    statement.setString(2,video.getID());
                    statement.execute();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }


            String query = "INSERT INTO video (Path, ID_video, Chanel_ID, time_uplode, view, PlayTime, `like`, Dis_like, name, information) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, video.getPath());
                statement.setString(2, video.getID());
                statement.setString(3, video.getIDChanel());
                statement.setString(4, String.valueOf(video.getUploadTime()));
                statement.setInt(5, video.getView());
                statement.setInt(6, video.getDuration());
                statement.setInt(7, video.getLike());
                statement.setInt(8, (int) video.getDeslike());
                statement.setString(9, video.getName());
                statement.setString(10, video.getDescription());
                statement.execute();
            } catch (SQLException ee) {
                throw new RuntimeException(ee);
            }
            EncConnection();
        }


}
