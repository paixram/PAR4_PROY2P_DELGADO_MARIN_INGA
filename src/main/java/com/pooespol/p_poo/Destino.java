/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pooespol.p_poo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author José Marin
 */
public class Destino {
    
    String ciudad;
    String pais;
    
    public Destino(String ciudad, String pais){
        this.ciudad = ciudad;
        this.pais = pais;
    }
    
    //getters
    public String getCiudad() {
        return ciudad;
    }
    public String getPais() {
        return pais;
    }
    //setters
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    //toString
    public String toString(){
        return this.ciudad+" "+this.pais;
    }
    
    //cargarDestino
    public static ArrayList<Destino> cargarDestinos(String nameFile){
        ArrayList<Destino> lDestinos = new ArrayList<>();
        FileReader fR = null;
        BufferedReader bR = null;
        try{
            fR = new FileReader(nameFile);
            bR = new BufferedReader(fR);
            String line = bR.readLine();
            while(line!=null){
                String[] datos = line.trim().split(",");
                //crear destino
                Destino d = new Destino(datos[0],datos[1]);
                lDestinos.add(d);
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
        return lDestinos;
    }
    
}
