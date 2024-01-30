package com.pooespol.p_poo;
import com.pooespol.p_poo.modelo.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {
    
    
    public static Scene scene;
    public static String pathFiles = "src/main/resources/files/";
    public static String pathImages = "src/main/resources/images/";
    
    
    //Recursos datos del sistema
    public static ArrayList<Cliente> lClientes = Cliente.cargarClientes("clientes.txt");
    public static ArrayList<Promocion> lPromociones = Promocion.cargarPromociones("promociones.txt");
    
    
//    @Override
//    public void start(Stage stage) throws Exception {
//        FXMLLoader fxml =new FXMLLoader(App.class.getResource("VentanaMenu.fxml"));
//        Parent root = fxml.load();
//        scene = new Scene(root,630,320);
//        stage.setScene(scene);
//        stage.show();        
//    }
//    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("VentanaMenu"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public static void main(String[] args) {
        launch();
    }    
    
}