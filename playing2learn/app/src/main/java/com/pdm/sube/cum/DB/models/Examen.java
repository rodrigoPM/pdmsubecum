package com.pdm.sube.cum.DB.models;

import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

@Table(database = MyDB.class)
public class Examen extends BaseModel {
    @Column
    @PrimaryKey
    int id;

    @Column
    String nombre;

    @Column
    float nota;

    @Column
    Date fecha;

    @Column
    int imagen;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Usuario usuario;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Seccion seccion;

    public Examen(int id, String nombre, float nota, Date fecha, int imagen, Usuario usuario, Seccion seccion) {
        this.id = id;
        this.nombre = nombre;
        this.nota = nota;
        this.fecha = fecha;
        this.imagen = imagen;
        this.usuario = usuario;
        this.seccion = seccion;
    }

    public Examen() {
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

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }
}
