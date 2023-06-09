package com.example.proyek2pbo;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
                    + "' and password ='"+password.getText()+"' ";

            String querystaf = "select count(1) from staf where email = '" + email.getText()
                    + "' and password ='"+password.getText()+"' ";

            Statement st = con.createStatement();
            ResultSet rsmember = st.executeQuery(querymember);
            ResultSet rsstaf = st.executeQuery(querystaf);

            while(rsmember.next()){
                if(rsmember.getInt(1) == 1){
                    cobaScene();
                }else if(rsstaf.getInt(1) == 1){
                    SwitchkeSceneStaf();
                }
                else{
                    invalid.setText("invalid, email atau pass salah");
                }
            }
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    protected void SwitchkeSceneStaf(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene_staf = app.getSceneStaf();
        primaryStage.setScene(scene_staf);
    }



    @FXML
    protected void cobaScene(){
        HelloApplication app = HelloApplication.getApplicationInstance();
        Stage primaryStage = app.getPrimaryStage();
        Scene scene_coba = app.getSceneStaf();
        primaryStage.setScene(scene_coba);
    }

}