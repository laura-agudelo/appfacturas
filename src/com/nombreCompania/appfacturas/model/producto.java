package com.nombreCompania.appfacturas.model;

public class producto {
    private String codigo;
    private String nombre;
    private double precio;
    private static int ultimoCodigo = 0;

    // Constructor que asigna un código único
    public producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = String.format("P%04d", ++ultimoCodigo);
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo + "\t" + nombre + "\t" + precio;
    }
}

