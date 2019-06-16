package com.pdm.sube.cum.leccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pdm.sube.cum.DB.models.Leccion;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.ejercicio.Ejercicio;

public class menuLeccionActivity extends AppCompatActivity implements LeccionFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_leccion);
    }

    @Override
    public void onListFragmentInteraction(Leccion item) {
        startActivity(new Intent(this, Ejercicio.class));
    }
}
