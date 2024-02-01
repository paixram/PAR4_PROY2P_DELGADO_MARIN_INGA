/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pooespol.p_poo;

/**
 * FXML Controller class
 *
 * @author Luizzz
 */

import com.pooespol.p_poo.modelo.Tarifa;
import com.pooespol.p_poo.modelo.Vuelo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class ReservaVuelo5Controller implements Initializable {
    public static Tarifa t;
    public static Vuelo v; 

    @FXML
    VBox VB;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showinfoIda();
        showinfoRegreso();
        showTotal();
        continuee();
    }    

    public void showinfoIda(){
        VBox infoBox = new VBox();
        Label fec = new Label(VentanaReservaController.salida.toString());
        fec.setFont(Font.font("System", FontWeight.BOLD, 12));
        Label place = new Label(VentanaReservaController.origen + " a " +VentanaReservaController.destino);
        place.setFont(Font.font("System", FontWeight.BOLD, 12));
        infoBox.getChildren().addAll(fec,place);
        VB.getChildren().add(infoBox);
        
        HBox horasBox = new HBox();
        Label sLabel = new Label(VentanaReservaV1Controller.vueloSeleccionado.getHoraSalida());
        Label llLabel = new Label(VentanaReservaV1Controller.vueloSeleccionado.getHoraLlegada());
        Separator separator = new Separator();
        separator.setPrefWidth(200);
        separator.setPrefHeight(10);
        horasBox.getChildren().addAll(sLabel, separator, llLabel); // Utilizamos el Separator como separador
        horasBox.setAlignment(Pos.CENTER);
        
        
    }

    public void showinfoRegreso(){
        VBox infoBox = new VBox();
        Label fecha = new Label(VentanaReservaController.regreso.toString());
        fecha.setFont(Font.font("System", FontWeight.BOLD, 12));
        Label lugar = new Label(VentanaReservaController.destino + " a " +VentanaReservaController.origen);
        lugar.setFont(Font.font("System", FontWeight.BOLD, 12));
        infoBox.getChildren().addAll(fecha,lugar);
        VB.getChildren().add(infoBox);
        
        HBox horasBox = new HBox();
        Label salidaLabel = new Label(VentanaReservaV1Controller.vueloSeleccionado.getHoraSalida());
        Label llegadaLabel = new Label(VentanaReservaV1Controller.vueloSeleccionado.getHoraLlegada());
        Separator separator = new Separator();
        separator.setPrefWidth(200);
        separator.setPrefHeight(10);
        horasBox.getChildren().addAll(salidaLabel, separator, llegadaLabel); // Utilizamos el Separator como separador
        horasBox.setAlignment(Pos.CENTER);
        
       
    }

    public void showTotal(){
        VBox precioBox = new VBox();
        Label totalLabel = new Label("Precio total: "+ (ReservaVueloTarifaController.precioTotal+ VentanaReservasV4Controller.precioTotalRegreso));
        totalLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
        precioBox.getChildren().addAll(totalLabel);
        precioBox.setAlignment(Pos.CENTER_RIGHT);
        VB.getChildren().add(precioBox);
    }

    private void continuee(){
        VBox continuarBOX = new VBox();
        Button continuarBoton = new Button("Continuar");
        continuarBoton.setStyle("-fx-background-color: red; -fx-background-radius: 5;-fx-border-color: white;-fx-border-radius: 5;-fx-border-width: 2;");
        continuarBoton.setTextFill(Color.WHITE);
        continuarBOX.getChildren().addAll(continuarBoton);
        continuarBOX.setAlignment(Pos.CENTER);
        VB.getChildren().add(continuarBOX);

        continuarBoton.setOnAction(event -> {
                openVentanaDatos();
            });
    }

    private void openVentanaDetalles(Tarifa ta, Vuelo vu) {
        t=ta;
        v=vu;
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Detalles.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage detallesStage = new Stage();
        detallesStage.setScene(scene);
        detallesStage.show();
        
        } catch (IOException e) {
        e.printStackTrace();
        }
    }

    private void openVentanaDatos() {
        try {
            
        Stage stage = (Stage) VB.getScene().getWindow();
        stage.close();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Datos.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage detallesStage = new Stage();
        detallesStage.setScene(scene);
        detallesStage.show();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

