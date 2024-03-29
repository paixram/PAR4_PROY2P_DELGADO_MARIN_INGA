/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo.modelo;

import com.pooespol.p_poo.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que representa un vuelo.
 * 
 * Un vuelo contiene información como el número de vuelo, la ciudad de origen y destino,
 * la duración, las horas de salida y llegada, el código y el precio.
 * 
 * Esta clase implementa la interfaz Comparable para permitir la comparación entre vuelos.
 * @author José Marin
 */

public class Vuelo implements Comparable<Vuelo>{
    
    String numVuelo;
    Ciudad origen;
    Destino destino;
    int duracion;
    String horaSalida;
    String horaLlegada;
    String codigo;
    double precio;

    /**
     * Constructor para la clase Vuelo.
     *
     * @param numVuelo el número de vuelo
     * @param origen la ciudad de origen
     * @param destino el destino del vuelo
     * @param duracion la duración del vuelo
     * @param horaSalida la hora de salida
     * @param horaLlegada la hora de llegada
     * @param codigo el código del vuelo
     * @param precio el precio del vuelo
     */
    public Vuelo(String numVuelo, Ciudad origen, Destino destino, int duracion, String horaSalida, String horaLlegada, String codigo, double precio) {
        this.numVuelo = numVuelo;
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.codigo = codigo;
        this.precio = precio;
    }
    
    //getters
    public String getNumVuelo() {
        return numVuelo;
    }
    public Ciudad getOrigen() {
        return origen;
    }
    public Destino getDestino() {
        return destino;
    }
    public int getDuracion() {
        return duracion;
    }
    public String getHoraSalida() {
        return horaSalida;
    }
    public String getHoraLlegada() {
        return horaLlegada;
    }
    public String getCodigo() {
        return codigo;
    }
    public double getPrecio() {
        return precio;
    }

    //setters
    public void setNumVuelo(String numVuelo) {
        this.numVuelo = numVuelo;
    }
    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }
    public void setDestino(Destino destino) {
        this.destino = destino;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Carga los vuelos desde un archivo de texto.
     *
     * @param nameFile el nombre del archivo de texto
     * @return una lista de vuelos cargados desde el archivo
     */
    public static ArrayList<Vuelo> cargarVuelos(String nameFile){
        ArrayList<Vuelo> lVuelos = new ArrayList<>();
        FileReader fR = null;
        BufferedReader bR = null;
        try{
            fR = new FileReader(App.pathFiles+nameFile);
            bR = new BufferedReader(fR);
            String line = bR.readLine();
            while(line!=null){                
                String[] datos = line.trim().split(",");
                //crear destino
                Destino dV = null;
                ArrayList<Destino> lDestinos = Destino.cargarDestinos("destinos.txt");
                for(Destino d: lDestinos){                    
                    
                    if(d.getCiudad().equals(datos[2])){                            
                        dV = new Destino(datos[2],d.getPais());
                    }
                }
                //crear vuelo
                Vuelo v = new Vuelo(datos[0],Ciudad.valueOf(datos[1]),dV,Integer.valueOf(datos[3]),datos[4],datos[5],datos[6],Double.valueOf(datos[7]));
                lVuelos.add(v);
                line = bR.readLine();
            }
        }catch(FileNotFoundException e1){
            System.out.println("Archivo no fue encontrado");
        }catch(IOException e2){
            System.out.println("Error al abrir el archivo");
        }finally{
            try{
                bR.close();
                fR.close();
            }catch(IOException ex){
                System.out.println("Error al cerrar el archivo");
            }
        }
        return lVuelos;
    }
    /**
     * Compara este vuelo con otro vuelo.
     *
     * @param v el vuelo a comparar
     * @return un valor negativo, cero o un valor positivo según este vuelo
     *         sea menor, igual o mayor que el vuelo proporcionado
     */
    @Override
    public int compareTo(Vuelo v){
        // variable para separar criterio de orden 
        int i = 0;        
        if(VentanaReservaV1Controller.opcionOrder==1){
            i = 1;
        }        
        int resultado = 0;
        // verificacion
        if(i==0){
            if(v.getPrecio()>this.precio){
                resultado = 1;
            }else if(v.getPrecio()<this.precio){
                resultado = -1;
            }
        }else{
            if(v.getDuracion()>this.duracion){
                resultado = 1;
            }else if(v.getDuracion()<this.duracion){
                resultado = -1;
            }
        }
        return resultado;
    }
   
    
}
