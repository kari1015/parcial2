package com.example.parcial2.clases;

public class Libro {
    private String imagen;
    private String nombre;
    private String escritor;

    public Libro(String imagen, String nombre, String escritor) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.escritor = escritor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }
}
