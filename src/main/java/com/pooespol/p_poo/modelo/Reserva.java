/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo.modelo;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Clase que representa una reserva de vuelo.
 * 
 * Una reserva contiene información como el código de reserva, el cliente asociado,
 * las fechas de salida e ingreso, el número de pasajeros, los vuelos de ida y regreso,
 * así como las tarifas asociadas.
 * 
 * Esta clase implementa la interfaz Pagable y Serializable.
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

      /**
     * Constructor para la clase Reserva.
     * 
     * @param codigoReserva el código de la reserva
     * @param cliente el cliente asociado a la reserva
     * @param fechaSalida la fecha de salida
     * @param fechaIngreso la fecha de ingreso
     * @param numPasajero el número de pasajeros
     * @param vueloIda el vuelo de ida
     * @param vueloRegreso el vuelo de regreso
     * @param tarifaIda la tarifa de ida
     * @param tarifaRegreso la tarifa de regreso
     */
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
    
    //pasar a controller
    
    public void guardarReserva(Reserva r){
        FileWriter fW = null;
        BufferedWriter bW = null;
        try{
            fW = new FileWriter("reservas.txt");
            bW = new BufferedWriter(fW);
            
            
            bW.write(r.getCodigoReserva()+","+r.getCliente()+","+r.getFechaSalida()+","+
                    r.getFechaIngreso()+","+r.getNumPasajero()+","+r.getVueloIda()+","+
                    r.getVueloRegreso()+","+r.getTarifaIda()+","+r.getTarifaRegreso());
            
        }catch(IOException e){
            
        }finally{
            try{
                bW.close();
                fW.close();
            }catch(IOException ex){                
            }
        }
                
    }
    
    @Override
    public void generarTransaccion(){        
    }
    
    public void generarTransaccion(Reserva r) {        
        //codigo rellenar
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(r.getCodigoReserva());
            oos = new ObjectOutputStream(fos);
            oos.writeObject(r);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
    }
    
}
