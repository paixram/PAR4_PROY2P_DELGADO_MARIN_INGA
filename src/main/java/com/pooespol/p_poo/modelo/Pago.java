/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo.modelo;

/**
 * Clase que representa un pago relacionado con una reserva.
 * 
 * Un pago contiene información como el ID del pago, la reserva asociada,
 * la forma de pago, el código de programación y el total a pagar.
 *  
 * Esta clase proporciona métodos para acceder y modificar estos atributos.
 *  
 * @author José Marin
 */
public class Pago {
    
    int idPago;
    Reserva reserva;
    FormaPago FormaDePago;
    Promocion codigoProgramacion;
    double totalXPagar;
    
     /**
     * Constructor para la clase Pago.
     * 
     * @param idPago el ID del pago
     * @param reserva la reserva asociada al pago
     * @param formaDePago la forma de pago utilizada
     * @param codigoProgramacion el código de programación asociado al pago
     * @param totalXPagar el total a pagar
     */
    public Pago(int idPago, Reserva reserva, FormaPago FormaDePago, Promocion codigoProgramacion, double totalXPagar) {
        this.idPago = idPago;
        this.reserva = reserva;
        this.FormaDePago = FormaDePago;
        this.codigoProgramacion = codigoProgramacion;
        this.totalXPagar = totalXPagar;
    }

    //getters
    public int getIdPago() {
        return idPago;
    }
    public Reserva getReserva() {
        return reserva;
    }
    public FormaPago getFormaDePago() {
        return FormaDePago;
    }
    public Promocion getCodigoProgramacion() {
        return codigoProgramacion;
    }
    public double getTotalXPagar() {
        return totalXPagar;
    }

    //setters
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    public void setFormaDePago(FormaPago FormaDePago) {
        this.FormaDePago = FormaDePago;
    }
    public void setCodigoProgramacion(Promocion codigoProgramacion) {
        this.codigoProgramacion = codigoProgramacion;
    }
    public void setTotalXPagar(double totalXPagar) {
        this.totalXPagar = totalXPagar;
    }
    
}
