/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo;

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
    Label lblName;
    @FXML
    Button btnPromociones;
    @FXML
    Button btnReservar;
    @FXML
    ImageView imgBienvenida;
    @FXML
    ImageView imgFondo;
    
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
        
        lblName.setText("G6");
    }
    
    public void cargarVentanaPromociones(){
        
    }
    
    public void cargarVentanaReservar(){
        
    }
}
