package com.pdm.sube.cum.DB.models;


import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDB.class)
public class Seccion extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    String nombre;

    @Column
    int imagen;

    @Column
    int nivel;

    @Column
    int correlativo;

    @Column
    int total_lecciones;

    public Seccion(int id, String nombre, int imagen, int nivel, int correlativo, int total_lecciones) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.nivel = nivel;
        this.correlativo = correlativo;
        this.total_lecciones = total_lecciones;
    }

    public Seccion() {
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public int getTotal_lecciones() {
        return total_lecciones;
    }

    public void setTotal_lecciones(int total_lecciones) {
        this.total_lecciones = total_lecciones;
    }
}
