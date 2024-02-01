/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author José Marin
 */
public class VentanaReservaDatosPersonales implements Initializable {
    
    
    public static int cantPasajeros;
    @FXML
    VBox panelDetalle;
    
    
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
        llenarDatos();
    }
    
    @FXML
    public void llenarDatos(){
        cantPasajeros = VentanaReservaController.cantViajeros;
        for(int i = 0;i<cantPasajeros;i++){
            Label lblPas = new Label("Pasajero "+i+":");
            
            Label lblName = new Label("Nombre: ");
            TextField txtName = new TextField();
            Label lblApelli = new Label("Apellido: ");
            TextField txtApelli = new TextField();
            Label lblPassport = new Label("Pasaporte: ");
            TextField txtPassport = new TextField();
            Label lblEmail = new Label("Correo: ");
            TextField txtEmail = new TextField();
            HBox miniD1 = new HBox(lblName,txtName);
            HBox miniD2 = new HBox(lblApelli,txtApelli);
            VBox miniC1 = new VBox(miniD1,miniD2);
            miniC1.setSpacing(10);
            HBox miniD3 = new HBox(lblPassport,txtPassport);
            HBox miniD4 = new HBox(lblEmail,txtEmail);
            VBox miniC2 = new VBox(miniD3,miniD4);
            miniC2.setSpacing(10);
            HBox contenedor = new HBox(miniC1,miniC2);
            
            contenedor.setAlignment(Pos.CENTER);
            contenedor.setStyle("-fx-border-color: red");
            contenedor.setSpacing(10);
            
        }
    }
    
    @FXML
    public void continuar(){
        try {
            App.setRoot("ReservaDatosPersonales");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
