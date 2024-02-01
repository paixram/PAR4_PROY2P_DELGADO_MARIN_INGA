/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo;
import com.pooespol.p_poo.modelo.*;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author José Marin
 */
public class VentanaReservaV1Controller implements Initializable{
    
    @FXML
    Label lblInfo;
    @FXML
    ComboBox cbxOrdenado;
    @FXML
    VBox panelDetalle;
    public static int opcionOrder;
    public static ArrayList<Vuelo> lVuelosSeleccionados = new ArrayList<>();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblInfo.setText(lblInfo.getText()+" "+VentanaReservaController.origen+" - "+VentanaReservaController.destino);
        cbxOrdenado.getItems().setAll("precio","duracion");
        panelDetalle.setAlignment(Pos.CENTER);
        
        for(Vuelo v: App.lVuelos){
            //System.out.println(v.getOrigen()+" - "+v.getDestino());
            if(String.valueOf(v.getOrigen()).equals(VentanaReservaController.origen) && (v.getDestino().getCiudad()).equals(VentanaReservaController.destino)){
                lVuelosSeleccionados.add(v);
            }
        }
        
        
        
        panelDetalle.setSpacing(10);
    }
    
    @FXML
    public void ordenar(){
        if(cbxOrdenado.getValue().equals("precio")){
            opcionOrder = 0;     
        }else{                 
            opcionOrder = 1;
        }
        Collections.sort(lVuelosSeleccionados);
        
        for(Vuelo v: lVuelosSeleccionados){
            Label lblDuracion = new Label("Duración "+v.getDuracion()+" horas");
            lblDuracion.setStyle("-fx-font-weight: bold;");
            Label lblHoraSalida = new Label(v.getHoraSalida());
            Label lblHoraLlegada = new Label(v.getHoraLlegada());
            Separator s = new Separator();
            s.setStyle("-fx-background-color: red");
            s.setPrefWidth(200);
            s.setPrefHeight(10);
            HBox detalle = new HBox(lblHoraSalida,s,lblHoraLlegada);
            detalle.setAlignment(Pos.CENTER);
            detalle.setSpacing(10);
            Label lblPrecio = new Label(""+v.getPrecio());
            lblPrecio.setStyle("-fx-font-weight: bold;");
            VBox contenedor = new VBox(lblDuracion,detalle,lblPrecio);
            contenedor.setStyle("-fx-border-color: #CCCCCC;");
            contenedor.setAlignment(Pos.CENTER);
            contenedor.setSpacing(10);
            
            contenedor.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent e){
                    
                    try {
                        App.setRoot("ReservaVuelo2");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            
            panelDetalle.getChildren().addAll(contenedor);
            
        }
    }
    
    
    
    
    
    
    
}
