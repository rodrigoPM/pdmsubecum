package com.pdm.sube.cum.DB.models;

import com.pdm.sube.cum.DB.MyDB;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDB.class)
public class Menu extends BaseModel {

    @Column
    @PrimaryKey
    int id;

    @Column
    int totalSecciones;

    public Menu(int id, int totalSecciones) {
        this.id = id;
        this.totalSecciones = totalSecciones;
    }

    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalSecciones() {
        return totalSecciones;
    }

    public void setTotalSecciones(int totalSecciones) {
        this.totalSecciones = totalSecciones;
    }
}
