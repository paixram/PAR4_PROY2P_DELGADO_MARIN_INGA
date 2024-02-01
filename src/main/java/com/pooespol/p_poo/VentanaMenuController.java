/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.p_poo;

import com.pooespol.p_poo.modelo.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author José Marin
 */
public class VentanaMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        auth();
//        btnLogIn.setOnMouseClicked((e) -> {
            
                //            try {
//                System.out.println("HOLAAAAAAA");
//                VentanaBienvenidaController vR = new VentanaBienvenidaController();
//                System.out.println("HOLAAAAAAA");
//                //((Button)(e.getSource())).getScene().getWindow().hide();
//                ((Stage)btnLogIn.getScene().getWindow()).close();
//                System.out.println("HOLAAAAAAA");
//                
//                FXMLLoader fxml = new FXMLLoader(getClass().getResource("VentanaBienvenidaController.fxml"));
//                Parent root = (Parent)fxml.load();
//                Stage stage1 = new Stage();
//                stage1.setScene(new Scene(root));
//                stage1.setTitle("Bienvenida");
//                stage1.show();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        });
    }    
    
    @FXML
    Button btnLogIn;
    @FXML
    TextField txtfUser;
    @FXML
    TextField txtfContrasenia;
    
    public static Cliente clienteN;
    
    @FXML
    public void auth(){
        //Recuperar datos ingresados en los campos
        String user = txtfUser.getText();
        String contrasenia = txtfContrasenia.getText();
        //Verificar usuario
        for(Cliente c: App.lClientes){
            if(c.getUsuario().equals(user)){
                if(c.getContrasenia().equals(contrasenia)){
                    clienteN = c;
                    try {
                        //VentanaReservasEmergency d = new VentanaReservasEmergency();
                        //d.show_reservas();
                        FXMLLoader ventana_reservas_emergente = new FXMLLoader(getClass().getResource("VentanaReservasEmergentes.fxml"));
                        Parent ventana_root = ventana_reservas_emergente.load();
                        
                        
                        Scene scene_reservas = new Scene(ventana_root, 250, 400);
                        Stage v_reservas = new Stage();
                        v_reservas.setTitle("Reservas");
                        v_reservas.setScene(scene_reservas);
                        
                        v_reservas.show();
                        App.setRoot("VentanaBienvenida");  
                        
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }else{
                    System.out.println("ERROR AL INGRESAR CREDENCIALES");
                }
            }
        }        
    }
    
    
}
