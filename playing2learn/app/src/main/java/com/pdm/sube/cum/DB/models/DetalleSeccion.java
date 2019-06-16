package com.pdm.sube.cum.DB.models;

import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDB.class)
public class DetalleSeccion extends BaseModel {

    @Column
    @PrimaryKey
    int id;

    @Column
    boolean estado_seccion;

    @Column
    int lecciones_aprobadas;

    @Column
    boolean estado_examen;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Usuario usuario;

    @Column
    @ForeignKey(saveForeignKeyModel = false)
    Seccion seccion;


    public DetalleSeccion(int id, boolean estado_seccion, int lecciones_aprobadas, boolean estado_examen, Usuario usuario, Seccion seccion) {
        this.id = id;
        this.estado_seccion = estado_seccion;
        this.lecciones_aprobadas = lecciones_aprobadas;
        this.estado_examen = estado_examen;
        this.usuario = usuario;
        this.seccion = seccion;
    }

    public DetalleSeccion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEstado_seccion() {
        return estado_seccion;
    }

    public void setEstado_seccion(boolean estado_seccion) {
        this.estado_seccion = estado_seccion;
    }

    public int getLecciones_aprobadas() {
        return lecciones_aprobadas;
    }

    public void setLecciones_aprobadas(int lecciones_aprobadas) {
        this.lecciones_aprobadas = lecciones_aprobadas;
    }

    public boolean isEstado_examen() {
        return estado_examen;
    }

    public void setEstado_examen(boolean estado_examen) {
        this.estado_examen = estado_examen;
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
