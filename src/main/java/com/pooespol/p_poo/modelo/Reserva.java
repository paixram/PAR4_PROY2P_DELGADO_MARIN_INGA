/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo.modelo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author José Marin
 */
public class Reserva implements Pagable, Serializable{
    
    String codigoReserva;
    Cliente cliente;
    Date fechaSalida;
    Date fechaIngreso;
    int numPasajero;
    Vuelo vueloIda;
    Vuelo vueloRegreso;
    Tarifa tarifaIda;
    Tarifa tarifaRegreso;

    //constructor
    public Reserva(String codigoReserva, Cliente cliente, Date fechaSalida, Date fechaIngreso, int numPasajero, Vuelo vueloIda, Vuelo vueloRegreso, Tarifa tarifaIda, Tarifa tarifaRegreso) {
        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.fechaSalida = fechaSalida;
        this.fechaIngreso = fechaIngreso;
        this.numPasajero = numPasajero;
        this.vueloIda = vueloIda;
        this.vueloRegreso = vueloRegreso;
        this.tarifaIda = tarifaIda;
        this.tarifaRegreso = tarifaRegreso;
    }

    //getters
    public String getCodigoReserva() {
        return codigoReserva;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Date getFechaSalida() {
        return fechaSalida;
    }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }
    public int getNumPasajero() {
        return numPasajero;
    }
    public Vuelo getVueloIda() {
        return vueloIda;
    }
    public Vuelo getVueloRegreso() {
        return vueloRegreso;
    }
    public Tarifa getTarifaIda() {
        return tarifaIda;
    }
    public Tarifa getTarifaRegreso() {
        return tarifaRegreso;
    }
    
    //setters
    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public void setNumPasajero(int numPasajero) {
        this.numPasajero = numPasajero;
    }
    public void setVueloIda(Vuelo vueloIda) {
        this.vueloIda = vueloIda;
    }
    public void setVueloRegreso(Vuelo vueloRegreso) {
        this.vueloRegreso = vueloRegreso;
    }
    public void setTarifaIda(Tarifa tarifaIda) {
        this.tarifaIda = tarifaIda;
    }
    public void setTarifaRegreso(Tarifa tarifaRegreso) {
        this.tarifaRegreso = tarifaRegreso;
    }
    
    public void generarTransaccion(){
        
        //codigo rellenar
        
        
    }
    
}
