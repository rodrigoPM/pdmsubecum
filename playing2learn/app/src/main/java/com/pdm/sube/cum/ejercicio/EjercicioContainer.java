package com.pdm.sube.cum.ejercicio;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import com.pdm.sube.cum.DB.models.Ejercicio;
import com.pdm.sube.cum.DB.models.Ejercicio_Table;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.leccion.menuLeccionActivity;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class EjercicioContainer extends AppCompatActivity  implements View.OnClickListener {

    boolean primero = true;
    List<Ejercicio> ejercicios;
    int contador;
    int len_ejercicios;
    FloatingActionButton fab;

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
        final Interpolator interpolador = AnimationUtils.loadInterpolator(getBaseContext(),
                android.R.interpolator.fast_out_slow_in);

        fab.animate()
                .scaleX(1)
                .scaleY(1)
                .setInterpolator(interpolador)
                .setDuration(600)
                .setStartDelay(1000)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        /*fab.animate()
                                .scaleY(0)
                                .scaleX(0)
                                .setInterpolator(interpolador)
                                .setDuration(600)
                                .start();*/
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
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
        startActivity(new Intent(this, menuLeccionActivity.class));
    }



}
