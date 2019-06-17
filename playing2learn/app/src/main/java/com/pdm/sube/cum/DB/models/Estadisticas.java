package com.pdm.sube.cum.DB.models;

import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDB.class)
public class Estadisticas extends BaseModel {
    @Column
    @PrimaryKey
    int id_estadisticas;

    @Column
    @PrimaryKey
    int mes;

    @Column
    int numero_veces;

    @Column
    @ForeignKey
    Seccion seccion;


    @Column
    @PrimaryKey
    @ForeignKey
    Usuario usuario;

    public Estadisticas() {
    }

    public Estadisticas(int id_estadisticas, int mes, int numero_veces, Seccion seccion, Usuario usuario) {
        this.id_estadisticas = id_estadisticas;
        this.mes = mes;
        this.numero_veces = numero_veces;
        this.seccion = seccion;
        this.usuario = usuario;
    }

    public int getId_estadisticas() {
        return id_estadisticas;
    }

    public void setId_estadisticas(int id_estadisticas) {
        this.id_estadisticas = id_estadisticas;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getNumero_veces() {
        return numero_veces;
    }

    public void setNumero_veces(int numero_veces) {
        this.numero_veces = numero_veces;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
