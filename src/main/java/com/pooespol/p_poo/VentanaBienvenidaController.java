/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo;
import com.pooespol.p_poo.modelo.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author José Marin
 */
public class VentanaBienvenidaController implements Initializable{
    @FXML
    Label lblBienvenida;
    @FXML
    Label lblName;
    @FXML
    Button btnPromociones;
    @FXML
    Button btnReservar;
    @FXML
    ImageView imgBienvenida;
    @FXML
    ImageView imgFondo;
    Cliente cliente = VentanaMenuController.clienteN;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        try(FileInputStream input = new FileInputStream(App.pathImages+"bienvenida.png")){
            Image imgv = new Image(input);            
            imgBienvenida.setImage(imgv);
            //imgBienvenida.setPreserveRatio(true);
            imgBienvenida.setFitWidth(320);
            imgBienvenida.setFitHeight(550);
        }catch (IOException ex) {            
        }
//        try(FileInputStream input2 = new FileInputStream(App.pathImages+"fondo.jpg")){
//            Image imgv2 = new Image(input2);
//            imgFondo.setImage(imgv2);
//        }catch(IOException ex2){            
//        }
    
        char ultLetra = cliente.getNombre().charAt((cliente.getNombre().length())-1);
        if(ultLetra=='a'){
            lblBienvenida.setText("Bienvenida");
        }else{
            lblBienvenida.setText("Bienvenido");
        }
        lblName.setText(cliente.getNombre());
    }
    
    public void cargarVentanaPromociones(){
        try {
            App.setRoot("VentanaOfertas");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void cargarVentanaReservar(){        
        try {
            App.setRoot("VentanaReserva");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
