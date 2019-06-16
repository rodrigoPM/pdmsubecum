package com.pdm.sube.cum.DB.models;

import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDB.class)
public class DetalleMenu extends BaseModel {

    @Column
    @PrimaryKey
    int id;

    @Column
    float progreso;

    @Column
    int seccionesAprobadas;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Usuario usuario;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Menu menu;

    public DetalleMenu(int id, float progreso, int seccionesAprobadas, Usuario usuario, Menu menu) {
        this.id = id;
        this.progreso = progreso;
        this.seccionesAprobadas = seccionesAprobadas;
        this.usuario = usuario;
        this.menu = menu;
    }

    public DetalleMenu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public float getProgreso() {
        return progreso;
    }

    public void setProgreso(float progreso) {
        this.progreso = progreso;
    }

    public int getSeccionesAprobadas() {
        return seccionesAprobadas;
    }

    public void setSeccionesAprobadas(int seccionesAprobadas) {
        this.seccionesAprobadas = seccionesAprobadas;
    }
}
