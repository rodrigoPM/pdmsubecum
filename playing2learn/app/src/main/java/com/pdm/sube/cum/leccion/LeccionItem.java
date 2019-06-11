package com.pdm.sube.cum.leccion;

public class LeccionItem {
    public int id;
    public String nombre;
    public int imagen;

    public LeccionItem(){}

    public LeccionItem(int id, String nombre, int imagen) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
