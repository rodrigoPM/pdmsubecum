package com.pdm.sube.cum.DB.models;

import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

@Table(database = MyDB.class)
public class DetalleExamen extends BaseModel {
    @Column
    @PrimaryKey
    int id;

    @Column
    Date fecha;

    @Column
    float nota;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Usuario usuario;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Examen examen;


    public DetalleExamen(int id, Date fecha, float nota, Usuario usuario, Examen examen) {
        this.id = id;
        this.fecha = fecha;
        this.nota = nota;
        this.usuario = usuario;
        this.examen = examen;
    }

    public DetalleExamen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
}
