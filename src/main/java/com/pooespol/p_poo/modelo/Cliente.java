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
public class Cliente {
    
    String cedula;
    String nombre;
    String apellido;
    String usuario;
    String contrasenia;
    
    /**
     * Constructor para la clase Cliente.
     * 
     * @param cedula la cédula del cliente
     * @param nombre el nombre del cliente
     * @param apellido el apellido del cliente
     * @param usuario el nombre de usuario del cliente
     * @param contrasenia la contraseña del cliente
     */
    public Cliente(String cedula, String nombre, String apellido, String usuario, String contrasenia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    
    //getters
    public String getCedula() {
        return cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    
    //setters
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }    

    //toString
    public String toString(){
        return this.nombre+" "+this.apellido;
    }
    
    /**
     * Carga clientes desde un archivo dado.
     * 
     * @param nameFile el nombre del archivo del cual cargar los clientes
     * @return una lista de clientes cargados desde el archivo
     */
    public static ArrayList<Cliente> cargarClientes(String nameFile){
        ArrayList<Cliente> lClientes = new ArrayList<>();
        FileReader fR = null;
        BufferedReader bR = null;
        try{
            fR = new FileReader(App.pathFiles+nameFile);
            bR = new BufferedReader(fR);
            String line = bR.readLine();
            while(line!=null){
                String[] datos = line.trim().split(",");
                //crear cliente
                Cliente c = new Cliente(datos[0],datos[1],datos[2],datos[3],datos[4]);
                lClientes.add(c);
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
        return lClientes;
    }
    
}
