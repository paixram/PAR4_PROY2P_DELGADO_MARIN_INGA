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
public class Tarifa {
    
    String nombre;
    String tipo;
    ArrayList<String> lCaracteristicas;
    
    //constructor
    public Tarifa(String nombre, String tipo, ArrayList<String> lCaracteristicas){
        this.nombre = nombre;
        this.tipo = tipo;
        this.lCaracteristicas = lCaracteristicas;
    }

    //getters
    public String getNombre() {
        return nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public ArrayList<String> getlCaracteristicas() {
        return lCaracteristicas;
    }
    
    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setlCaracteristicas(ArrayList<String> lCaracteristicas) {
        this.lCaracteristicas = lCaracteristicas;
    }
    
    //
    public static ArrayList<Tarifa> cargarTarifas(String nameFile){
        ArrayList<Tarifa> lTarifas = new ArrayList<>();
        FileReader fR = null;
        BufferedReader bR = null;
        try{
            fR = new FileReader(App.pathFiles+nameFile);
            bR = new BufferedReader(fR);
            String line = bR.readLine();
            ArrayList<String> lCaracteristicas = new ArrayList<>();
            while(line!=null){
                String[] datos = line.trim().split(",");
                String[] caracteristicas = datos[2].split("-");
                for (int i=0;i<caracteristicas.length;i++) {
                    String nC = caracteristicas[i];
                    lCaracteristicas.add(nC);
                }
                Tarifa nT = new Tarifa(datos[0],datos[1],lCaracteristicas);
                lTarifas.add(nT);
                line = bR.readLine();
            }
        }catch(FileNotFoundException e1){
            System.out.println(e1.getMessage());
        }catch(IOException e2){
            System.out.println(e2.getMessage());
        }finally{
            try{
                bR.close();
                fR.close();
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        return lTarifas;
    }
    
}
