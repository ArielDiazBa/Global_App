package com.example.aplicacion_paises;

public class Lugar {
    private int id;
    private String Nombre;
    private double Longitud;
    private double Latitud;
    private int Habitantes;

    public Lugar(){

    }

    public Lugar(int id, String nombre, double longitud, double latitud, int habitantes) {
        this.id = id;
        Nombre = nombre;
        Longitud = longitud;
        Latitud = latitud;
        Habitantes = habitantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getLongitud() {
        return Longitud;
    }

    public void setLongitud(double longitud) {
        Longitud = longitud;
    }

    public double getLatitud() {
        return Latitud;
    }

    public void setLatitud(double latitud) {
        Latitud = latitud;
    }

    public int getHabitantes() {
        return Habitantes;
    }

    public void setHabitantes(int habitantes) {
        Habitantes = habitantes;
    }
}
