package com.example.youtube;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Parent root;
    private Stage stage = new Stage();


    @FXML
    protected void onHelloButtonClick() throws IOException {
        welcomeText.setText("Welcome to JavaFX Application!");

        Stage currentStage = (Stage) welcomeText.getScene().getWindow();
        currentStage.close();
        root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Login Page");
        stage.show();

    }
}