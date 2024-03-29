package com.pdm.sube.cum.DB.models;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.pdm.sube.cum.DB.MyDB;


@Table(database = MyDB.class)
public class Ejercicio extends BaseModel {
    @Column
    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    String imagen;

    @Column
    String audio;

    @Column
    String respuesta;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Leccion leccion;


    public Ejercicio(int id, String imagen, String audio, String respuesta, Leccion leccion) {
        this.id = id;
        this.imagen = imagen;
        this.audio = audio;
        this.respuesta = respuesta;
        this.leccion = leccion;
    }

    public Ejercicio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String  getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Leccion getLeccion() {
        return leccion;
    }

    public void setLeccion(Leccion leccion) {
        this.leccion = leccion;
    }
}
