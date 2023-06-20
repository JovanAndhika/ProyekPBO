package com.example.proyek2pbo;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.*;

public class SceneLogin {
    @FXML
    private Label welcomeText;
    @FXML
    private Text invalid;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private Button login;
    @FXML
    private Button mbsign;
    @FXML
    private Button stsign;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void SwitchkeSceneMember() {
        HelloApplication app = HelloApplication.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene_member = app.getSceneMember();
        primaryStage.setScene(scene_member);
    }



    @FXML
    protected void CekValiditasLogin(){
        try {
            Connection con = HelloApplication.createDatabaseConnection();
            String querymember = "select count(1) from member where email = '" + email.getText()
                    + "' and password ='"+password.getText()+"'";

            PreparedStatement ps = con.prepareStatement(querymember);
            ps.execute();
            SwitchSceneMember();


            querymember = "select count(1) from staff where email = '" + email.getText()
                    + "' and password ='"+password.getText()+"'";
            ps = con.prepareStatement(querymember);
            ps.execute();
            SwitchSceneStaf();

        } catch (ClassNotFoundException e) {
            invalid.setText("invalid, email atau pass salah");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    protected void SwitchSceneStaf(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene_staf = app.getSceneStaf();
        primaryStage.setScene(scene_staf);
    }



    @FXML
    protected void SwitchSceneMember(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene_coba = app.getSceneStaf();
        primaryStage.setScene(scene_coba);
    }

}