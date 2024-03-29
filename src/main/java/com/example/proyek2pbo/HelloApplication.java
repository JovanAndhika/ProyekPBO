package com.example.proyek2pbo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloApplication extends Application {

    //DATABASE CONNECTION
    final static String driver = "com.mysql.cj.jdbc.Driver";
    final static String databaseName = "laundry";
    final static String url = "jdbc:mysql://localhost/" + databaseName;
    final static String user = "root";
    final static String password = "";

    public static Connection createDatabaseConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }


    //SET STAGE
    private Stage primaryStage;
    private Scene SceneLogin;
    private com.example.proyek2pbo.SceneLogin sceneLoginController;


    //Scene untuk daftar member
    private Scene sceneMember;
    private SceneMember sceneMemberController;


    //Scene untuk daftar staf
    private Scene sceneStaf;
    private SceneStaf sceneStafController;


    public HelloApplication(){
        applicationInstance = this;
    }

    private static HelloApplication applicationInstance;

    public static HelloApplication getApplicationInstance(){
        return applicationInstance;
    }


    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SceneLogin.fxml"));
        SceneLogin =  new Scene(fxmlLoader.load(), 800, 600);
        sceneLoginController = fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SceneMember.fxml"));
        sceneMember = new Scene(fxmlLoader.load(), 800, 600);
        sceneMemberController =  fxmlLoader.getController();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SceneStaf.fxml"));
        sceneStaf = new Scene(fxmlLoader.load(), 800, 600);
        sceneStafController =  fxmlLoader.getController();

        stage.setTitle("Hello!");
        stage.setScene(SceneLogin);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public Scene getSceneLogin() {
        return SceneLogin;
    }

    public com.example.proyek2pbo.SceneLogin getSceneLoginController() {
        return sceneLoginController;
    }

    public Scene getSceneMember() {
        return sceneMember;
    }

    public SceneMember getSceneMemberController() {
        return sceneMemberController;
    }

    public Scene getSceneStaf() {
        return sceneStaf;
    }

    public SceneStaf getSceneStafController() {
        return sceneStafController;
    }
}