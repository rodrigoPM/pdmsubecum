package com.pdm.sube.cum.DB.models;

import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDB.class)
public class Usuario extends BaseModel {
    @Column
    @PrimaryKey
    int id;

    @Column
    String usuario;

    @Column
    String password;

    @Column
    String correo;

    @Column
    boolean estado;

    public Usuario(int id, String usuario, String password, String correo, boolean estado) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.correo = correo;
        this.estado = estado;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
