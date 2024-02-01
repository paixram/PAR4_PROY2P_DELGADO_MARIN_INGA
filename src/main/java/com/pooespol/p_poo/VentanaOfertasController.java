/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.pooespol.p_poo.modelo.Promocion;
import javafx.geometry.Insets;


public class VentanaOfertasController implements Initializable {

    ArrayList<Promocion> promo;
    @FXML
    private ImageView imgView;
    @FXML
    private AnchorPane ancho;
    @FXML
    private AnchorPane anchoImg;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización de la clase, si es necesaria
        InputStream image = getClass().getResourceAsStream("/images/mapa.png");
        imgView.setImage(new Image(image));
        find();
    }

   
    public void find() {

        promo=Promocion.cargarPromociones("promociones.txt");
        Thread sleep = new Thread(new Runnable(){
            @Override
            public void run(){
               showImages(promo,anchoImg);
           }});
        sleep.start();
    }

     
    public void showImages(ArrayList<Promocion> promociones, AnchorPane contenedor) {
        for (Promocion promo : promociones) {
            InputStream img2 = getClass().getResourceAsStream("/images/ubicacion.png");
            ImageView imgv = new ImageView(new Image(img2));
            Random rd = new Random();
            int numero = rd.nextInt(10) + 1;
            try {
               Thread.sleep(numero*1000);
           } catch (InterruptedException ex) {
               ex.printStackTrace();
           }
            
            
            imgv.setOnMouseClicked(event -> {
                Stage info = new Stage();
                VBox v = new VBox();
                v.setMaxSize(300, 250);
                v.setMinSize(300, 250);
                v.setStyle("-fx-background-color:#661d1d");
                HBox cprom = new HBox();
                Label promos= new Label("\n\nDetalles de la Promoción");
                promos.setStyle("-fx-font-family:'System';-fx-text-fill: white; -fx-font-weight: bold");
                cprom.getChildren().addAll(promos);

                HBox dat = new HBox();
                Label datos = new Label(promo.getPais()+"\n"+"\nCódigo: " + promo.getCodigo() + "\n\nDescuento: " + promo.getDescuento() + "%\n\n\n");
                datos.setStyle("-fx-text-fill: white; -fx-font-weight: bold");
                dat.getChildren().addAll(datos);

                HBox ct = new HBox();
                Label time = new Label();
                time.setStyle("-fx-text-fill: white;-fx-text-fill: white; -fx-font-weight: bold;");
                time.setText("Cerrando en 5 segundos...");
                Button cerrar = new Button("Cerrar");
                HBox.setMargin(cerrar, new Insets(0, 0, 0, 50));
                cerrar.setOnAction(event2 -> {
                    info.close();
                });
                ct.getChildren().addAll(time, cerrar);

                v.getChildren().addAll(cprom, dat, ct);
                Scene escena = new Scene(v);
                info.setScene(escena);
                info.setTitle("Detalle de la Promoción");
                info.show();
                c(time, info);
            });

            Platform.runLater(() -> {
                contenedor.getChildren().add(imgv);
                imgv.setLayoutX(promo.getCoordenadaY()-10);
                imgv.setLayoutY((promo.getCoordenadaX())-30);
                imgv.setFitHeight(30);
                imgv.setFitWidth(30);
            });
        }
    }

   
    public static void cerrar(Label label, Stage escenario) {
        for (int i = 5; i != 0; i--) {
            String status = "Cerrando en " + i + " segundos...";
            Platform.runLater(() -> label.setText(status));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        Platform.runLater(escenario::close);
    }
    public static void c(Label label, Stage escenario) {
        Thread slep = new Thread(() -> cerrar(label, escenario));
        slep.start();
    }

    
    
}
