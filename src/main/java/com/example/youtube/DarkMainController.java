package com.example.youtube;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class DarkMainController {
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
    private AnchorPane sideBar;
    private boolean isSideBarOn = false;
    private Parent root;
    private Stage stage = new Stage();


    @FXML
    protected void onHelloButtonClick() throws IOException {
//        welcomeText.setText("Welcome to JavaFX Application!");

        Stage currentStage = (Stage) homeBackGround.getScene().getWindow();
        currentStage.close();
        root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
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
        Paint gray = Paint.valueOf("#7F7C7C");
        homeBackGround.setFill(gray);
    }
    @FXML
    public void homeExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        homeBackGround.setFill(gray);
    }
    @FXML
    public void shortHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        shortBackGround.setFill(gray);
    }
    @FXML
    public void shortExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        shortBackGround.setFill(gray);
    }
    @FXML
    public void subscriptionHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        subscriptionBackGround.setFill(gray);
    }
    @FXML
    public void subscriptionExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        subscriptionBackGround.setFill(gray);
    }
    @FXML
    public void historyHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        historyBackGround.setFill(gray);
    }
    @FXML
    public void historyExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        historyBackGround.setFill(gray);
    }
    @FXML
    public void playListsHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        playListsBackGround.setFill(gray);
    }
    @FXML
    public void playListsExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        playListsBackGround.setFill(gray);
    }
    @FXML
    public void watchLaterHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        watchLaterBackGround.setFill(gray);
    }
    @FXML
    public void watchLaterExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        watchLaterBackGround.setFill(gray);
    }
    @FXML
    public void likedVideosHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        likedVideosBackGround.setFill(gray);
    }
    @FXML
    public void likedVideosExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        likedVideosBackGround.setFill(gray);
    }
    @FXML
    public void TrendingHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        TrendingBackGround.setFill(gray);
    }
    @FXML
    public void TrendingExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        TrendingBackGround.setFill(gray);
    }
    @FXML
    public void musicHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        musicBackGround.setFill(gray);
    }
    @FXML
    public void musicExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        musicBackGround.setFill(gray);
    }
    @FXML
    public void gamingHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        gamingBackGround.setFill(gray);
    }
    @FXML
    public void gamingExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        gamingBackGround.setFill(gray);
    }
    @FXML
    public void newsHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        newsBackGround.setFill(gray);
    }
    @FXML
    public void newsExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        newsBackGround.setFill(gray);
    }
    @FXML
    public void sportsHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        sportsBackGround.setFill(gray);
    }
    @FXML
    public void sportsExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        sportsBackGround.setFill(gray);
    }
    @FXML
    public void productsHover() {
        Paint gray = Paint.valueOf("#7F7C7C");
        productsBackGround.setFill(gray);
    }
    @FXML
    public void productsExitMouse() {
        Paint gray = Paint.valueOf("#272424");
        productsBackGround.setFill(gray);
    }
}
