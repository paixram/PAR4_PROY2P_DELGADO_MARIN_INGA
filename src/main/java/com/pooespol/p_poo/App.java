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
/**
 * Clase principal de la aplicación JavaFX.
 * 
 * Esta clase configura y ejecuta la aplicación, cargando recursos y definiendo la interfaz de usuario.
 * 
 * 
 * La clase carga datos del sistema, como clientes, promociones, tarifas y destinos, desde archivos de texto.
 * 
 * 
 * Esta clase extiende la clase Application de JavaFX y define los métodos start(), setRoot() y loadFXML().
 * 
 * 
 * La clase principal de la aplicación se ejecuta desde el método main().
 * 
 */
public class App extends Application {
    
    
    public static Scene scene;
    public static String pathFiles = "src/main/resources/files/";
    public static String pathImages = "src/main/resources/images/";
    
    
    //Recursos datos del sistema
    public static ArrayList<Cliente> lClientes = Cliente.cargarClientes("clientes.txt");
    public static ArrayList<Promocion> lPromociones = Promocion.cargarPromociones("promociones.txt");
    public static ArrayList<Tarifa>lTarifas= Tarifa.cargarTarifas("tarifas.txt");
    public static ArrayList<Destino> lDestinos = Destino.cargarDestinos("destinos.txt");
    public static ArrayList<Vuelo> lVuelos = Vuelo.cargarVuelos("vuelos.txt");
    
    
//    @Override
//    public void start(Stage stage) throws Exception {
//        FXMLLoader fxml =new FXMLLoader(App.class.getResource("VentanaMenu.fxml"));
//        Parent root = fxml.load();
//        scene = new Scene(root,630,320);
//        stage.setScene(scene);
//        stage.show();        
//    }
//  
    /**
     * Método que configura y muestra la escena principal de la aplicación.
     *
     * @param stage el escenario de la aplicación
     * @throws IOException si ocurre un error al cargar el archivo FXML
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("VentanaMenu"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Método que establece la raíz de la escena a partir de un archivo FXML.
     *
     * @param fxml el nombre del archivo FXML
     * @throws IOException si ocurre un error al cargar el archivo FXML
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    /**
     * Método que carga y devuelve el contenido de un archivo FXML como un objeto Parent.
     *
     * @param fxml el nombre del archivo FXML
     * @return el contenido del archivo FXML como un objeto Parent
     * @throws IOException si ocurre un error al cargar el archivo FXML
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    /**
     * Método principal que inicia la aplicación.
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        launch();
    }    
    
}