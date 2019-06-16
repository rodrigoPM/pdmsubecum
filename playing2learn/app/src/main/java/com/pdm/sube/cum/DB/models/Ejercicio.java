package com.pdm.sube.cum.DB.models;

import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDB.class)
public class Ejercicio extends BaseModel {
    @Column
    @PrimaryKey
    int id;

    @Column
    int imagen;

    @Column
    int audio;

    @Column
    String respuesta;

    @Column
    boolean estado;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Leccion leccion;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Examen examen;

    public Ejercicio(int id, int imagen, int audio, String respuesta, boolean estado, Leccion leccion, Examen examen) {
        this.id = id;
        this.imagen = imagen;
        this.audio = audio;
        this.respuesta = respuesta;
        this.estado = estado;
        this.leccion = leccion;
        this.examen = examen;
    }

    public Ejercicio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Leccion getLeccion() {
        return leccion;
    }

    public void setLeccion(Leccion leccion) {
        this.leccion = leccion;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }
}
