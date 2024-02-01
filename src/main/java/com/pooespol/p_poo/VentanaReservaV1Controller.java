/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo;
import com.pooespol.p_poo.modelo.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
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
        lblInfo.setText(lblInfo.getText()+" "+VentanaReservaController.origen+" "+VentanaReservaController.destino);
        cbxOrdenado.getItems().setAll("precio","duracion");
        panelDetalle.setAlignment(Pos.CENTER);
        panelDetalle.setSpacing(10);
        
        for(Vuelo v: App.lVuelos){
            if(v.getOrigen().equals(VentanaReservaController.origen) && v.getDestino().equals(VentanaReservaController.destino)){
                lVuelosSeleccionados.add(v);
            }
        }
        
        ordenar();
        
        
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
            Label lblHoraSalida = new Label(v.getHoraSalida());
            Label lblHoraLlegada = new Label(v.getHoraLlegada());
            Separator s = new Separator();
            HBox detalle = new HBox(lblHoraSalida,s,lblHoraLlegada);
            detalle.setAlignment(Pos.CENTER);
            detalle.setSpacing(10);
            Label lblPrecio = new Label(""+v.getPrecio());
            VBox contenedor = new VBox(lblDuracion,detalle,lblPrecio);
            contenedor.setAlignment(Pos.CENTER);
            contenedor.setSpacing(10);
            panelDetalle.getChildren().addAll(contenedor);
        }
    }
    
    
    
    
    
    
    
}
