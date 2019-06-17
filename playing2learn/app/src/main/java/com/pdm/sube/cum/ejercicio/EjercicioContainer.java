package com.pdm.sube.cum.ejercicio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.pdm.sube.cum.DB.models.Ejercicio;
import com.pdm.sube.cum.DB.models.Ejercicio_Table;
import com.pdm.sube.cum.R;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class EjercicioContainer extends AppCompatActivity {

    boolean primero = true;
    List<Ejercicio> ejercicios;
    int contador;
    int len_ejercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_container);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ejercicios = SQLite.select().from(Ejercicio.class).where(Ejercicio_Table.leccion_id.is(getIntent().getExtras().getInt("id_leccion"))).queryList();
        len_ejercicios = ejercicios.size();
        Log.d("Tamano de lista","-> "+len_ejercicios);
        contador = 0;

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorEjercicios,new EjercicicioUno())
                .commit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = null;

                if(primero) {
                    f = new EjercicioDos();
                } else {
                    f = new EjercicicioUno();
                }

                primero = !primero;

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedorEjercicios, f)
                        .commit();
            }
        });
    }

    public Ejercicio getEjercicio(){
        return ejercicios.get(++contador);
    }


}
