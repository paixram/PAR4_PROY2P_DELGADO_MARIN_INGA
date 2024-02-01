/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo;

/**
 *
 * @author José Miguel
 */
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import com.pooespol.p_poo.VentanaReservaV1Controller;
import com.pooespol.p_poo.modelo.Vuelo;
import javafx.event.EventHandler;
import javafx.scene.control.Separator;
import javafx.scene.input.MouseEvent;

public class VentanaReservaV3Controller implements Initializable {

//    ArrayList<Vuelo> vuelosConsultar;
//    
//    public static Vuelo Ida;
//    @FXML
//    private ComboBox<String> cbxOrdenado;
//    @FXML
//    private ScrollPane panelDetalle;
//    @FXML
//    private Label lblInfo;
//    @FXML
//    private VBox VBoxDinamico;
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        cbxOrdenado.getItems().addAll("Precio", "Duración");
//        vuelosConsultar = Vuelo.cargarVuelos("vuelos.txt");
//        buscarVueloRegreso(VentanaReservaController.origen, VentanaReservaController.destino);
//        cbxOrdenado.setOnAction(event -> orderVuelos());
//    }
//
//    @FXML
//    public void buscarVueloRegreso(String origen, String destino) {
//        lblInfo.setText("Selecciona tu vuelo " + destino + " - " + origen);
//        VBoxDinamico.getChildren().clear();
//         for (Vuelo vuelo : vuelosConsultar) {
//        if (vuelo.getOrigen().equals(destino) && vuelo.getDestino().equals(origen)) {
//            VBox vueloVBox = new VBox();
//            VBox.setVgrow(vueloVBox, Priority.ALWAYS);
//            
//            Label duracionLabel = new Label("Duración: " + vuelo.getDuracion() + " horas");
//            Label precioLabel = new Label("Precio: $" + vuelo.getPrecio());
//            
//            HBox horasBox = new HBox();
//            Label salidaLabel = new Label(vuelo.getHoraSalida());
//            Label llegadaLabel = new Label(vuelo.getHoraLlegada());
//            
//            Separator separator = new Separator(); // Creación del separador
//            separator.setStyle("-fx-background-color: red"); // Estilo del separador
//            separator.setPrefWidth(200); // Ancho del separador
//            separator.setPrefHeight(10); // Altura del separador
//            
//            horasBox.getChildren().addAll(salidaLabel, separator, llegadaLabel);
//            horasBox.setAlignment(Pos.CENTER);
//            
//            duracionLabel.setTextAlignment(TextAlignment.CENTER);
//            precioLabel.setTextAlignment(TextAlignment.CENTER);
//            salidaLabel.setTextAlignment(TextAlignment.CENTER);
//            llegadaLabel.setTextAlignment(TextAlignment.CENTER);
//            
//            duracionLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
//            precioLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
//            
//            vueloVBox.setAlignment(Pos.CENTER);
//            vueloVBox.setStyle("-fx-border-color: grey; -fx-border-width: 0.1px; -fx-padding: 10px; -fx-margin: 10px;");
//            vueloVBox.getChildren().addAll(duracionLabel, horasBox, precioLabel);
//            vueloVBox.prefWidthProperty().bind(panelDetalle.widthProperty());
//            
//            VBoxDinamico.getChildren().add(vueloVBox);
//            
//            vueloVBox.setOnMouseClicked(event -> openVentanaTarifaRegreso(vuelo));
//        }
//    }
//}
//
//    
//    private void openVentanaTarifaRegreso(Vuelo vuelo) {
//        Ida = vuelo;
//        System.out.println(Ida.toString());
//        try {
//            Stage stage = (Stage) panelDetalle.getScene().getWindow();
//            stage.close();
//            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ReservaVuelo3.fxml"));
//            Parent root = fxmlLoader.load();
//            Stage vt = new Stage();
//            vt.setScene(new Scene(root));
//            vt.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    @FXML
//    private void orderVuelos() {
//        String seleccion = cbxOrdenado.getValue();
//        if (seleccion != null) {
//            switch (seleccion) {
//                case "precio":
//                    Collections.sort(vuelosConsultar, Comparator.comparingDouble(Vuelo::getPrecio));
//                    break;
//                case "duración":
//                    Collections.sort(vuelosConsultar, Comparator.comparingInt(Vuelo::getDuracion));
//                    break;
//            }
//            buscarVueloRegreso(VentanaReservaController.origen, VentanaReservaController.destino);
//        }
//    }
    
    
    @FXML
    Label lblInfo;
    @FXML
    ComboBox<String> cbxOrdenado;
    @FXML
    VBox panelDetalle;
    public static int opcionOrder;
    public static ArrayList<Vuelo> lVuelosSeleccionados = new ArrayList<>();
    public static Vuelo vueloSeleccionado;
    /**
     * Inicializa la ventana de reserva de vuelos.
     * Se ejecuta al cargar el archivo FXML.
     * 
     * @param url La ubicación del objeto FXML.
     * @param rb  Recursos específicos de la localización para este objeto FXML.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (VentanaReservaController.origen != null && VentanaReservaController.destino != null) {
            lblInfo.setText(lblInfo.getText() + " " + VentanaReservaController.destino + " - " + VentanaReservaController.origen);
        }
        cbxOrdenado.getItems().setAll("precio", "duracion");
        panelDetalle.setAlignment(Pos.CENTER);
        
        for (Vuelo v : App.lVuelos) {
            if (v.getOrigen() != null && v.getDestino() != null 
                    && String.valueOf(v.getOrigen()).equals(VentanaReservaController.destino) 
                    && v.getDestino().getCiudad().equals(VentanaReservaController.origen)) {
                lVuelosSeleccionados.add(v);
            }
        }
        
        if (!lVuelosSeleccionados.isEmpty()) {
            order();
        }
        
        panelDetalle.setSpacing(10);
    }
    
    @FXML
    public void order(){
        String orden = cbxOrdenado.getValue();
        if (orden == null) {
            return;
        }
        
        if (orden.equals("precio")) {
            Collections.sort(lVuelosSeleccionados, (v1, v2) -> Double.compare(v1.getPrecio(), v2.getPrecio()));
        } else if (orden.equals("duracion")) {
            Collections.sort(lVuelosSeleccionados, (v1, v2) -> Integer.compare(v1.getDuracion(), v2.getDuracion()));
        }
        
        panelDetalle.getChildren().clear();
        
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
                    vueloSeleccionado = v;
                    try {
                        App.setRoot("ReservaVuelo4");   
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            
            panelDetalle.getChildren().addAll(contenedor);
            
        }
    }
    
    
    
    
    
    
}
