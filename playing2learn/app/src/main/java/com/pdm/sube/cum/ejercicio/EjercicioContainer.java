package com.pdm.sube.cum.ejercicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.pdm.sube.cum.DB.models.Ejercicio;
import com.pdm.sube.cum.DB.models.EjercicioExamen;
import com.pdm.sube.cum.DB.models.EjercicioExamen_Table;
import com.pdm.sube.cum.DB.models.Ejercicio_Table;
import com.pdm.sube.cum.DB.models.Examen;
import com.pdm.sube.cum.DB.models.Examen_Table;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.leccion.MenuLeccionActivity;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

public class EjercicioContainer extends AppCompatActivity  implements View.OnClickListener {

    boolean primero = true;
    List<Ejercicio> ejercicios;
    int contador;
    int len_ejercicios;
    FloatingActionButton fab;
    int id_leccion;
    int id_examen;
    boolean leccion;

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
            List<EjercicioExamen> ejercicioExamenList = SQLite.select().from(EjercicioExamen.class)
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

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorEjercicios,new EjercicicioUno())
                .commit();

        fab = findViewById(R.id.fab);
        fab.setScaleX(0);
        fab.setScaleY(0);

        fab.setOnClickListener(this);

    }

    public Ejercicio getEjercicio(){
        Ejercicio ejercicioTemp = ejercicios.get(contador);
        contador++;
        return ejercicioTemp;
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
                    f = new Completado();
                }
                ocultarBoton();
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedorEjercicios, f)
                        .commit();

                break;
        }
    }

    public void salir(){
        startActivity(new Intent(this, MenuLeccionActivity.class));
    }
    public boolean getTipo(){return leccion;}


}
