package com.pdm.sube.cum.ejercicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.util.Log;
import android.view.View;

import com.pdm.sube.cum.DB.models.DetalleExamen;
import com.pdm.sube.cum.DB.models.DetalleExamen_Table;
import com.pdm.sube.cum.DB.models.DetalleSeccion;
import com.pdm.sube.cum.DB.models.DetalleSeccion_Table;
import com.pdm.sube.cum.DB.models.Ejercicio;
import com.pdm.sube.cum.DB.models.EjercicioExamen;
import com.pdm.sube.cum.DB.models.EjercicioExamen_Table;
import com.pdm.sube.cum.DB.models.Ejercicio_Table;
import com.pdm.sube.cum.DB.models.Examen;
import com.pdm.sube.cum.DB.models.Examen_Table;
import com.pdm.sube.cum.DB.models.Leccion;
import com.pdm.sube.cum.DB.models.Leccion_Table;
import com.pdm.sube.cum.DB.models.Seccion;
import com.pdm.sube.cum.DB.models.Seccion_Table;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.leccion.MenuLeccionActivity;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EjercicioContainer extends AppCompatActivity  implements View.OnClickListener {

    boolean primero = true;
    List<Ejercicio> ejercicios;
    List<EjercicioExamen> ejercicioExamenList;
    int contador;
    int len_ejercicios;
    FloatingActionButton fab;
    int id_leccion;
    int id_examen;
    boolean leccion;
    boolean ejercicio_actual = true;
    float nota;
    int aprobadas = 0;
    int reprobadas = 0;
    int aproTemp = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_container);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getIntent().getExtras().getString("tipo").equals("leccion")){
            id_leccion = getIntent().getExtras().getInt("id_leccion");
            ejercicios = SQLite.select().from(Ejercicio.class).where(Ejercicio_Table.leccion_id.is(id_leccion)).queryList();
            len_ejercicios = ejercicios.size();

            leccion = true;
        }
        else{
            id_examen = getIntent().getExtras().getInt("id_examen");
            ejercicioExamenList = SQLite.select().from(EjercicioExamen.class)
                    .where(EjercicioExamen_Table.examen_id.eq(id_examen)).queryList();
            ejercicios = new ArrayList<>();
            for(EjercicioExamen ejercicioExamen: ejercicioExamenList){
                ejercicios.add(SQLite.select().from(Ejercicio.class).where(Ejercicio_Table.id
                        .eq(ejercicioExamen.getEjercicio().getId())).querySingle());
            }

            len_ejercicios = ejercicios.size();
            leccion = false;
        }

        Log.d("total de ejercicio"," -> "+len_ejercicios);
        contador = 0;

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.fade_in)
                .add(R.id.contenedorEjercicios,new EjercicicioUno())
                .commit();

        fab = findViewById(R.id.fab);
        fab.setScaleX(0);
        fab.setScaleY(0);

        fab.setOnClickListener(this);

    }

    public Ejercicio getEjercicio(){
        Ejercicio ejercicioTemp = ejercicios.get(contador);
        contador++;
        consolidarEstadoEjercicio();
        return ejercicioTemp;
    }
    public void consolidarEstadoEjercicio(){
        if(contador > 1){
            if(aproTemp >0){
                aprobadas++;
                if(!getTipo()){
                    ejercicioExamenList.get(contador-1).setEstado_ejercicio(true);
                }
            }else{
                reprobadas++;
            }
            aproTemp = 0;
        }
    }

    public void mostrarBoton(){
        fab.animate()
                .scaleX(1)
                .scaleY(1);
    }
    public void ocultarBoton(){
        fab.setScaleX(0);
        fab.setScaleY(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fab:
                Fragment f = null;
                if(contador != len_ejercicios){
                    if(primero) {
                        f = new EjercicioDos();
                    } else {
                        f = new EjercicicioUno();
                    }
                    primero = !primero;
                }else{
                    consolidarEstadoEjercicio();
                    f = new Completado();
                }
                ocultarBoton();
                getSupportFragmentManager()
                        .beginTransaction()
                        .setTransition(android.R.anim.slide_out_right)
                        .replace(R.id.contenedorEjercicios, f)
                        .commit();
                break;
        }
    }
    public void setEstado(Boolean estadoEjercicio){
        if(estadoEjercicio){
            aproTemp++;
        }
    }

    public void salir(){
        Seccion seccion;
        Leccion leccion = null;
        if(!getTipo()){
            DetalleExamen detalleExamen = SQLite.select().from(DetalleExamen.class).where(DetalleExamen_Table.examen_id.eq(id_examen)).querySingle();
            detalleExamen.setNota(nota);
            detalleExamen.setFecha(new Date());
            detalleExamen.update();
            seccion = SQLite.select().from(Seccion.class).where(Seccion_Table.id.eq(id_examen)).querySingle();

        }else{
            seccion = SQLite.select().from(Seccion.class).where(Seccion_Table.id
                    .eq(SQLite.select().from(Leccion.class).where(Leccion_Table.id.eq(id_leccion)).querySingle().getSeccion().getId()))
                    .querySingle();
            leccion = SQLite.select().from(Leccion.class).where(Leccion_Table.id.eq(id_leccion)).querySingle();
        }

        DetalleSeccion detalleSeccion = SQLite.select().from(DetalleSeccion.class).where(DetalleSeccion_Table.seccion_id.eq(seccion.getId())).querySingle();
        if(!getTipo()){
            if(nota > 7.0){
                detalleSeccion.setEstado_examen(true);
                detalleSeccion.setEstado_seccion(true);
            }
        }else{
            if(nota > 7.0){
                leccion.setEstado(true);
                leccion.update();
            }
        }
        List<Leccion> leccionList = SQLite.select().from(Leccion.class).where(Leccion_Table.seccion_id.eq(seccion.getId())).queryList();
        int count = 0;
        for(Leccion leccionItem: leccionList){
            if(leccionItem.isEstado()){
               count++;
            }
        }
        detalleSeccion.setLecciones_aprobadas(count);
        detalleSeccion.update();

        finish();
    }
    public boolean getTipo(){return leccion;}

    public int totalEjercicios(){
        return len_ejercicios;
    }
    public int getAprobadas(){
        return aprobadas;
    }
    public int getReprobadas(){
        return reprobadas;
    }
    public float getNota(){
        return aprobadas/len_ejercicios*10;
    }


}
