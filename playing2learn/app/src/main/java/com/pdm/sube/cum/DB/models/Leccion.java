package com.pdm.sube.cum.DB.models;


import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDB.class)
public class Leccion extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    String nombre;

    @Column
    int imagen;

    @Column
    int correlativo;

    @Column
    boolean estado;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Seccion seccion;

    public Leccion(int id, String nombre, int imagen, int correlativo, boolean estado, Seccion seccion) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.correlativo = correlativo;
        this.estado = estado;
        this.seccion = seccion;
    }

    public Leccion() {
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

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
}
