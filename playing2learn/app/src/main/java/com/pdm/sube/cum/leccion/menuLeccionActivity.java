package com.pdm.sube.cum.leccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.pdm.sube.cum.DB.models.Leccion;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.ejercicio.EjercicioContainer;

public class menuLeccionActivity extends AppCompatActivity implements LeccionFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_leccion);
    }

    @Override
    public void onListFragmentInteraction(Leccion item) {
        Intent intent = new Intent(this, EjercicioContainer.class);
        intent.putExtra("id_leccion", item.getId());
        Toast.makeText(this,"id: "+item.getId(),Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
