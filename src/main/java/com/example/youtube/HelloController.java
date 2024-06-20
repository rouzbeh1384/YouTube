package com.example.youtube;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Rectangle homeBackGround;
    @FXML
    private Rectangle shortBackGround;
    @FXML
    private Rectangle subscriptionBackGround;
    @FXML
    private Rectangle historyBackGround;
    @FXML
    private Rectangle watchLaterBackGround;
    @FXML
    private Rectangle likedVideosBackGround;
    @FXML
    private Rectangle TrendingBackGround;
    @FXML
    private Rectangle musicBackGround;
    @FXML
    private Rectangle gamingBackGround;
    @FXML
    private Rectangle newsBackGround;
    @FXML
    private Rectangle sportsBackGround;
    @FXML
    private Rectangle productsBackGround;
    @FXML
    private Rectangle playListsBackGround;
    @FXML
    private Button a;
    @FXML
    private AnchorPane sideBar;
    private boolean isSideBarOn = false;
    private Parent root;
    private Stage stage = new Stage();


    @FXML
    protected void onHelloButtonClick() throws IOException {

        Stage currentStage = (Stage) homeBackGround.getScene().getWindow();
        currentStage.close();
        root = FXMLLoader.load(getClass().getResource("darkHomePage.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Login Page");
        stage.show();

    }
    @FXML
    protected void sideBarBtnClick() {
        sideBar.setVisible(!isSideBarOn);
        isSideBarOn = !isSideBarOn;
    }

    @FXML
    public void homeHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        homeBackGround.setFill(gray);
    }
    @FXML
    public void homeExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        homeBackGround.setFill(gray);
    }
    @FXML
    public void shortHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        shortBackGround.setFill(gray);
    }
    @FXML
    public void shortExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        shortBackGround.setFill(gray);
    }
    @FXML
    public void subscriptionHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        subscriptionBackGround.setFill(gray);
    }
    @FXML
    public void subscriptionExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        subscriptionBackGround.setFill(gray);
    }
    @FXML
    public void historyHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        historyBackGround.setFill(gray);
    }
    @FXML
    public void historyExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        historyBackGround.setFill(gray);
    }
    @FXML
    public void playListsHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        playListsBackGround.setFill(gray);
    }
    @FXML
    public void playListsExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        playListsBackGround.setFill(gray);
    }
    @FXML
    public void watchLaterHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        watchLaterBackGround.setFill(gray);
    }
    @FXML
    public void watchLaterExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        watchLaterBackGround.setFill(gray);
    }
    @FXML
    public void likedVideosHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        likedVideosBackGround.setFill(gray);
    }
    @FXML
    public void likedVideosExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        likedVideosBackGround.setFill(gray);
    }
    @FXML
    public void TrendingHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        TrendingBackGround.setFill(gray);
    }
    @FXML
    public void TrendingExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        TrendingBackGround.setFill(gray);
    }
    @FXML
    public void musicHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        musicBackGround.setFill(gray);
    }
    @FXML
    public void musicExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        musicBackGround.setFill(gray);
    }
    @FXML
    public void gamingHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        gamingBackGround.setFill(gray);
    }
    @FXML
    public void gamingExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        gamingBackGround.setFill(gray);
    }
    @FXML
    public void newsHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        newsBackGround.setFill(gray);
    }
    @FXML
    public void newsExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        newsBackGround.setFill(gray);
    }
    @FXML
    public void sportsHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        sportsBackGround.setFill(gray);
    }
    @FXML
    public void sportsExitMouse() {
        Paint gray = Paint.valueOf("#fff");
        sportsBackGround.setFill(gray);
    }
    @FXML
    public void productsHover() {
        Paint gray = Paint.valueOf("#CBC6C6");
        productsBackGround.setFill(gray);
    }
    @FXML
    public void productsExitMouse() {
        Paint gray = Paint.valueOf("#fff");
       productsBackGround.setFill(gray);
    }
}