
package com.pooespol.p_poo;

/**
 *
 * @author José Miguel
 */
import com.pooespol.p_poo.modelo.Tarifa;
import com.pooespol.p_poo.modelo.Vuelo;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class VentanaReservasV4Controller implements Initializable {
    
    ArrayList<Tarifa> tarifas;
    public static Tarifa tarifaSelecciondaRegreso;
    public static double precioTotalRegreso;
    public static Vuelo vueloSeleccionado;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tarifas = Tarifa.cargarTarifas("tarifas.txt"); // Ajusta el nombre del archivo según tu estructura
        showTarifas();
    }

    @FXML
    private VBox VBoxTarifas;
    @FXML
    private ScrollPane scrollPaneTarifa;

    @FXML
    public void showTarifas() {
        String[] colores = {"#f2ab05", "#ec750d", "#ef58b2"}; 

        for (int i = 0; i < tarifas.size(); i++) {
            Tarifa tarifa = tarifas.get(i);

            VBox tVBox = new VBox();
            tVBox.setAlignment(Pos.CENTER);
            VBox.setVgrow(tVBox, Priority.ALWAYS);

            Label N1 = new Label(tarifa.getTipo() + " " + tarifa.getNombre()); // Ajusta los métodos según la estructura de tu clase Tarifa
            N1.setTextAlignment(TextAlignment.LEFT);
            N1.setTextFill(Color.valueOf(colores[i % colores.length]));
            N1.setFont(Font.font("System", FontWeight.BOLD, 12));

            tVBox.getChildren().add(N1);

            for (String caracteristica : tarifa.getlCaracteristicas()) { // Ajusta el método que devuelve las características si es necesario
                HBox caracteristicaBox = new HBox();
                caracteristicaBox.setAlignment(Pos.CENTER_LEFT);

                // Cargar imagen para cada característica
                String imagePath = "/images/" + caracteristica + ".png"; // Ajusta la ruta de las imágenes según tu estructura
                InputStream imageStream = getClass().getResourceAsStream(imagePath);
                if (imageStream != null) {
                    ImageView imageView = new ImageView(new Image(imageStream));
                    imageView.setFitHeight(32);
                    imageView.setPreserveRatio(true);
                    caracteristicaBox.getChildren().add(imageView);
                } else {
                    System.out.println("No se pudo cargar la imagen: " + imagePath);
                }

                Label cLabel = new Label(caracteristica);
                cLabel.setTextFill(Color.BLACK);

                caracteristicaBox.getChildren().add(cLabel);
                caracteristicaBox.setSpacing(4);

                tVBox.getChildren().add(caracteristicaBox);
            }

            // Calcula el costo total y muestra la etiqueta
            double porcentaje = tarifa.getPorcentaje();
            double precioVuelo = VentanaReservaV1Controller.vueloSeleccionado.getPrecio(); // Ajusta según la estructura de tu código
            double precio = (porcentaje * precioVuelo) / 100 + precioVuelo;
            Label cTotalLabel = new Label("Costo Total: $" + precio);
            cTotalLabel.setTextFill(Color.BLACK);

            VBox precioBox = new VBox();
            precioBox.setAlignment(Pos.CENTER); 
            precioBox.getChildren().add(cTotalLabel);

            String color = colores[i % colores.length];
            tVBox.setStyle("-fx-border-color: " + color);
            precioBox.setStyle("-fx-background-color: " + color);

            N1.setFont(Font.font("System", FontWeight.BOLD, 12));
            cTotalLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
            cTotalLabel.setTextAlignment(TextAlignment.CENTER);

            tVBox.getChildren().addAll(precioBox);

            VBoxTarifas.getChildren().add(tVBox);

            tVBox.setOnMouseClicked(event -> openVueloRegreso(tarifa));
        }
    }

    private void openVueloRegreso(Tarifa tarifa) {
        tarifaSelecciondaRegreso = tarifa;
        System.out.println(tarifaSelecciondaRegreso.toString());
        precioTotalRegreso = (tarifa.getPorcentaje() * VentanaReservaV1Controller.vueloSeleccionado.getPrecio()) / 100 + VentanaReservaV1Controller.vueloSeleccionado.getPrecio(); // Ajusta según la estructura de tu código
        System.out.println(precioTotalRegreso);
        try {
            App.setRoot("ReservaVuelo5");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public static void setVueloSeleccionado(Vuelo vuelo) {
        vueloSeleccionado = vuelo;
    }
}
