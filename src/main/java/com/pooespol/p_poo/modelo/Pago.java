/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo.modelo;

/**
 *
 * @author José Marin
 */
public class Pago {
    
    int idPago;
    Reserva reserva;
    FormaPago FormaDePago;
    Promocion codigoProgramacion;
    double totalXPagar;
    
    //constructor
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
