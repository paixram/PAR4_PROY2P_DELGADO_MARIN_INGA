package com.pooespol.p_poo;

import com.pooespol.p_poo.modelo.FormaPago;
import com.pooespol.p_poo.modelo.Promocion;
import com.pooespol.p_poo.modelo.CodigoInvalidoException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Luizzz
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class VentanaPagoAController implements Initializable {
    
    @FXML
    RadioButton tc_check;
    @FXML
    RadioButton cash_check;
    @FXML
    Button pagarbt;
    @FXML
    VBox tc_cont;
    @FXML
    VBox compraadvice;
    
    @FXML
    Label compratext;
    @FXML
    Label promociontext;
    @FXML
    Label errorcodigo;
    
    
    private static FormaPago pago_tipo;
    private static int descuento;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // set resumen de compra
        compratext = new Label(String.valueOf(ReservaVuelo5Controller.pTotal));
        
        // Manejar Eventos
        tc_check = new RadioButton();
        cash_check = new RadioButton();
        tc_check.setOnMouseClicked((event) -> setTipoPago(FormaPago.T));
        cash_check.setOnMouseClicked((event) -> setTipoPago(FormaPago.E));
        
        // Click en Pagar
        pagarbt = new Button();
        pagarbt.setOnMouseClicked((event) -> {
            
            try{
                CheckAndPay();
            }catch(CodigoInvalidoException ci) {
                errorcodigo = new Label();
                errorcodigo.setText(ci.getMessage());
            }
            
        });
      
    }
    
    public void CheckAndPay() throws CodigoInvalidoException {
        String promo_code = promociontext.getText();
        Boolean is_valid = false;
        
        if(promo_code != null) {
            // comprobar que el codigo sea valido
            ArrayList<Promocion> prls = Promocion.cargarPromociones("promociones.txt");
            
            for(Promocion p : prls) {
                if(p.getCodigo().equals(promo_code) && p.getPais().equals(VentanaReservaController.destino)) {
                    is_valid = true;
                    this.descuento = p.getDescuento();
                }
            }
        }
        
        if(!is_valid) { // Si no es valido decir
            throw new CodigoInvalidoException("El codigo no es valido");
        }else{
            Label desc = new Label("Descuento: " + this.descuento);
            
            HBox desc_box = new HBox(desc);
            
            double totalp = (double)(VentanaReservasV4Controller.vueloSeleccionado.getPrecio() - ((this.descuento / 100) * VentanaReservasV4Controller.vueloSeleccionado.getPrecio()));
            Label total_pagar = new Label("Total a pagar: " + String.valueOf(totalp));
            
            HBox tp_box = new HBox(total_pagar);
            
            compraadvice.getChildren().addAll(desc_box, tp_box);
        }
        
        //  Cuando se elige T se crea una nueva seccion
        if(pago_tipo == FormaPago.T) {
            Label info = new Label("Informacion de la tarjeta: ");
            
            
            //primero
            Label n_t = new Label("Numero de tarjeta: ");
            TextField tn_t = new TextField();
            
            HBox nt_container = new HBox(n_t, tn_t); 
            
            // segundo
            Label f_e = new Label("Fecha de expeiracion: ");
            DatePicker dp_fe = new DatePicker();
            
            HBox fe_container = new HBox(f_e, dp_fe);
            
            // tercero
            Label p = new Label("CVV: ");
            PasswordField pf_p = new PasswordField();
            
            HBox p_container = new HBox(p, pf_p);
            
            VBox tarjeta_data_container = new VBox(nt_container, fe_container, p_container);
            
            VBox info_tarjeta = new VBox(info, tarjeta_data_container);
            
            tc_cont.getChildren().addAll(info_tarjeta);
            
        }else if(pago_tipo == FormaPago.E) {
            // Mensaje de pago
            Label efectivo_advise = new Label("Estimado cliente, tienes 24 horas para acercarte a realizar el pago. De lo contrario, la reserva se anulara.");
            tc_cont.getChildren().addAll(efectivo_advise);
        }
    }
    
    public void setTipoPago(FormaPago tipoPago) {
        this.pago_tipo = tipoPago;
    }
}
