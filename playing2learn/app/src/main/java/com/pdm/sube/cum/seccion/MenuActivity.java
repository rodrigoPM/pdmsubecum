package com.pdm.sube.cum.seccion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.pdm.sube.cum.DB.models.Seccion;
import com.pdm.sube.cum.R;
import com.pdm.sube.cum.leccion.menuLeccionActivity;
import com.pdm.sube.cum.seccion.SeccionFragment;
import com.pdm.sube.cum.seccion.SeccionItem;


public class MenuActivity extends AppCompatActivity implements SeccionFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }


    @Override
    public void onListFragmentInteraction(Seccion item) {
        Intent intent;
        intent = new Intent(this,menuLeccionActivity.class);
        intent.putExtra("id", item.getId());
        Toast.makeText(this,"id: "+item.getId(),Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }
}
