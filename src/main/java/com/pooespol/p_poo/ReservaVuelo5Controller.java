/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.p_poo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Luizzz
 */
public class ReservaVuelo5Controller implements Initializable {
    
    @FXML
    VBox biboz;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarVentana();
    }    
    
    public void cargarVentana() {
        Label la = new Label("Vuelho de yda: " + VentanaReservaController.salida + ":");
        Label lo = new Label(VentanaReservaController.origen + " a " + VentanaReservaController.destino);
        
        /// BOX LEIBOL
        VBox bibox_deida = new VBox();
        //Label hora = new Label("Duracion: " + VentanaReservaController.salida.toGMTString());
        
        
        Label la2 = new Label("Vuelho de regrezho: " + VentanaReservaController.regreso + ":");
        Label lo2 = new Label(VentanaReservaController.destino + " a " + VentanaReservaController.origen);
        
        biboz.getChildren().addAll(la, lo, la2, lo2);
    }
    
}
