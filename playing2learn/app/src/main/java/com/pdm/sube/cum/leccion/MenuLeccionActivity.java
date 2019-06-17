package com.pdm.sube.cum.leccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.pdm.sube.cum.DB.models.Examen;
import com.pdm.sube.cum.DB.models.Leccion;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.ejercicio.EjercicioContainer;

public class MenuLeccionActivity extends AppCompatActivity implements LeccionFragment.OnListFragmentInteractionListener, ExamenFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_leccion);
    }

    @Override
    public void onListFragmentInteraction(Leccion item) {
        Intent intent = new Intent(this, EjercicioContainer.class);
        intent.putExtra("tipo","leccion");
        intent.putExtra("id_leccion", item.getId());
        startActivity(intent);
    }

    @Override
    public void onListFragmentInteraction(Examen item) {
        Intent intent = new Intent(this, EjercicioContainer.class);
        intent.putExtra("tipo","examen");
        intent.putExtra("id_examen", item.getId());
        startActivity(intent);
    }
}
