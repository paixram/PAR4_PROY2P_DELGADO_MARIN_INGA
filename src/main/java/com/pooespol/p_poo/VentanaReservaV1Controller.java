/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author José Marin
 */
public class VentanaReservaV1Controller implements Initializable{
    
    /**
     * Inicializa la ventana de reserva de vuelos.
     * Se ejecuta al cargar el archivo FXML.
     * 
     * @param url La ubicación del objeto FXML.
     * @param rb  Recursos específicos de la localización para este objeto FXML.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblInfo.setText(lblInfo.getText()+" "+VentanaReservaController.origen+" "+VentanaReservaController.destino);
        cbxOrdenado.getItems().setAll("precio","duracion");
        
        
    }
    
    @FXML
    Label lblInfo;
    @FXML
    ComboBox cbxOrdenado;
    @FXML
    VBox panelDetalle;
    
    
    
    
    
    
    
}
