package com.pdm.sube.cum.leccion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pdm.sube.cum.R;

public class menuLeccionActivity extends AppCompatActivity implements LeccionFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_leccion);
    }

    @Override
    public void onListFragmentInteraction(LeccionItem item) {

    }
}
