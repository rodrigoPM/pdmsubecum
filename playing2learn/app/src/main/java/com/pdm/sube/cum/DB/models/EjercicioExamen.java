package com.pdm.sube.cum.DB.models;

import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDB.class)
public class EjercicioExamen extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    boolean estado_ejercicio;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Examen examen;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Ejercicio ejercicio;

    public EjercicioExamen(int id, boolean estado_ejercicio, Examen examen, Ejercicio ejercicio) {
        this.id = id;
        this.estado_ejercicio = estado_ejercicio;
        this.examen = examen;
        this.ejercicio = ejercicio;
    }

    public EjercicioExamen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstado_ejercicio() {
        return estado_ejercicio;
    }

    public void setEstado_ejercicio(boolean estado_ejercicio) {
        this.estado_ejercicio = estado_ejercicio;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Ejercicio getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }
}
