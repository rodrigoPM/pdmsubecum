package com.pdm.sube.cum.DB.models;

import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDB.class)
public class Seccion extends BaseModel {
    @Column
    @PrimaryKey
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
    boolean estado;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Menu menu;

    public Seccion(int id, String nombre, int imagen, int nivel, int correlativo, boolean estado, Menu menu) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.nivel = nivel;
        this.correlativo = correlativo;
        this.estado = estado;
        this.menu = menu;
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
