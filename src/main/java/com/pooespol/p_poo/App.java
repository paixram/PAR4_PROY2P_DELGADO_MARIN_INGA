package com.pooespol.p_poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static String pathFiles = "src/main/resources/files/";
    public static String pathImages = "src/main/resources/images/";
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxml =new FXMLLoader(App.class.getResource("VentanaBienvenida.fxml"));
        Parent root = fxml.load();
        scene = new Scene(root,630,320);
        stage.setScene(scene);
        stage.show();        
    }
    
    public static void main(String[] args) {
        launch();
    }    
    
}