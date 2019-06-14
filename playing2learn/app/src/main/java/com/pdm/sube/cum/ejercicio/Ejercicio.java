package com.pdm.sube.cum.ejercicio;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pdm.sube.cum.R;

public class Ejercicio extends AppCompatActivity implements EjercicioFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
