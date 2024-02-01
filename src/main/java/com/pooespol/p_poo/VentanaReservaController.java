package com.pooespol.p_poo;
import com.pooespol.p_poo.modelo.*;
import java.io.IOException;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author José Marin
 */
public class VentanaReservaController implements Initializable {
    
    
    @FXML
    Button btnBuscar;
    @FXML
    Spinner<Integer> spNumViajeros;
    @FXML
    DatePicker dpSalida;
    @FXML
    DatePicker dpRegreso;
    @FXML
    ComboBox cbxOrigen;
    @FXML
    ComboBox cbxDestino;
    
    public static String origen;
    public static String destino;
    public static Date salida;
    public static Date regreso;
    public static int cantViajeros;
    
    
     /**
     * Initializes the controller class.
     */
    /**
     * Inicializa la ventana de reserva de vuelos.
     * Configura los componentes de la interfaz de usuario y establece los valores iniciales.
     * 
     * @param url La ubicación del objeto FXML.
     * @param rb  Recursos específicos de la localización para este objeto FXML.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbxOrigen.getItems().addAll(Ciudad.Guayaquil,Ciudad.Cuenca,Ciudad.Quito);
        cbxDestino.getItems().setAll(App.lDestinos);
        
//        spNumViajeros = new Spinner<>(0,100,0);
//        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,100,0,1);
//        spNumViajeros.setValueFactory(valueFactory);
//        
//        spNumViajeros.setOnMouseClicked(event -> {
//            // Manejar el clic en el Spinner (puedes implementar tu lógica aquí)
//            System.out.println("Clic en el Spinner");
//            
//        });

//        También puedes manejar el evento de cambio de valor
//        spNumViajeros.valueProperty().addListener((observable, oldValue, newValue) -> {
//            // Manejar el cambio de valor (puedes implementar tu lógica aquí)
//            System.out.println("Nuevo valor: " + newValue);
//        });
       
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        valueFactory.setValue(1);
        spNumViajeros.setValueFactory(valueFactory);
//        
//        System.out.println("jsjs");
//        final int initialValue = 1;
//        spNumViajeros = new Spinner<Integer>();
//        
//        System.out.println("luizzz");
//        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,10,initialValue);
//        spNumViajeros.setValueFactory(valueFactory);
//        System.out.println("josezzz");
//        
//        if(spNumViajeros.getValue()==5){
//            System.out.println("FUNCIONA LA WBD");
//        }
        
        buscarVuelos();
    }
    
    
    /**
     * Realiza una búsqueda de vuelos disponibles según los criterios proporcionados por el usuario.
     */
    public void buscarVuelos(){
        if(cbxOrigen.getValue()!=null && cbxDestino.getValue()!=null && dpSalida.getValue()!=null && dpRegreso.getValue()!=null){
            origen = String.valueOf(cbxOrigen.getValue());            
            destino = ((Destino) cbxDestino.getValue()).getCiudad();
            LocalDate localDate = dpSalida.getValue();
            salida = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            localDate = dpRegreso.getValue();
            regreso = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            cantViajeros = spNumViajeros.getValue();
            System.out.println("zzz");
            try {
                App.setRoot("VentanaReservaV1");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
}
