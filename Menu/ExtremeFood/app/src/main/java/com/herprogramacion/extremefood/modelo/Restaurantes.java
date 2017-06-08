package com.herprogramacion.extremefood.modelo;

/**
 * Created by marit on 02/06/2017.
 */
public class Restaurantes {
    private String nombre;
    private String direccion;
    private int idDrawable;

    public Restaurantes(String nombre, String direccion, int idDrawable){
        this.nombre= nombre;
        this.direccion=direccion;
        this.idDrawable = idDrawable;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getIdDrawable(){
        return idDrawable;
    }
}
