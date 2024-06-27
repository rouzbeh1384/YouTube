package com.example.youtube.DataBase;

import com.example.youtube.Model.*;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class DataBaseManager {


    static Connection connection;
    static Statement statement;

    private DataBaseManager() {

    }

    /**
     * Start connection in database
     */
    private static void StartConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube", "root", "");
            statement = connection.createStatement();

        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
    }

    /**
     * End  connection in database
     */
    private static void EncConnection() {
        try {
            if (connection != null) {
                statement.close();
                connection.close();

            }
        } catch (Exception e) {
            e.getMessage();
        }

    }

    /**
     * get method
     */

    // getUser form database
    public static User getUser(String name, String passWord) {
        StartConnection();
        String query = "SELECT * FROM User WHERE username='%s' AND passWord='%s'";
        try {
            query = String.format(query, name, passWord);

            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String idUser = rs.getString("IDuser");
                String country = rs.getString("Contry");
                String password = rs.getString("passWord");
                String data = rs.getString("Time");

                EncConnection();
                return new User(username, email, data, country, password, idUser);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        EncConnection();
        return null;
    }


    //getChannel with  0= username  1=UUID
    //table  ID_chanel	Name	information	image	username


    public static Channel getChannel(String identifier, int number) {
        StartConnection();
        String query;
        if (number == 0) {
            query = "SELECT * FROM chanel WHERE username='%s'";
        } else {
            query = "SELECT * FROM chanel WHERE ID_chanel='%s'";
        }

        try {
            query = String.format(query, identifier);

            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                String username = rs.getString("username");
                String name = rs.getString("Name");
                String image = rs.getString("image");
                String ID_chanel = rs.getString("ID_chanel");
                String information = rs.getString("information");
                EncConnection();
                return new Channel(ID_chanel, name, information, username, image);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        EncConnection();
        return null;
    }


    //this is for get video from chanel ALL
    public static ArrayList<Video> getList_video(String chanel) {
        ArrayList<Video> videos = new ArrayList<>();
        StartConnection();

        String query = "SELECT * FROM video WHERE Chanel_ID=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, chanel);
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
                videos.add(new Video(path, ID_video, Chanel_ID, name, information, time_uplode, PlayTime, like, Dis_like, view));
            }
            EncConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return videos;
    }


    public static ArrayList<Comment> getListComment(String video_ID) {

        //TODO 2 way for this 1-add column in comment table or join with user table
        StartConnection();
        String query = "SELECT * FROM  comment WHERE ID_video=? ";
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String comment = resultSet.getString("comment");
                String witer = resultSet.getString("witerer");
                String ID_video = resultSet.getString("ID_video");
                int like = resultSet.getInt("like");
                int dislike = resultSet.getInt("dislike");
                String time = resultSet.getString("Time");
                String UserID = resultSet.getString("UserID");


                comments.add(new Comment(comment, UserID, witer, ID_video, time, like, dislike));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        EncConnection();
        return comments;

    }

    public static ArrayList<PlayList> getPlayList() {

        StartConnection();
        String query = "SELECT * FROM playlist     JOIN  category_video ON video.ID_video = category_video.ID_video WHERE category_video.category=? ";
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
                videos.add(new Video(path, ID_video, Chanel_ID, name, information, time_uplode, PlayTime, like, Dis_like, view));
            }
            EncConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return videos;
    }


    /**
     * insert method
     */


    //insert User in chanel TODO check in User
    public static boolean insertUser(User user) {

        StartConnection();
        String query = "INSERT INTO user (username, Email, passWord, IDuser, Time, Contry) values ('%s','%s','%s','%s','%s','%s')";
        LocalDate localDate = LocalDate.now();

        //TODO you can set time for user now or when create a user
        query = String.format(query, user.getUsername(), user.getEmail(), user.getPassword(), user.getID(), localDate.toString(), user.getCountry());

        try {
            statement.execute(query);
        } catch (SQLIntegrityConstraintViolationException e) {
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        EncConnection();
        return true;
    }

    //insert chanel complete
    //String id,String name,String description,String username,String image
    public static boolean insertChanel(Channel channel) {

        StartConnection();
        String query = "INSERT INTO chanel (ID_chanel,Name,information,image,username) VALUES ('%s','%s','%s','%s','%s')";
        query = String.format(query, channel.getId(), channel.getName(), channel.getDescription(), channel.getImage(), channel.getUsername());
        try {

            statement.execute(query);

        } catch (SQLIntegrityConstraintViolationException e) {
            return false;
        } catch (Exception e) {
            e.getMessage();
        }


        EncConnection();
        return true;

    }


    //insert video in
    public static boolean insertVideo(Video video) {

        StartConnection();
        for (String x : video.getHashtagsList()) {
            String query1 = "INSERT INTO category_video (category,ID_video) " +
                    "VALUES (?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(query1);
                statement.setString(1, x);
                statement.setString(2, video.getID());
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
        } catch (SQLIntegrityConstraintViolationException e) {
            return false;
        } catch (SQLException ee) {
            throw new RuntimeException(ee);
        }
        EncConnection();
        return true;
    }


    public static boolean insertPLayList(PlayList playList) {
        StartConnection();
        String query = "INSERT INTO playList (ID_PlayList,name,discribe) values ('%s','%s','%s')";
        query = String.format(query, playList.getID(), playList.getName(), playList.getDescription());
        try {
            statement.execute(query);
        } catch (SQLIntegrityConstraintViolationException er) {
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        EncConnection();
        return true;

    }

    public static boolean insertComment(Comment comment, String wirter) {

        StartConnection();
        String query = "INSERT INTO comment (comment,wirter,UserID,ID_video,`like`,dislike,Time) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, comment.getText());
            statement.setString(2, wirter);
            statement.setString(3, comment.getUserID());
            statement.setString(4, comment.getVideoID());
            statement.setInt(5, 0);
            statement.setInt(6, 0);
            statement.setString(7, String.valueOf(comment.getTime()));
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        EncConnection();
        return true;


    }





    public static boolean AddPlayList(String IDP,String IDC){
        StartConnection();
        String query="INSERT INTO joinplaylistto_chanel (ID_Playlist,ID_chanel) VALUES ('%s','%s')";
        query=String.format(query,IDP,IDC);
        try {
            statement.execute(query);

        } catch (SQLIntegrityConstraintViolationException er) {
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        EncConnection();
        return true;
    }




    public static boolean insertIntoHistory (String IDV,String IDU){
        StartConnection();
        String query="INSERT INTO viode_history (IDUser,IDVideo,Time) VALUES ('%s','%s','%s')";
        LocalDateTime localDate= LocalDateTime.now();
        query=String.format(query,IDV,IDU,String.valueOf(localDate));
        try {
            statement.execute(query);

        } catch (SQLIntegrityConstraintViolationException er) {
            return false;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        EncConnection();
        return true;

    }

    /**
     * delete
     */
    public static void deleteVideo(String idV, String idC) {

        StartConnection();
        String query = "DELETE FROM video WHERE ID_video ='%s' AND    Chanel_ID='%s' ";
        query = String.format(query, idV, idC);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        EncConnection();


    }

    public static void deleteUser(String idU, String passWord) {

        StartConnection();
        String query = "DELETE FROM user WHERE IDuser ='%s' AND passWord='%s' ";
        query = String.format(query, idU, passWord);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        EncConnection();
    }

    public static void deleteChanel(String idc) {
        StartConnection();
        String query = "DELETE FROM Chanel WHERE ID_chanel ='%s'  ";
        query = String.format(query, idc);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        EncConnection();
    }

    public static void deletePlayList(String idp) {
        StartConnection();
        String query = "DELETE FROM playlist WHERE ID_Playlist ='%s'  AND   ";
        query = String.format(query, idp);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        EncConnection();
    }


    public static void deleteComment(String IDU, String IDV) {

        StartConnection();
        String query = "DELETE FROM playlist WHERE UserID ='%s'  AND ID_video='%s'  ";
        query = String.format(query, IDU, IDV);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        EncConnection();
    }

    public static boolean deleteFormHistory(String IDU, String IDV, String action, int Min) {
        StartConnection();
        String query = "";

        if (action.equals("1")) {
            query = "DELETE FROM viode_history WHERE IDVideo = ? AND idUser = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, IDV);
                ps.setString(2, IDU);
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (action.equals("2")) {
            query = "DELETE FROM viode_history WHERE idUser = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, IDU);
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else if (action.equals("3")) {
            query = "SELECT * FROM viode_history WHERE idUser = ?";
            try (PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setString(1, IDU);
                try (ResultSet resultSet = ps.executeQuery()) {
                    while (resultSet.next()) {
                        LocalDateTime localDateTime = LocalDateTime.parse(resultSet.getString("Time"));
                        int hourDiff = LocalDateTime.now().getMinute() - localDateTime.getMinute();
                        System.out.println(hourDiff);
                        if (hourDiff > Min) {
                            String deleteQuery = "DELETE FROM viode_history WHERE IDVideo = ? AND idUser = ?";
                            try (PreparedStatement deletePs = connection.prepareStatement(deleteQuery)) {
                                deletePs.setString(1, resultSet.getString("IDVideo"));
                                deletePs.setString(2, resultSet.getString("idUser"));
                                deletePs.executeUpdate();
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        EncConnection();
        return true;
    }


    /**
     * update method
     */

    //update user information
    public static void UpdateUserInformation(User user) {
        StartConnection();
        String query = "UPDATE User SET username = '%s', Email = '%s', passWord = '%s', Contry = '%s' WHERE IDuser = '%s'";
        query = String.format(query, user.getUsername(), user.getEmail(), user.getPassword(), user.getCountry(), user.getID());
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        EncConnection();
    }


    public static void UpdateChanelInfromation(Channel channel){
        StartConnection();
        String query = "UPDATE Chanel SET username = '%s', image = '%s', Name  = '%s', information = '%s' WHERE ID_chanel = '%s'";
        query = String.format(query, channel.getUsername(), channel.getImage(), channel.getDescription(), channel.getName(), channel.getId());
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        EncConnection();

    }
    public static boolean UpdatPlayListInfromation(PlayList playList){
        StartConnection();
        String query = "UPDATE playList SET name ='%s' ,discribe ='%s' WHERE ID_Playlist='%s'";
        query = String.format(query, playList.getName(), playList.getDescription(), playList.getID());
        try {
            statement.execute(query);
            EncConnection();
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        EncConnection();
        return false;

    }






}
