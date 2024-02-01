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
     * Initializes the controller class.
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
