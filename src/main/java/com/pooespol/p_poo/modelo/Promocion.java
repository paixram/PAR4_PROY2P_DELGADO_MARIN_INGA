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
 *
 * @author José Marin
 */
public class Promocion {
    
    double coordenadaY;
    double coordenadaX;
    String pais;
    String codigo;
    int descuento;

    /**
     * Constructor para la clase Promocion.
     * 
     * @param coordenadaY la coordenada Y de la promoción
     * @param coordenadaX la coordenada X de la promoción
     * @param codigo el código de la promoción
     * @param pais el país al que aplica la promoción
     * @param descuento el descuento asociado a la promoción
     */
    public Promocion(double coordenadaY, double coordenadaX, String codigo, String pais, int descuento) {
        this.coordenadaY = coordenadaY;
        this.coordenadaX = coordenadaX;
        this.pais = pais;
        this.codigo = codigo;
        this.descuento = descuento;
    }
    
    //getters
    public double getCoordenadaY() {
        return coordenadaY;
    }
    public double getCoordenadaX() {
        return coordenadaX;
    }
    public String getPais() {
        return pais;
    }
    public String getCodigo() {
        return codigo;
    }
    public int getDescuento() {
        return descuento;
    }
    
    //setters
    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    /**
     * Carga las promociones desde un archivo dado.
     * 
     * @param nameFile el nombre del archivo del cual cargar las promociones
     * @return una lista de promociones cargadas desde el archivo
     */
    public static ArrayList<Promocion> cargarPromociones(String nameFile){
        ArrayList<Promocion> lPromociones = new ArrayList<>();
        FileReader fR = null;
        BufferedReader bR = null;
            try{
                fR = new FileReader(App.pathFiles+nameFile);
                bR = new BufferedReader(fR);
                String line = bR.readLine();
                while(line!=null){
                    String[] datos = line.trim().split(",");
                    //crear promocion
                    Promocion p = new Promocion(Double.valueOf(datos[0]),Double.valueOf(datos[1]),datos[2],datos[3],Integer.valueOf(datos[4]));
                    lPromociones.add(p);                    
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
        return lPromociones;
    }
    
}
