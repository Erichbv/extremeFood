package com.herprogramacion.extremefood.modelo;

import com.herprogramacion.extremefood.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de datos estático para alimentar la aplicación
 */
public class Comida {
    private float precio;
    private String nombre;
    private int idDrawable;

    public Comida(float precio, String nombre, int idDrawable) {
        this.precio = precio;
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public static final List<Comida> COMIDAS_POPULARES = new ArrayList<Comida>();
    public static final List<Comida> MARINOS = new ArrayList<>();
    public static final List<Comida> PARRILLAS = new ArrayList<>();
    public static final List<Comida> CRIOLLOS = new ArrayList<>();
    public static final List<Restaurantes> RESTAURANTES = new ArrayList<Restaurantes>();

    static {
        RESTAURANTES.add(new Restaurantes("Begui","Av. Antunez de Mayolo 3311", R.drawable.begui));
        RESTAURANTES.add(new Restaurantes("Pikalo","Av. Antunez de Mayolo 3312", R.drawable.pikalo));
        RESTAURANTES.add(new Restaurantes("Rustica","Av. Antunez de Mayolo 3315", R.drawable.rustica));

       /* COMIDAS_POPULARES.add(new Comida(0, "Brochetas", R.drawable.begui));
        COMIDAS_POPULARES.add(new Comida(0, "Rosca Herbárea", R.drawable.olimpico));
        COMIDAS_POPULARES.add(new Comida(0, "Sushi Extremo", R.drawable.pikalo));
        COMIDAS_POPULARES.add(new Comida(0, "Sandwich Deli", R.drawable.peppers));
        COMIDAS_POPULARES.add(new Comida(0, "Lomo De Cerdo Austral", R.drawable.rustica));*/

        MARINOS.add(new Comida(5, "Ceviche", R.drawable.ceviche));
        MARINOS.add(new Comida(3.2f, "Arroz con Mariscos", R.drawable.arrozmariscos));
        MARINOS.add(new Comida(12f, "Sopa de Cangrejo", R.drawable.sopadecangrejo));
        MARINOS.add(new Comida(9, "Sudado", R.drawable.sudado));
        MARINOS.add(new Comida(34f, "Makis", R.drawable.makis));

        PARRILLAS.add(new Comida(15, "Brochetas", R.drawable.brochetas));
        PARRILLAS.add(new Comida(16, "Pollo a la brasa", R.drawable.pollo));
        PARRILLAS.add(new Comida(25, "Parrilla", R.drawable.parrilla));
        PARRILLAS.add(new Comida(24, "Pollo al Mani", R.drawable.pollomani));
        PARRILLAS.add(new Comida(30, "Pollo a la Naranja", R.drawable.pollonaranja));

        CRIOLLOS.add(new Comida(7, "Arroz con Pollo", R.drawable.arrozconpollo));
        CRIOLLOS.add(new Comida(10, "Lomo", R.drawable.lomo));
        CRIOLLOS.add(new Comida(10, "Aji de Gallina", R.drawable.ajidegallina));
        CRIOLLOS.add(new Comida(11, "Chaufa", R.drawable.chaufa));
        CRIOLLOS.add(new Comida(8, "Causa Rellena", R.drawable.causa));

    }

    public float getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }
}
